package ynd.order.pojo.entity;

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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_orders")
@ApiModel(value = "OrdersEntity对象", description = "订单")
public class OrdersEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id")
    @TableId(value = "order_id", type = IdType.ASSIGN_UUID)
    private Long orderId;

    @ApiModelProperty(value = "发货地址")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "订单金额")
    @TableField("amount")
    private BigDecimal amount;

    @ApiModelProperty(value = "已付金额")
    @TableField("amount_paid")
    private BigDecimal amountPaid;

    @ApiModelProperty(value = "地区名称")
    @TableField("area_name")
    private String areaName;

    @ApiModelProperty(value = "订单完成时间")
    @TableField("complete_date")
    private LocalDateTime completeDate;

    @ApiModelProperty(value = "收货人")
    @TableField("consignee")
    private String consignee;

    @ApiModelProperty(value = "兑换积分")
    @TableField("exchange_point")
    private Long exchangePoint;

    @ApiModelProperty(value = "过期时间")
    @TableField("expire")
    private LocalDateTime expire;

    @ApiModelProperty(value = "支付手续费")
    @TableField("fee")
    private BigDecimal fee;

    @ApiModelProperty(value = "运费")
    @TableField("freight")
    private BigDecimal freight;

    @ApiModelProperty(value = "发票内容")
    @TableField("invoice_content")
    private String invoiceContent;

    @ApiModelProperty(value = "发票税号")
    @TableField("invoice_tax_number")
    private String invoiceTaxNumber;

    @ApiModelProperty(value = "发票抬头")
    @TableField("invoice_title")
    private String invoiceTitle;

    @ApiModelProperty(value = "是否已分配库存")
    @TableField("whether_allocated_stock")
    private Boolean whetherAllocatedStock;

    @ApiModelProperty(value = "是否已兑换积分")
    @TableField("whether_exchange_point")
    private Boolean whetherExchangePoint;

    @ApiModelProperty(value = "是否已评论")
    @TableField("whether_reviewed")
    private Boolean whetherReviewed;

    @ApiModelProperty(value = "附言（bei'zhu）")
    @TableField("memo")
    private String memo;

    @ApiModelProperty(value = "调整金额")
    @TableField("offset_amount")
    private BigDecimal offsetAmount;

    @ApiModelProperty(value = "支付方式名称")
    @TableField("payment_method_name")
    private String paymentMethodName;

    @ApiModelProperty(value = "支付方式类型")
    @TableField("payment_method_type")
    private Integer paymentMethodType;

    @ApiModelProperty(value = "电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "价格")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty(value = "数量")
    @TableField("quantity")
    private Integer quantity;

    @ApiModelProperty(value = "退款金额")
    @TableField("refund_amount")
    private BigDecimal refundAmount;

    @ApiModelProperty(value = "已退货数量")
    @TableField("returned_quantity")
    private Integer returnedQuantity;

    @ApiModelProperty(value = "赠送积分")
    @TableField("reward_point")
    private Long rewardPoint;

    @ApiModelProperty(value = "已发货数量")
    @TableField("shipped_quantity")
    private Integer shippedQuantity;

    @ApiModelProperty(value = "配送方式名称")
    @TableField("shipping_method_name")
    private String shippingMethodName;

    @ApiModelProperty(value = "编号")
    @TableField("sn")
    private String sn;

    @ApiModelProperty(value = "状态")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "税金")
    @TableField("tax")
    private BigDecimal tax;

    @ApiModelProperty(value = "类型")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "重量")
    @TableField("weight")
    private Integer weight;

    @ApiModelProperty(value = "邮编")
    @TableField("zip_code")
    private String zipCode;

    @ApiModelProperty(value = "地区")
    @TableField("area_id")
    private String areaId;

    @ApiModelProperty(value = "会员")
    @TableField("member_id")
    private String memberId;

    @ApiModelProperty(value = "支付方式")
    @TableField("payment_method_id")
    private String paymentMethodId;

    @ApiModelProperty(value = "配送方式")
    @TableField("shipping_method_id")
    private String shippingMethodId;

    @ApiModelProperty(value = "店铺")
    @TableField("store_id")
    private String storeId;

    @ApiModelProperty(value = "是否已导出")
    @TableField("is_export")
    private Boolean isExport;

    @ApiModelProperty(value = "导出时间")
    @TableField("export_date")
    private LocalDateTime exportDate;

    @ApiModelProperty(value = "是否退款")
    @TableField("whether_refund")
    private Integer whetherRefund;

    @ApiModelProperty(value = "同步状态")
    @TableField("erp_sync")
    private String erpSync;

    @ApiModelProperty(value = "同步时间")
    @TableField("erp_sync_time")
    private LocalDateTime erpSyncTime;

    @ApiModelProperty(value = "ERP同步报文")
    @TableField("erp_msg")
    private String erpMsg;

    @ApiModelProperty(value = "数据来源(appId)")
    @TableField("data_source")
    private String dataSource;

    @ApiModelProperty(value = "版本")
    @TableField("version")
    private String version;

    @ApiModelProperty(value = "删除状态（1：正常，2：删除）")
    @TableField("del_status")
    private Integer delStatus;

    @ApiModelProperty(value = "创建者")
    @TableField("create_by")
    private Long createBy;

    @ApiModelProperty(value = "更新者")
    @TableField("update_by")
    private Long updateBy;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private Date updateTime;


}
