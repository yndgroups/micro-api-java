package ynd.order.handler;

import com.egzosn.pay.common.api.PayService;
import com.egzosn.pay.common.bean.PayMessage;
import com.egzosn.pay.common.bean.PayOutMessage;
import com.egzosn.pay.common.exception.PayErrorException;

import java.util.Map;

/**
 * description FuiouPayMessageHandler
 *
 * @return BackResult
 * @author yangdaqiong
 * @date 2021-08-15 13:45:08
 **/
public class FuiouPayMessageHandler extends BasePayMessageHandler {

    public FuiouPayMessageHandler(Integer payId) {
        super(payId);
    }

    @Override
    public PayOutMessage handle(PayMessage payMessage, Map context, PayService payService) throws PayErrorException {
        //交易状态
        if ("0000".equals(payMessage.getPayMessage().get("order_pay_code"))){
            /////这里进行成功的处理

            return PayOutMessage.JSON().content("success","成功").build();
        }

        return PayOutMessage.JSON().content("fail", "失败").build();
    }
}
