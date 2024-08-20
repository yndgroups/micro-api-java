package ynd.order.pojo.dao;

import com.egzosn.pay.common.bean.BillType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel("订单辅助接口")
@Data
public class OrderModel {

    @ApiModelProperty("支付id")
    private Integer payId;

    @ApiModelProperty("支付平台订单号")
    private String tradeNo;

    @ApiModelProperty("商户单号")
    private String outTradeNo;

    @ApiModelProperty("退款金额")
    private BigDecimal refundAmount;

    @ApiModelProperty("总金额")
    private BigDecimal totalAmount;

    @ApiModelProperty("账单时间：具体请查看对应支付平台")
    private Date billDate;

    @ApiModelProperty("账单时间：具体请查看对应支付平台")
    private BillType billType;

    @ApiModelProperty("支付平台订单号或者账单日期")
    private Object tradeNoOrBillDate;

    @ApiModelProperty("商户单号或者 账单类型")
    private String outTradeNoBillType;

    @ApiModelProperty("交易类型")
    private String transactionType;
}
