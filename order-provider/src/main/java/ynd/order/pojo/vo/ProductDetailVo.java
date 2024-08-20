package ynd.order.pojo.vo;

import ynd.core.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="商品详情", description="商品管理")
public class ProductDetailVo extends BaseEntity {

    @ApiModelProperty(value = "商品id")
    private String productId;

    @ApiModelProperty(value = "商品分类")
    private String productCategoryId;

    @ApiModelProperty(value = "店铺id")
    private String storeId;

    @ApiModelProperty(value = "店铺分类id")
    private String storeProductCategoryId;

    @ApiModelProperty(value = "品牌")
    private String brandId;

    @ApiModelProperty(value = "发布商品人员ID")
    private String businessId;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "搜索关键词")
    private String keyword;

    @ApiModelProperty(value = "商品介绍")
    private String introduction;

    @ApiModelProperty(value = "成本价")
    private BigDecimal cost;

    @ApiModelProperty(value = "销售价")
    private BigDecimal price;

    @ApiModelProperty(value = "市场价")
    private BigDecimal marketPrice;

    @ApiModelProperty(value = "属性值")
    private String attributeValue;

    @ApiModelProperty(value = "副标题")
    private String caption;

    @ApiModelProperty(value = "商品图片")
    private String productImages;

    @ApiModelProperty(value = "门店编码")
    private String storeNo;

    @ApiModelProperty(value = "商家名称")
    private String businessName;

    @ApiModelProperty(value = "是否有效")
    private Boolean whetherEffective;

    @ApiModelProperty(value = "是否需要物流")
    private Boolean whetherDelivery;

    @ApiModelProperty(value = "是否列出")
    private Boolean whetherList;

    @ApiModelProperty(value = "是否上架")
    private Boolean whetherMarketable;

    @ApiModelProperty(value = "是否置顶")
    private Boolean whetherTop;

    @ApiModelProperty(value = "最大佣金")
    private BigDecimal maxCommission;

    @ApiModelProperty(value = "备注")
    private String memo;

    @ApiModelProperty(value = "点击数")
    private Long hits;

    @ApiModelProperty(value = "周点击数")
    private Long weekHits;

    @ApiModelProperty(value = "周点击数更新日期")
    private Date weekHitsDate;

    @ApiModelProperty(value = "月点击数")
    private Long monthHits;

    @ApiModelProperty(value = "月点击数更新日期")
    private Date monthHitsDate;

    @ApiModelProperty(value = "月销量")
    private Long monthSales;

    @ApiModelProperty(value = "月销量更新日期")
    private Date monthSalesDate;

    @ApiModelProperty(value = "参数值")
    private String parameterValues;

    @ApiModelProperty(value = "销量")
    private Long sales;

    @ApiModelProperty(value = "评分")
    private Float score;

    @ApiModelProperty(value = "评分数")
    private Long scoreCount;

    @ApiModelProperty(value = "编号")
    private String sn;

    @ApiModelProperty(value = "规格项")
    private String specificationItems;

    @ApiModelProperty(value = "总评分")
    private Long totalScore;

    @ApiModelProperty(value = "类型")
    private Integer type;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "周销量")
    private Long weekSales;

    @ApiModelProperty(value = "周销量更新日期")
    private Date weekSalesDate;

    @ApiModelProperty(value = "重量")
    private Integer weight;

    @ApiModelProperty(value = "默认 同步：1；不同步：2")
    private Boolean erpFlag;

    @ApiModelProperty(value = "用于ERP同步商品编号-老库数据")
    private String internalNumber;

    @ApiModelProperty(value = "是否促销商品")
    private Boolean promoteSales;

    @ApiModelProperty(value = "更新标志")
    private Boolean syncFlag;

    @ApiModelProperty(value = "同步时间")
    private Date syncTime;

    @ApiModelProperty(value = "专柜编码")
    private String counterNo;

    @ApiModelProperty(value = "专柜名称")
    private String counterName;

    @ApiModelProperty(value = "商品提示ID")
    private String noteIds;

    @ApiModelProperty(value = "开始时间")
    private Date beginDate;

    @ApiModelProperty(value = "结束时间")
    private Date endDate;

    @ApiModelProperty(value = "注意事项")
    private String noteContents;

    @ApiModelProperty(value = "促销开始时间")
    private Date promStartTime;

    @ApiModelProperty(value = "促销结束时间")
    private Date promEndTime;

    @ApiModelProperty(value = "额外运费")
    private BigDecimal moreFreight;

    @ApiModelProperty(value = "ES促销标识")
    private Boolean promotionFlag;

    @ApiModelProperty(value = "ES库存标识")
    private Boolean stockFlag;

    @ApiModelProperty(value = "是否锁定区域")
    private Boolean areaLock;

    @ApiModelProperty(value = "产品生产地")
    private String areaIds;

    @ApiModelProperty(value = "版本")
    private String version;

    @ApiModelProperty(value = "source")
    private String sourceList;

    @ApiModelProperty(value = "属性")
    private String attrList;

}
