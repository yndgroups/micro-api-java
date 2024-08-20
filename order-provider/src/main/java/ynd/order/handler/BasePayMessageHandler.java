package ynd.order.handler;

import com.egzosn.pay.common.api.PayMessageHandler;
import com.egzosn.pay.common.api.PayService;
import com.egzosn.pay.common.bean.PayMessage;

/**
 * description BasePayMessageHandler
 *
 * @return BackResult
 * @author yangdaqiong
 * @date 2021-08-15 13:44:39
 **/
public abstract class BasePayMessageHandler<M extends PayMessage, S extends PayService> implements PayMessageHandler<M, S> {

    //支付账户id
    private Integer payId;

    public BasePayMessageHandler(Integer payId) {
        this.payId = payId;
    }

    public Integer getPayId() {
        return payId;
    }

}
