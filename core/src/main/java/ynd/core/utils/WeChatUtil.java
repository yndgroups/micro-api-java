package ynd.core.utils;

import ynd.core.exception.CustomException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.weixin.sdk.api.PaymentApi;
import com.jfinal.weixin.sdk.kit.PaymentKit;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WeChatUtil {

    /**
     * description 获取用户信息
     *
     * @param wxAppId  微信id
     * @param wxSecret 微信密钥
     * @param code     微信code
     * @return java.lang.String
     * @author yangdaqiong
     * @date 2021-06-19 12:53:45
     **/
    public static String getWeChatUserInfo(String wxAppId, String wxSecret, String code) {
        String requestUrl = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=s%&secret=s%&code=s%&grant_type=authorization_code", wxAppId, wxSecret, code);
        return HttpRequestUtil.get(requestUrl);
    }

    /**
     * description 支付
     *
     * @param request
     * @param orderNo
     * @param totalAmount
     * @param openId
     * @param wxAppId
     * @param mchId
     * @return Map<String, String>
     * @author yangdaqiong
     * @date 2019-11-22 21:30
     **/
    public static Map<String, String> setPayInfo(HttpServletRequest request, String orderNo, BigDecimal totalAmount, String openId, String wxAppId, String mchId, String notifyUrl, String paterNerKey) {
        String basePath = request.getScheme() + "//" + request.getServerName() + ":" + request.getContextPath();
        BigDecimal totals = new BigDecimal(100);
        Integer priceTotal = totalAmount.multiply(totals).intValue();
        Map<String, String> params = new HashMap<String, String>(12);
        params.put("appid", wxAppId);
        params.put("mch_id", mchId);
        params.put("body", "充值或支付");
        params.put("out_trade_no", orderNo);
        params.put("total_fee", String.valueOf(priceTotal));
        String ip = CommonUtil.getIpAddress();
        params.put("spbill_create_ip", ip);
        params.put("trade_type", PaymentApi.TradeType.JSAPI.name());
        params.put("nonce_str", System.currentTimeMillis() / 1000 + "");
        params.put("notify_url", notifyUrl);
        params.put("openid", openId);
        String sign = PaymentKit.createSign(params, paterNerKey);
        params.put("sign", sign);
        return params;
    }

    /**
     * description
     *
     * @param result
     * @return Map<String, String>
     * @author yangdaqiong
     * @date 2019-11-23 00:30
     **/
    public static Map<String, String> weChatBackXml(Map<String, String> result, String wxAppId, String paterNerKey) {
        Map<String, String> maps = new HashMap<String, String>(2);
        String returnCode = result.get("return_code");
        String returnMsg = result.get("return_msg");
        String success = "SUCCESS";
        if (StringUtils.isBlank(returnCode) || !success.equals(returnCode)) {
            maps.put("return_msg", returnMsg);
            return maps;
        }
        String resultCode = result.get("result_code");
        if (StringUtils.isBlank(resultCode) || !success.equals(resultCode)) {
            maps.put("return_msg", returnMsg);
            return maps;
        }
        // 以下字段在return_code 和result_code都为SUCCESS的时候有返回
        return getPackageParams(result.get("prepay_id"),wxAppId, paterNerKey );
    }

    /**
     * description 获取签名
     *
     * @param prepayId
     * @return Map<String, String>
     * @author yangdaqiong
     * @date 2020-08-13 00:43
     */
    private static Map<String, String> getPackageParams(String prepayId, String wxAppId, String paterNerKey) {
        Map<String, String> packageParams = new HashMap<String, String>(6);
        packageParams.put("appId", wxAppId);
        packageParams.put("timeStamp", System.currentTimeMillis() / 1000 + "");
        packageParams.put("nonceStr", System.currentTimeMillis() + "");
        packageParams.put("package", "prepay_id=" + prepayId);
        packageParams.put("signType", "MD5");
        String packageSign = PaymentKit.createSign(packageParams, paterNerKey);
        packageParams.put("paySign", packageSign);
        return packageParams;
    }

    /**
     * description js-sdk授权信息获取
     *
     * @param jsApiTicket
     * @return randomUrl
     * @author yangdaqiong
     * @date 2019-11-20 23:11
     **/
    public static Map<String, String> sign(String jsApiTicket, String randomUrl) {
        Map<String, String> ret = new HashMap<String, String>(5);
        String nonceStr = createNonceStr();
        String timestamp = createTimestamp();
        //注意这里参数名必须全部小写，且必须有序
        String string1 = "jsapi_ticket=" + jsApiTicket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + randomUrl;
        String signature = WeChatUtil.sha1(string1);
        ret.put("url", randomUrl);
        ret.put("jsapi_ticket", jsApiTicket);
        ret.put("nonceStr", nonceStr);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);
        return ret;
    }

    /**
     * description SHA1加密
     *
     * @param str
     * @return String
     * @author yangdaqiong
     * @date 2019/11/20 23:12
     **/
    private static String sha1(String str) {
        try {
            //如果是SHA加密只需要将"SHA-1"改成"SHA"即可
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(str.getBytes());
            byte[] messageDigest = digest.digest();
            // Create Hex String
            StringBuffer hexStr = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexStr.append(0);
                }
                hexStr.append(shaHex);
            }
            return hexStr.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * description 获取accessToken
     *
     * @param wxAppId  微信你id
     * @param wxSecret 微信密钥
     * @return java.lang.Object
     * @author yangdaqiong
     * @date 2021-06-19 13:12:00
     **/
    public static String getAccessToken(String wxAppId, String wxSecret) {
        // 一定记得设置ip白名单，否则 40164
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + wxAppId + "&secret=" + wxSecret;
        String accessToken = HttpRequestUtil.get(url);
        String tokenKey = "access_token";
        JSONObject jsonObject = JSONObject.parseObject(accessToken);
        Map map = JSON.toJavaObject(jsonObject, Map.class);
        if (StringUtils.isNotBlank((CharSequence) map.get(tokenKey))) {
            return jsonObject.get(tokenKey).toString();
        }
        throw new CustomException(0, accessToken);
    }

    /**
     * description 获取js-sdk授权
     *
     * @param accessToken token
     * @return java.lang.String
     * @author yangdaqiong
     * @date 2021-06-19 13:05:09
     **/
    public static String getJsApiTicket(String accessToken) {
        String result = "ok";
        String jsApiTicketUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + accessToken + "&type=jsapi";
        String jsApiTicket = HttpRequestUtil.get(jsApiTicketUrl);
        JSONObject jsonObject = JSONObject.parseObject(jsApiTicket);
        Map map = JSON.toJavaObject(jsonObject, Map.class);
        String errs = map.get("errmsg").toString();
        if (result.equals(errs)) {
            return map.get("ticket").toString();
        } else {
            throw new CustomException(0, jsApiTicket);
        }
    }


    /**
     * description 随机字符串
     *
     * @return java.lang.String
     * @author yangdaqiong
     * @date 2021-06-19 12:58:06
     **/
    private static String createNonceStr() {
        return UUID.randomUUID().toString();
    }


    /**
     * description 获取当前时间错
     *
     * @return java.lang.String
     * @author yangdaqiong
     * @date 2021-06-19 12:56:37
     **/
    private static String createTimestamp() {
        return java.lang.Long.toString(System.currentTimeMillis() / 1000);
    }

    /**
     * description 获取公众号个人微信信息
     *
     *@param accessToken 微信公众好accessToken
     *@param openId 用户id
     *@return BackResult 返回查询结果
     *@author yangdaqiong
     *@date 2021-08-29 14:31:18
     **/
    public static JSONObject getWeChatWebUserInfo(String accessToken, String openId) {
        String url = String.format("https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN", accessToken, openId);
        String userInfo = HttpRequestUtil.get(url);
        if (userInfo.indexOf("nickname") != -1) {
            return JSONObject.parseObject(userInfo);
        } else {
            throw new CustomException(0, userInfo);
        }
    }
}
