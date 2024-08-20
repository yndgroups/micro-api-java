
package ynd.order.controller;


import ynd.core.exception.CustomException;
import ynd.core.result.BackResult;
import ynd.core.service.RedisUserService;
import ynd.order.pojo.dao.OrderModel;
import com.egzosn.pay.common.bean.*;
import com.egzosn.pay.common.http.HttpConfigStorage;
import com.egzosn.pay.wx.api.WxPayConfigStorage;
import com.egzosn.pay.wx.api.WxPayService;
import com.egzosn.pay.wx.bean.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * description wechatPay
 *
 * @author yangdaqiong
 * @date 2021-08-12 23:37:36
 **/
@Api(tags = {"微信支付"})
@RestController
@RequestMapping("/pay/wx")
public class WechatPayController {

    @Autowired
    private RedisUserService redisUserService;

    private WxPayService service = null;

    //ssl 退款证书相关 不使用可注释
    private static String KEYSTORE = "ssl 退款证书";

    @PostConstruct
    public void init() {
        WxPayConfigStorage wxPayConfigStorage = new WxPayConfigStorage();
        wxPayConfigStorage.setAppId("wx2fc7b742aa6d5edc"); // 公众账号ID
        wxPayConfigStorage.setSecretKey("LSs0S2PwZPZd4nRko8AXdFaiLNQ8Bkrp"); // 公众钥
        wxPayConfigStorage.setMchId("1612530344"); // 合作者id（商户号）
        wxPayConfigStorage.setSignType("MD5"); // 签名方式
        //以下两个参数在 服务商版模式中必填--------
        //  wxPayConfigStorage.setSubAppid("子商户公众账号ID");
        //  wxPayConfigStorage.setSubMchId("微信支付分配的子商户号");
        //-----------------------------------------------
        wxPayConfigStorage.setKeyPublic("PzwnS2PwZPZd4nRko8AXdFaiLNQ8Bkrp"); // 转账公钥，转账时必填
        wxPayConfigStorage.setKeyPrivate("PzwnS2PwZPZd4nRko8AXdFaiLNQ8Bkrp"); // 转账公钥，转账时必填

        wxPayConfigStorage.setNotifyUrl("/pay/wx/asyncPayCallBack");// 异步回调地址
        wxPayConfigStorage.setReturnUrl("/pay/wx/payCallBack"); // 同步回调地址
        wxPayConfigStorage.setInputCharset("utf-8");
        service = new WxPayService(wxPayConfigStorage);
        HttpConfigStorage httpConfigStorage = new HttpConfigStorage();

        //ssl 退款证书相关 不使用可注释
        if (!"ssl 退款证书".equals(KEYSTORE)) {
            // TODO 这里也支持输入流的入参。
            //  httpConfigStorage.setKeystore(WxPayController.class.getResourceAsStream("/证书文件"));
            httpConfigStorage.setKeystore(KEYSTORE);
            httpConfigStorage.setStorePassword("ssl 证书对应的密码， 默认为商户号");
            //设置ssl证书对应的存储方式，这里默认为文件地址
            httpConfigStorage.setCertStoreType(CertStoreType.PATH);
        }
        //请求连接池配置
        //最大连接数
        httpConfigStorage.setMaxTotal(20);
        //默认的每个路由的最大连接数
        httpConfigStorage.setDefaultMaxPerRoute(10);
        service.setRequestTemplateConfigStorage(httpConfigStorage);

        //设置回调消息处理
        //TODO {@link com.egzosn.pay.demo.controller.WxPayController#payBack}
        //service.setPayMessageHandler(new WxPayMessageHandler(null));
    }

    /**
     * description 公众号支付
     *
     * @return BackResult 返回jsapi所需参数
     * @author yangdaqiong
     * @date 2021-08-13 22:38:32
     **/
    @ApiOperation("公众号支付")
    @PostMapping("jsapi")
    public BackResult createJsapiPay() throws Exception {
        BigDecimal price = new BigDecimal("0.01");
        PayOrder order = new PayOrder("st order", "lajiao", null == price ? BigDecimal.valueOf(0.01) : price, UUID.randomUUID().toString().replace("-", ""), WxTransactionType.JSAPI);
        String openId = redisUserService.getAuthUser().getOpenId();
        if (openId != null) {
            order.setOpenid(openId);
        } else {
            throw new CustomException(0, "openid o exit");
        }
        Map orderInfo = service.orderInfo(order);
        return BackResult.success(orderInfo);
    }

