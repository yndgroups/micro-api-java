package ynd.order.pojo.dto;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-25
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "Orders: Vo", description = "订单")
public class OrdersInsertDTO {

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "发货地址")
    private String address;

    @ApiModelProperty(value = "订单金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "已付金额")
    private BigDecimal amountPaid;

    @ApiModelProperty(value = "地区名称")
    private String areaName;

    @ApiModelProperty(value = "订单完成时间")
    private LocalDateTime completeDate;

    @ApiModelProperty(value = "收货人")
    private String consignee;

    @ApiModelProperty(value = "兑换积分")
    private Long exchangePoint;

    @ApiModelProperty(value = "过期时间")
    private LocalDateTime expire;

    @ApiModelProperty(value = "支付手续费")
    private BigDecimal fee;

    @ApiModelProperty(value = "运费")
    private BigDecimal freight;

    @ApiModelProperty(value = "发票内容")
    private String invoiceContent;

    @ApiModelProperty(value = "发票税号")
    private String invoiceTaxNumber;

    @ApiModelProperty(value = "发票抬头")
    private String invoiceTitle;

    @ApiModelProperty(value = "是否已分配库存")
    private Boolean whetherAllocatedStock;

    @ApiModelProperty(value = "是否已兑换积分")
    private Boolean whetherExchangePoint;

    @ApiModelProperty(value = "是否已评论")
    private Boolean whetherReviewed;

    @ApiModelProperty(value = "附言（bei'zhu）")
    private String memo;

    @ApiModelProperty(value = "调整金额")
    private BigDecimal offsetAmount;

    @ApiModelProperty(value = "支付方式名称")
    private String paymentMethodName;

    @ApiModelProperty(value = "支付方式类型")
    private Integer paymentMethodType;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "数量")
    private Integer quantity;

    @ApiModelProperty(value = "退款金额")
    private BigDecimal refundAmount;

    @ApiModelProperty(value = "已退货数量")
    private Integer returnedQuantity;

    @ApiModelProperty(value = "赠送积分")
    private Long rewardPoint;

    @ApiModelProperty(value = "已发货数量")
    private Integer shippedQuantity;

    @ApiModelProperty(value = "配送方式名称")
    private String shippingMethodName;

    @ApiModelProperty(value = "编号")
    private String sn;

    @ApiModelProperty(value = "税金")
    private BigDecimal tax;

    @ApiModelProperty(value = "类型")
    private Integer type;

    @ApiModelProperty(value = "重量")
    private Integer weight;

    @ApiModelProperty(value = "邮编")
    private String zipCode;

    @ApiModelProperty(value = "地区")
    private String areaId;

    @ApiModelProperty(value = "会员")
    private String memberId;

    @ApiModelProperty(value = "支付方式")
    private String paymentMethodId;

    @ApiModelProperty(value = "配送方式")
    private String shippingMethodId;

    @ApiModelProperty(value = "店铺")
    private String storeId;

    @ApiModelProperty(value = "是否已导出")
    private Boolean isExport;

    @ApiModelProperty(value = "导出时间")
    private LocalDateTime exportDate;

    @ApiModelProperty(value = "是否退款")
    private Integer whetherRefund;

    @ApiModelProperty(value = "同步状态")
    private String erpSync;

    @ApiModelProperty(value = "同步时间")
    private LocalDateTime erpSyncTime;

    @ApiModelProperty(value = "ERP同步报文")
    private String erpMsg;

    @ApiModelProperty(value = "数据来源(appId)")
    private String dataSource;

    @ApiModelProperty(value = "版本")
    private String version;

}
