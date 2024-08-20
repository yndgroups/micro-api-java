package ynd.order.pojo.dao;

import ynd.order.configuration.PayTypeConfiguration;
import com.egzosn.pay.common.util.sign.SignUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 账户
 *
 * @author egan
 * email egzosn@gmail.com
 * date 2016/11/18 1:21
 */
//@Repository
public class ApyAccountRepository {

    // 这里简单模拟，引入orm等框架之后可自行删除
    public static Map<Integer, PayAccount> apyAccounts = new HashMap<>();

    /**
     * 这里简单初始化，引入orm等框架之后可自行删除
     */
    {
        PayAccount payAccountEntity1 = new PayAccount();
        payAccountEntity1.setPayId(1);
        payAccountEntity1.setPartner("2088102169916436");
        payAccountEntity1.setAppId("2016080400165436");
        // TODO 2017/2/9 16:20 author: egan  sign_type只有单一key时public_key与private_key相等，比如sign_type=MD5的情况
        payAccountEntity1.setPublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB");
        payAccountEntity1.setPrivateKey("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKroe/8h5vC4L6T+B2WdXiVwGsMvUKgb2XsKix6VY3m2wcf6tyzpNRDCNykbIwGtaeo7FshN+qZxdXHLiIam9goYncBit/8ojfLGy2gLxO/PXfzGxYGs0KsDZ+ryVPPmE34ZZ8jiJpR0ygzCFl8pN3QJPJRGTJn5+FTT9EF/9zyZAgMBAAECgYAktngcYC35u7cQXDk+jMVyiVhWYU2ULxdSpPspgLGzrZyG1saOcTIi/XVX8Spd6+B6nmLQeF/FbU3rOeuD8U2clzul2Z2YMbJ0FYay9oVZFfp5gTEFpFRTVfzqUaZQBIjJe/xHL9kQVqc5xHlE/LVA27/Kx3dbC35Y7B4EVBDYAQJBAOhsX8ZreWLKPhXiXHTyLmNKhOHJc+0tFH7Ktise/0rNspojU7o9prOatKpNylp9v6kux7migcMRdVUWWiVe+4ECQQC8PqsuEz7B0yqirQchRg1DbHjh64bw9Kj82EN1/NzOUd53tP9tg+SO97EzsibK1F7tOcuwqsa7n2aY48mQ+y0ZAkBndA2xcRcnvOOjtAz5VO8G7R12rse181HjGfG6AeMadbKg30aeaGCyIxN1loiSfNR5xsPJwibGIBg81mUrqzqBAkB+K6rkaPXJR9XtzvdWb/N3235yPkDlw7Z4MiOVM3RzvR/VMDV7m8lXoeDde2zQyeMOMYy6ztwA6WgE1bhGOnQRAkEAouUBv1sVdSBlsexX15qphOmAevzYrpufKgJIRLFWQxroXMS7FTesj+f+FmGrpPCxIde1dqJ8lqYLTyJmbzMPYw==");
        payAccountEntity1.setNotifyUrl("http://pay.egzosn.com/payBack1.json");

        // 无需同步回调可不填
        payAccountEntity1.setReturnUrl("http://pay.egzosn.com/payBack1.json");
        payAccountEntity1.setInputCharset("UTF-8");
        payAccountEntity1.setSeller("2088102169916436");
        payAccountEntity1.setSignType(SignUtils.RSA.name());
        payAccountEntity1.setPayTypeConfiguration(PayTypeConfiguration.aliPay);
        //设置测试环境
        payAccountEntity1.setTest(true);
        apyAccounts.put(payAccountEntity1.getPayId(), payAccountEntity1);

        PayAccount payAccountEntity2 = new PayAccount();
        payAccountEntity2.setPayId(2);
        payAccountEntity2.setPartner("1469188802");
        payAccountEntity2.setAppId("wx3344f4aed352de09");
        // TODO 2017/2/9 16:20 author: egan  sign_type只有单一key时public_key与private_key相等，比如sign_type=MD5的情况
        payAccountEntity2.setPublicKey("991ded080***************f7fc61095");
        payAccountEntity2.setPrivateKey("991ded080***************f7fc61095");
        payAccountEntity2.setNotifyUrl("http://pay.egzosn.com/payBack2.json");
        // 无需同步回调可不填
        payAccountEntity2.setReturnUrl("http://pay.egzosn.com");
        payAccountEntity2.setInputCharset("UTF-8");
        payAccountEntity2.setSeller("1469188802");
        payAccountEntity2.setSignType(SignUtils.MD5.name());
        payAccountEntity2.setPayTypeConfiguration(PayTypeConfiguration.wxPay);
        //设置测试环境
        payAccountEntity2.setTest(false);
        apyAccounts.put(payAccountEntity2.getPayId(), payAccountEntity2);

        PayAccount payAccountEntity3 = new PayAccount();
        payAccountEntity3.setPayId(3);
        payAccountEntity3.setPartner("12****601");
        payAccountEntity3.setAppId("wxa39*****ba9e9");
        payAccountEntity3.setPublicKey("48gf0i************h9eiut9");
        payAccountEntity3.setPrivateKey("48gf0i************h9eiut9");
        payAccountEntity3.setNotifyUrl("http://pay.egan.in/payBack3.json");
        // 无需同步回调可不填  app填这个就可以
        payAccountEntity3.setReturnUrl("http://pay.egan.in/payBack3.json");
        payAccountEntity3.setSeller("12****601");
        payAccountEntity3.setInputCharset("UTF-8");
        payAccountEntity3.setSignType(SignUtils.MD5.name());
        payAccountEntity3.setPayTypeConfiguration(PayTypeConfiguration.wxPay);
        apyAccounts.put(payAccountEntity3.getPayId(), payAccountEntity3);

        PayAccount payAccountEntity4 = new PayAccount();
        payAccountEntity4.setPayId(4);
        payAccountEntity4.setPartner("700000000000001");
        //公钥，验签证书链格式： 中级证书路径;根证书路径
        payAccountEntity4.setPublicKey("D:/certs/acp_test_middle.cer;D:/certs/acp_test_root.cer");
        //私钥, 私钥证书格式： 私钥证书路径;私钥证书对应的密码
        payAccountEntity4.setPrivateKey("D:/certs/acp_test_sign.pfx;000000");
        payAccountEntity4.setNotifyUrl("http://127.0.0.1/payBack4.json");
        // 无需同步回调可不填  app填这个就可以
        payAccountEntity4.setReturnUrl("http://127.0.0.1/payBack4.json");
        payAccountEntity4.setSeller("");
        payAccountEntity4.setInputCharset("UTF-8");
        payAccountEntity4.setSignType(SignUtils.RSA2.name());
        payAccountEntity4.setPayTypeConfiguration(PayTypeConfiguration.unionPay);
        payAccountEntity4.setTest(true);
        apyAccounts.put(payAccountEntity4.getPayId(), payAccountEntity4);

        PayAccount payAccountEntity5 = new PayAccount();
        payAccountEntity5.setPayId(5);
        payAccountEntity5.setPartner("100086190");//Program ID
        payAccountEntity5.setSeller("egan6190");//Username
        payAccountEntity5.setStorePassword("12BkDT8152Zj");//API password
        payAccountEntity5.setInputCharset("UTF-8");
        payAccountEntity5.setPayTypeConfiguration(PayTypeConfiguration.payoneer);
        payAccountEntity5.setTest(true);
        apyAccounts.put(payAccountEntity5.getPayId(), payAccountEntity5);

        PayAccount payAccountEntity6 = new PayAccount();
        payAccountEntity6.setPayId(6);
        payAccountEntity6.setAppId("1AZ7HTcvrEAxYbzYx_iDZAi06GdqbjhqqQzFgPBFLxm2VUMzwlmiNUBk_y_5QNP4zWKblTuM6ZBAmxScd");//Program ID
        payAccountEntity6.setPrivateKey("1EBMIjAag6NiRdXZxteTv0amEsmKN345xJv3bN7f_HRXSqcRJlW7PXhYXjI9sk5I4nKYOHgeqzhXCXKFo");//API password
        payAccountEntity6.setInputCharset("UTF-8");
        payAccountEntity6.setPayTypeConfiguration(PayTypeConfiguration.payPal);
        payAccountEntity6.setTest(true);
        apyAccounts.put(payAccountEntity6.getPayId(), payAccountEntity6);
    }

    /**
     * 根据id获取对应的账户信息
     *
     * @param payId 账户id
     * @return 账户信息
     */
    public PayAccount findByPayId(Integer payId) {
        return apyAccounts.get(payId);
    }
}