    /**
     * description
     *
     * @param
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-08-15 13:13:22
     **/
    @ApiOperation("异步回调地址")
    @GetMapping("/asyncPayCallBack")
    public String asyncPayCallBack(HttpServletRequest request) throws IOException {
        return service.payBack(request.getParameterMap(), request.getInputStream()).toMessage();
    }

    @ApiOperation("同步回调地址")
    @GetMapping("/payCallBack")
    public BackResult payCallBack(HttpServletRequest request) {
        return BackResult.success("suces");
    }

    /**
     * description 跳到支付页面->针对实时支付
     *
     * @param request 请求
     * @param price   金额
     * @return BackResult 跳到支付页面
     * @author yangdaqiong
     * @date 2021-08-13 22:37:18
     **/
    @ApiOperation("跳到支付页面")
    @GetMapping(value = "toPay.html", produces = "text/html;charset=UTF-8")
    public String toPay(HttpServletRequest request, BigDecimal price) {
        PayOrder order = new PayOrder("订单title", "摘要", null == price ? BigDecimal.valueOf(0.01) : price, UUID.randomUUID().toString().replace("-", ""), WxTransactionType.MWEB);
        order.setSpbillCreateIp(request.getHeader("X-Real-IP"));
        StringBuffer requestURL = request.getRequestURL();
        //设置网页地址
        order.setWapUrl(requestURL.substring(0, requestURL.indexOf("/") > 0 ? requestURL.indexOf("/") : requestURL.length()));
        //设置网页名称
        order.setWapName("在线充值");
        // Map orderInfo = service.orderInfo(order);
        // return service.buildRequest(orderInfo, MethodType.POST);
        return service.toPay(order);
    }

    /**
     * description 获取支付预订单信息
     *
     * @return BackResult 支付预订单信息
     * @author yangdaqiong
     * @date 2021-08-13 22:39:01
     **/
    @ApiOperation("获取支付预订单信息")
    @GetMapping("app")
    public Map<String, Object> app() {
        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        PayOrder order = new PayOrder("订单title", "摘要", BigDecimal.valueOf(0.01), UUID.randomUUID().toString().replace("-", ""));
        //App支付
        order.setTransactionType(WxTransactionType.APP);
        data.put("orderInfo", service.app(order));
        return data;
    }

    /**
     * description 获取二维码图像 -> 二维码支付
     *
     * @param price 金额
     * @return BackResult 二维码图像
     * @throws IOException IOException
     * @author yangdaqiong
     * @date 2021-08-13 22:41:17
     **/
    @ApiOperation("二维码支付 - 获取二维码图像")
    @GetMapping(value = "toQrPay.jpg", produces = "image/jpeg;charset=UTF-8")
    public byte[] toWxQrPay(BigDecimal price) throws IOException {
        //获取对应的支付账户操作工具（可根据账户id）
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(service.genQrPay(new PayOrder("订单title", "摘要", null == price ? BigDecimal.valueOf(0.01) : price, System.currentTimeMillis() + "", WxTransactionType.NATIVE)), "JPEG", baos);
        return baos.toByteArray();
    }

    /**
     * description 获取二维码地址 -> 二维码支付
     *
     * @param price 金额
     * @return BackResult 二维码图像
     * @throws IOException IOException
     * @author yangdaqiong
     * @date 2021-08-13 22:42:19
     **/
    @ApiOperation("二维码支付 - 获取二维码地址")
    @GetMapping(value = "getQrPay")
    public String getQrPay(BigDecimal price) throws IOException {
        //获取对应的支付账户操作工具（可根据账户id）
        return service.getQrPay(new PayOrder("订单title", "摘要", null == price ? BigDecimal.valueOf(0.01) : price, System.currentTimeMillis() + "", WxTransactionType.NATIVE));
    }

    /**
     * description 刷卡付,pos主动扫码付款(条码付)
     *
     * @param price    金额
     * @param authCode 授权码，条码等
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-08-15 13:54:44
     **/
    @ApiOperation("刷卡付,pos主动扫码付款(条码付)")
    @GetMapping("/microPay")
    public Map<String, Object> microPay(BigDecimal price, String authCode) {
        //获取对应的支付账户操作工具（可根据账户id）
        //条码付
        PayOrder order = new PayOrder("egan order", "egan order", null == price ? BigDecimal.valueOf(0.01) : price, UUID.randomUUID().toString().replace("-", ""), WxTransactionType.MICROPAY);
        //设置授权码，条码等
        order.setAuthCode(authCode);
        //支付结果
        Map<String, Object> params = service.microPay(order);
        //校验
        if (service.verify(params)) {
            //支付校验通过后的处理
            //......业务逻辑处理块........
        }
        //这里开发者自行处理
        return params;
    }

