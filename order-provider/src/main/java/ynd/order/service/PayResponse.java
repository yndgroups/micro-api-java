package ynd.order.service;

import javax.annotation.Resource;

import ynd.order.pojo.dao.PayAccount;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import com.egzosn.pay.common.api.PayConfigStorage;
import com.egzosn.pay.common.api.PayMessageHandler;
import com.egzosn.pay.common.api.PayMessageRouter;
import com.egzosn.pay.common.api.PayService;
import com.egzosn.pay.common.http.HttpConfigStorage;
import ynd.order.configuration.PayTypeConfiguration;
import ynd.order.handler.AliPayMessageHandler;
import ynd.order.handler.FuiouPayMessageHandler;
import ynd.order.handler.PayoneerMessageHandler;
import ynd.order.handler.UnionPayMessageHandler;
import ynd.order.handler.WxPayMessageHandler;
import ynd.order.handler.YouDianPayMessageHandler;
import ynd.order.interceptor.AliPayMessageInterceptor;
import ynd.order.interceptor.YoudianPayMessageInterceptor;

/**
 * 支付响应对象
 *
 * @author egan
 * email egzosn@gmail.com
 * date 2016/11/18 0:34
 */
public class PayResponse {

    @Resource
    private AutowireCapableBeanFactory spring;

    private PayConfigStorage storage;

    private PayService service;

    private PayMessageRouter router;

    public PayResponse() {

    }

    /**
     * 初始化支付配置
     *
     * @param payAccountEntity 账户信息
     * @see PayAccount 对应表结构详情--》 /pay-java-demo/resources/apy_account.sql
     */
    public void init(PayAccount payAccountEntity) {
        //根据不同的账户类型 初始化支付配置
        this.service = payAccountEntity.getPayTypeConfiguration().getPayService(payAccountEntity);
        this.storage = service.getPayConfigStorage();
        //这里设置http请求配置
//        service.setRequestTemplateConfigStorage(getHttpConfigStorage());
        buildRouter(payAccountEntity.getPayId());
    }

    /**
     * 获取http配置，如果配置为null则为默认配置，无代理,无证书的请求方式。
     * 此处非必需
     *
     * @param payAccountEntity 账户信息
     * @return 请求配置
     */
    public HttpConfigStorage getHttpConfigStorage(PayAccount payAccountEntity) {
        HttpConfigStorage httpConfigStorage = new HttpConfigStorage();
        /* 网路代理配置 根据需求进行设置*/
//        //http代理地址
//        httpConfigStorage.setHttpProxyHost("192.168.1.69");
//        //代理端口
//        httpConfigStorage.setHttpProxyPort(3308);
//        //代理用户名
//        httpConfigStorage.setHttpProxyUsername("user");
//        //代理密码
//        httpConfigStorage.setHttpProxyPassword("password");
        //设置ssl证书路径 https证书设置 方式二
        httpConfigStorage.setKeystore(payAccountEntity.getKeystorePath());
        //设置ssl证书对应的密码
        httpConfigStorage.setStorePassword(payAccountEntity.getStorePassword());
        return httpConfigStorage;
    }


    /**
     * 配置路由
     *
     * @param payId 指定账户id，用户多微信支付多支付宝支付
     */
    private void buildRouter(Integer payId) {
        router = new PayMessageRouter(this.service);
        router
                .rule()
                //消息类型
                //支付账户事件类型
                .payType(PayTypeConfiguration.aliPay.name())
                //拦截器
                .interceptor(new AliPayMessageInterceptor())
                //处理器
                .handler(spring.getBean(AliPayMessageHandler.class))
                .end()
                .rule()
                .payType(PayTypeConfiguration.wxPay.name())
                .handler(autowire(new WxPayMessageHandler(payId)))
                .end()
                .rule()
                .payType(PayTypeConfiguration.youdianPay.name())
                .interceptor(new YoudianPayMessageInterceptor()) //拦截器
                .handler(autowire(new YouDianPayMessageHandler(payId)))
                .end()
                .rule()
                .payType(PayTypeConfiguration.fuiou.name())
                .handler(autowire(new FuiouPayMessageHandler(payId)))
                .end()
                .rule()
                .payType(PayTypeConfiguration.unionPay.name())
                .handler(autowire(new UnionPayMessageHandler(payId)))
                .end()
                .rule()
                .payType(PayTypeConfiguration.payoneer.name())
                .handler(autowire(new PayoneerMessageHandler(payId)))
                .end()
                .rule()
                .payType(PayTypeConfiguration.payPal.name())
                .handler(spring.getBean(AliPayMessageHandler.class))
                .end()
        ;
    }


    private PayMessageHandler autowire(PayMessageHandler handler) {
        spring.autowireBean(handler);
        return handler;
    }

    public PayConfigStorage getStorage() {
        return storage;
    }

    public PayService getService() {
        return service;
    }

    public PayMessageRouter getRouter() {
        return router;
    }
}
