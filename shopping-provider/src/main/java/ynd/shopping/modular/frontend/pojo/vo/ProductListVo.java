package ynd.shopping.modular.frontend.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "商品列表", description = "商品管理")
public class ProductListVo {

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

    @ApiModelProperty(value = "模板id")
    private String templateId;

    @ApiModelProperty(value = "编号")
    private String sn;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "副标题")
    private String caption;

    @ApiModelProperty(value = "搜索关键词")
    private String keyword;

    @ApiModelProperty(value = "商品介绍")
    private String introduction;

    @ApiModelProperty(value = "参数值")
    private String paraItems;

    @ApiModelProperty(value = "规格列表")
    private String specItems;

    @ApiModelProperty(value = "商品图片列表")
    private String images;

    @ApiModelProperty(value = "门店编码")
    private String storeNo;

    @ApiModelProperty(value = "商家名称")
    private String businessName;

    @ApiModelProperty(value = "是否有效")
    private Integer whetherEffective;

    @ApiModelProperty(value = "是否需要物流")
    private Integer whetherDelivery;

    @ApiModelProperty(value = "是否列出")
    private Integer whetherList;

    @ApiModelProperty(value = "是否上架")
    private Integer whetherMarketable;

    @ApiModelProperty(value = "是否置顶")
    private Integer whetherTop;

    @ApiModelProperty(value = "最大佣金")
    private BigDecimal maxCommission;

    @ApiModelProperty(value = "备注")
    private String memo;

    @ApiModelProperty(value = "点击数")
    private String hits;

    @ApiModelProperty(value = "周点击数")
    private String weekHits;

    @ApiModelProperty(value = "周点击数更新日期")
    private LocalDateTime weekHitsDate;

    @ApiModelProperty(value = "月点击数")
    private String monthHits;

    @ApiModelProperty(value = "月点击数更新日期")
    private LocalDateTime monthHitsDate;

    @ApiModelProperty(value = "销量")
    private String sales;

    @ApiModelProperty(value = "月销量")
    private String monthSales;

    @ApiModelProperty(value = "月销量更新日期")
    private LocalDateTime monthSalesDate;

    @ApiModelProperty(value = "评分")
    private Float score;

    @ApiModelProperty(value = "评分数")
    private String scoreCount;

    @ApiModelProperty(value = "总评分")
    private String totalScore;

    @ApiModelProperty(value = "类型")
    private Integer type;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "周销量")
    private String weekSales;

    @ApiModelProperty(value = "周销量更新日期")
    private LocalDateTime weekSalesDate;

    @ApiModelProperty(value = "默认 同步：1；不同步：2")
    private Integer erpFlag;

    @ApiModelProperty(value = "用于ERP同步商品编号-老库数据")
    private String internalNumber;

    @ApiModelProperty(value = "是否促销商品")
    private Boolean promoteSales;

    @ApiModelProperty(value = "更新标志")
    private Boolean syncFlag;

    @ApiModelProperty(value = "同步时间")
    private LocalDateTime syncTime;

    @ApiModelProperty(value = "专柜编码")
    private String counterNo;

    @ApiModelProperty(value = "专柜名称")
    private String counterName;

    @ApiModelProperty(value = "商品提示ID")
    private String noteIds;

    @ApiModelProperty(value = "开始时间")
    private LocalDateTime beginDate;

    @ApiModelProperty(value = "结束时间")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "注意事项")
    private String noteContents;

    @ApiModelProperty(value = "促销标识")
    private String promotionFlag;

    @ApiModelProperty(value = "促销开始时间")
    private LocalDateTime promStartTime;

    @ApiModelProperty(value = "促销结束时间")
    private LocalDateTime promEndTime;

    @ApiModelProperty(value = "额外运费")
    private BigDecimal moreFreight;

    @ApiModelProperty(value = "ES库存标识")
    private Integer stockFlag;

    @ApiModelProperty(value = "是否锁定区域")
    private Integer areaLock;

    @ApiModelProperty(value = "产品生产地")
    private String areaIds;

    @ApiModelProperty(value = "成本价")
    private String status;

    @ApiModelProperty(value = "版本")
    private String version;

    @ApiModelProperty(value = "删除状态（删除：0，正常：1，默认：0）")
    private Integer delStatus;

}
