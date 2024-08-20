package ynd.order.handler;

import com.egzosn.pay.common.api.PayService;
import com.egzosn.pay.common.bean.PayMessage;
import com.egzosn.pay.common.bean.PayOutMessage;
import com.egzosn.pay.common.exception.PayErrorException;
import com.egzosn.pay.payoneer.api.PayoneerPayService;

import java.util.Map;

/**
 * description PayoneerMessageHandler
 *
 * @param
 * @return BackResult
 * @author yangdaqiong
 * @date 2021-08-15 13:45:31
 **/
public class PayoneerMessageHandler extends BasePayMessageHandler {

    public PayoneerMessageHandler(Integer payId) {
        super(payId);
    }

    @Override
    public PayOutMessage handle(PayMessage payMessage, Map context, PayService payService) throws PayErrorException {
        //交易状态
        if ("0".equals(payMessage.getPayMessage().get(PayoneerPayService.CODE))) {
            /////这里进行成功的处理

            return payService.successPayOutMessage(payMessage);
        }

        return payService.getPayOutMessage("fail", "失败");
    }
}
