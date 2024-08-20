package ynd.shopping.modular.backend.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * sku 库存表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-12
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "sku 库存表列表", description = "sku 库存表管理")
public class ProductSkuListVo {

    @ApiModelProperty(value = "库存id")
    private Long skuId;

    @ApiModelProperty(value = "库存名称")
    private String skuName;

    @ApiModelProperty(value = "商品")
    private Long productId;

    @ApiModelProperty(value = "编号")
    private String sn;

    @ApiModelProperty(value = "成本价")
    private BigDecimal cost;

    @ApiModelProperty(value = "销售价")
    private BigDecimal price;

    @ApiModelProperty(value = "市场价")
    private BigDecimal marketPrice;

    @ApiModelProperty(value = "已分配库存")
    private Integer allocatedStock;

    @ApiModelProperty(value = "库存预警值")
    private Integer stockWarningNum;

    @ApiModelProperty(value = "库存")
    private Integer stockNum;

    @ApiModelProperty(value = "促销vip价")
    private BigDecimal promoteVipPrice;

    @ApiModelProperty(value = "促销白金价")
    private BigDecimal promoteWhiteGoldPrice;

    @ApiModelProperty(value = "促销钻石价")
    private BigDecimal promoteDiamondPrice;

    @ApiModelProperty(value = "促销普通会员价")
    private BigDecimal promoteCommonPrice;

    @ApiModelProperty(value = "是否促销商品")
    private Boolean whetherPromote;

    @ApiModelProperty(value = "促销开始时间")
    private LocalDateTime promoteStartTime;

    @ApiModelProperty(value = "促销结束时间")
    private LocalDateTime promEndTime;

    @ApiModelProperty(value = "vip价")
    private BigDecimal vipPrice;

    @ApiModelProperty(value = "白金价")
    private BigDecimal whiteGoldPrice;

    @ApiModelProperty(value = "钻石价")
    private BigDecimal diamondPrice;

    @ApiModelProperty(value = "普通会员价")
    private BigDecimal commonPrice;

    @ApiModelProperty(value = "兑换积分")
    private Long exchangePoint;

    @ApiModelProperty(value = "是否默认")
    private Boolean whetherDefault;

    @ApiModelProperty(value = "最大佣金")
    private BigDecimal maxCommission;

    @ApiModelProperty(value = "赠送积分")
    private Long rewardPoint;

    @ApiModelProperty(value = "规格列表")
    private String specItems;

    @ApiModelProperty(value = "更新标志")
    private Boolean syncFlag;

    @ApiModelProperty(value = "门店编码")
    private String storeNo;

    @ApiModelProperty(value = "同步时间")
    private LocalDateTime syncTime;

    @ApiModelProperty(value = "专柜编码")
    private String counterNo;

    @ApiModelProperty(value = "专柜名称")
    private String counterName;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "商品图片")
    private String productImages;

    @ApiModelProperty(value = "版本")
    private String version;

    @ApiModelProperty(value = "删除状态（false || 0：未删除，true || 1：删除）")
    private Boolean delStatus;

}
