package ynd.shopping.modular.backend.entity;

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
 * sku 库存表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_product_sku")
@ApiModel(value = "sku 库存表", description = "sku 库存表Model")
public class ProductSkuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "库存id")
    @TableId(value = "sku_id", type = IdType.ASSIGN_UUID)
    private Long skuId;

    @ApiModelProperty(value = "库存名称")
    @TableField("sku_name")
    private String skuName;

    @ApiModelProperty(value = "商品")
    @TableField("product_id")
    private Long productId;

    @ApiModelProperty(value = "重量")
    @TableField("weight")
    private Integer weight;

    @ApiModelProperty(value = "编号")
    @TableField("sn")
    private String sn;

    @ApiModelProperty(value = "成本价")
    @TableField("cost")
    private BigDecimal cost;

    @ApiModelProperty(value = "销售价")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty(value = "市场价")
    @TableField("market_price")
    private BigDecimal marketPrice;

    @ApiModelProperty(value = "已分配库存")
    @TableField("allocated_stock")
    private Integer allocatedStock;

    @ApiModelProperty(value = "库存")
    @TableField("stock_num")
    private Integer stockNum;

    @ApiModelProperty(value = "库存预警值")
    @TableField("stock_warning_num")
    private Integer stockWarningNum;

    @ApiModelProperty(value = "促销vip价")
    @TableField("promote_vip_price")
    private BigDecimal promoteVipPrice;

    @ApiModelProperty(value = "促销白金价")
    @TableField("promote_white_gold_price")
    private BigDecimal promoteWhiteGoldPrice;

    @ApiModelProperty(value = "促销钻石价")
    @TableField("promote_diamond_price")
    private BigDecimal promoteDiamondPrice;

    @ApiModelProperty(value = "促销普通会员价")
    @TableField("promote_common_price")
    private BigDecimal promoteCommonPrice;

    @ApiModelProperty(value = "是否促销商品")
    @TableField("whether_promote")
    private Boolean whetherPromote;

    @ApiModelProperty(value = "促销开始时间")
    @TableField("promote_start_time")
    private LocalDateTime promoteStartTime;

    @ApiModelProperty(value = "促销结束时间")
    @TableField("prom_end_time")
    private LocalDateTime promEndTime;

    @ApiModelProperty(value = "vip价")
    @TableField("vip_price")
    private BigDecimal vipPrice;

    @ApiModelProperty(value = "白金价")
    @TableField("white_gold_price")
    private BigDecimal whiteGoldPrice;

    @ApiModelProperty(value = "钻石价")
    @TableField("diamond_price")
    private BigDecimal diamondPrice;

    @ApiModelProperty(value = "普通会员价")
    @TableField("common_price")
    private BigDecimal commonPrice;

    @ApiModelProperty(value = "兑换积分")
    @TableField("exchange_point")
    private Long exchangePoint;

    @ApiModelProperty(value = "是否默认")
    @TableField("whether_default")
    private Boolean whetherDefault;

    @ApiModelProperty(value = "最大佣金")
    @TableField("max_commission")
    private BigDecimal maxCommission;

    @ApiModelProperty(value = "赠送积分")
    @TableField("reward_point")
    private Long rewardPoint;

    @ApiModelProperty(value = "规格列表")
    @TableField("spec_items")
    private String specItems;

    @ApiModelProperty(value = "更新标志")
    @TableField("sync_flag")
    private Boolean syncFlag;

    @ApiModelProperty(value = "同步时间")
    @TableField("sync_time")
    private LocalDateTime syncTime;

    @ApiModelProperty(value = "门店编码")
    @TableField("store_no")
    private String storeNo;

    @ApiModelProperty(value = "专柜编码")
    @TableField("counter_no")
    private String counterNo;

    @ApiModelProperty(value = "专柜名称")
    @TableField("counter_name")
    private String counterName;

    @ApiModelProperty(value = "单位")
    @TableField("unit")
    private String unit;

    @ApiModelProperty(value = "商品图片")
    @TableField("product_images")
    private String productImages;

    @ApiModelProperty(value = "版本")
    @TableField("version")
    private String version;

    @ApiModelProperty(value = "删除状态（未删除：0，删除：1, 默认：0）")
    @TableField("del_status")
    private Boolean delStatus;

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