    /**
     * 刷脸付
     *
     * @param price    金额
     * @param authCode 人脸凭证
     * @param openid   用户在商户 appid下的唯一标识
     * @return 支付结果
     */
    @ApiOperation("刷脸付")
    @GetMapping("/facePay")
    public Map<String, Object> facePay(BigDecimal price, String authCode, String openid) {
        //获取对应的支付账户操作工具（可根据账户id）
        PayOrder order = new PayOrder("egan order", "egan order", null == price ? BigDecimal.valueOf(0.01) : price, UUID.randomUUID().toString().replace("-", ""), WxTransactionType.FACEPAY);
        //设置人脸凭证
        order.setAuthCode(authCode);
        //  用户在商户 appid下的唯一标识
        order.setOpenid(openid);
        //支付结果
        Map<String, Object> params = service.microPay(order);
        //校验
        if (service.verify(params)) {
            //支付校验通过后的处理
            //......业务逻辑处理块........
        }
        //这里开发者自行处理
        return params;
    }

    /**
     * 支付回调地址 方式一
     * <p>
     * 方式二，{@link #payBack(HttpServletRequest)} 是属于简化方式， 试用与简单的业务场景
     *
     * @param request 请求
     * @return 是否成功
     * @throws IOException IOException
     * @see #payBack(HttpServletRequest)
     */
    @ApiOperation("支付回调地址 方式一")
    @Deprecated
    @GetMapping(value = "payBackBefore.json")
    public String payBackBefore(HttpServletRequest request) throws IOException {

        //获取支付方返回的对应参数
        Map<String, Object> params = service.getParameter2Map(request.getParameterMap(), request.getInputStream());
        if (null == params) {
            return service.getPayOutMessage("fail", "失败").toMessage();
        }

        //校验
        if (service.verify(params)) {
            //这里处理业务逻辑
            //......业务逻辑处理块........
            return service.successPayOutMessage(null).toMessage();
        }

        return service.getPayOutMessage("fail", "失败").toMessage();
    }

    /**
     * 支付回调地址
     *
     * @param request 请求
     * @return 是否成功
     * <p>
     * 业务处理在对应的PayMessageHandler里面处理，在哪里设置PayMessageHandler，详情查看{@link com.egzosn.pay.common.api.PayService#setPayMessageHandler(com.egzosn.pay.common.api.PayMessageHandler)}
     * <p>
     * 如果未设置 {@link com.egzosn.pay.common.api.PayMessageHandler} 那么会使用默认的 {@link com.egzosn.pay.common.api.DefaultPayMessageHandler}
     * @throws IOException IOException
     */
    @ApiOperation("支付回调地址")
    @GetMapping(value = "payBack.json")
    public String payBack(HttpServletRequest request) throws IOException {
        //业务处理在对应的PayMessageHandler里面处理，在哪里设置PayMessageHandler，详情查看com.egzosn.pay.common.api.PayService.setPayMessageHandler()
        return service.payBack(request.getParameterMap(), request.getInputStream()).toMessage();
    }


    /**
     * 查询
     *
     * @param orderModel 订单的请求体
     * @return 返回查询回来的结果集，支付方原值返回
     */
    @ApiOperation("查询")
    @PostMapping("query")
    public Map<String, Object> query(OrderModel orderModel) {
        return service.query(orderModel.getTradeNo(), orderModel.getOutTradeNo());
    }


    /**
     * 交易关闭接口
     *
     * @param orderModel 订单的请求体
     * @return 返回支付方交易关闭后的结果
     */
    @ApiOperation("交易关闭接口")
    @PostMapping("close")
    public Map<String, Object> close(OrderModel orderModel) {
        return service.close(orderModel.getTradeNo(), orderModel.getOutTradeNo());
    }

    /**
     * 申请退款接口
     *
     * @param order 订单的请求体
     * @return 返回支付方申请退款后的结果
     */
    @ApiOperation("申请退款接口")
    @PostMapping("refund")
    public WxRefundResult refund(RefundOrder order) {
        if ("ssl 退款证书".equals(KEYSTORE)) {
            throw new RuntimeException("请设置好SSL退款证书");
        }
        return service.refund(order);
    }

