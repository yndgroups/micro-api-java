package ynd.order.handler;

import com.egzosn.pay.common.api.PayMessageHandler;
import com.egzosn.pay.common.bean.PayMessage;
import com.egzosn.pay.common.bean.PayOutMessage;
import com.egzosn.pay.common.exception.PayErrorException;
import com.egzosn.pay.paypal.api.PayPalPayService;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * description PayPal支付回调处理器
 *
 * @param
 * @return BackResult
 * @author yangdaqiong
 * @date 2021-08-15 13:43:41
 **/
@Component
public class PayPalPayMessageHandler implements PayMessageHandler<PayMessage, PayPalPayService> {

    @Override
    public PayOutMessage handle(PayMessage payMessage, Map<String, Object> context, PayPalPayService payService) throws PayErrorException {
        return payService.getPayOutMessage("fail", "失败");
    }

}