    /**
     * 查询退款
     *
     * @param order 订单的请求体
     * @return 返回支付方查询退款后的结果
     */
    @ApiOperation("查询退款")
    @PostMapping("refundquery")
    public Map<String, Object> refundquery(RefundOrder order) {
        return service.refundquery(order);
    }

    /**
     * 下载对账单
     *
     * @param orderModel 订单的请求体
     * @return 返回支付方下载对账单的结果
     */
    @ApiOperation("下载对账单")
    @PostMapping("downloadbill")
    public Object downloadBill(OrderModel orderModel) {
        return service.downloadBill(orderModel.getBillDate(), orderModel.getBillType());
    }


    /**
     * 转账到余额
     *
     * @param order 转账订单
     * @return 对应的转账结果
     */
    @ApiOperation("转账到余额")
    @PostMapping("transfer")
    public Map<String, Object> transfer(TransferOrder order) {
        order.setOutNo("partner_trade_no 商户转账订单号");
        order.setPayeeAccount("用户openid");
        order.setPayeeName("收款用户姓名， 非必填，如果填写将强制验证收款人姓名");
        order.setRemark("转账备注, 非必填");
        order.setAmount(new BigDecimal(10));

        //转账到余额，这里默认值是转账到银行卡
        order.setTransferType(WxTransferType.TRANSFERS);

        return service.transfer(order);
    }


    /**
     * 转账到银行卡
     *
     * @param order 转账订单
     * @return 对应的转账结果
     */
    @ApiOperation("转账到银行卡")
    @PostMapping("transferPayBank")
    public Map<String, Object> transferPayBank(TransferOrder order) {
        order.setOutNo("partner_trade_no 商户转账订单号");
        //采用标准RSA算法，公钥由微信侧提供,将公钥信息配置在PayConfigStorage#setKeyPublic(String)
        order.setPayeeAccount("enc_bank_no 收款方银行卡号");
        order.setPayeeName("收款方用户名");
        order.setBank(WxBank.ABC);
        order.setRemark("转账备注, 非必填");
        order.setAmount(new BigDecimal(10));
        //转账到银行卡，这里默认值是转账到银行卡
        order.setTransferType(WxTransferType.PAY_BANK);

        return service.transfer(order);
    }

    /**
     * 转账查询
     *
     * @param outNo          商户转账订单号
     * @param wxTransferType 微信转账类型，
     *                       .....这里没办法了只能这样写(┬＿┬)，请见谅
     *                       {@link WxTransferType#QUERY_BANK}
     *                       {@link WxTransferType#GETTRANSFERINFO}
     *
     *                       <p>
     *                       <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=14_3">企业付款到零钱</a>
     *                       <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_3">商户企业付款到银行卡</a>
     *                       </p>
     * @return 对应的转账订单
     */
    @ApiOperation("转账查询")
    @GetMapping("transferQuery")
    public Map<String, Object> transferQuery(String outNo, String wxTransferType) {
        //默认查询银行卡的记录 com.egzosn.pay.wx.bean.WxTransferType#QUERY_BANK
        return service.transferQuery(outNo, wxTransferType);
    }

    /**
     * 微信发红包
     *
     * @param redpackOrder 红包订单
     * @return 结果
     */
    public Map<String, Object> sendredpack(RedpackOrder redpackOrder) {
        redpackOrder.setTransferType(WxSendredpackType.SENDREDPACK);
        return service.sendredpack(redpackOrder);
    }

    /**
     * 发放裂变红包
     *
     * @param redpackOrder 红包订单
     * @return 结果
     */
    public Map<String, Object> sendgroupredpack(RedpackOrder redpackOrder) {
        redpackOrder.setTransferType(WxSendredpackType.SENDGROUPREDPACK);
        return service.sendredpack(redpackOrder);
    }


    /**
     * 小程序发红包
     *
     * @param redpackOrder 红包订单
     * @return 结果
     */
    public Map<String, Object> sendAppletRedEnvelopes(RedpackOrder redpackOrder) {
        redpackOrder.setTransferType(WxSendredpackType.SENDMINIPROGRAMHB);
        return service.sendredpack(redpackOrder);
    }

    /**
     * description 查询红包记录
     * 用于商户对已发放的红包进行查询红包的具体信息，可支持普通红包和裂变包
     * 查询红包记录API只支持查询30天内的红包订单，30天之前的红包订单请登录商户平台查询。
     *
     * @param mchBillNo 商户发放红包的商户订单号
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-08-15 13:59:39
     **/
    public Map<String, Object> queryRedEnvelopesInfo(String mchBillNo) {
        return service.gethbinfo(mchBillNo);
    }

}
