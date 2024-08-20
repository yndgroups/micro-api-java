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
 * 商品
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_product")
@ApiModel(value = "商品", description = "商品Model")
public class ProductEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    @TableId(value = "product_id", type = IdType.ASSIGN_UUID)
    private Long productId;

    @ApiModelProperty(value = "商品分类")
    @TableField("product_category_id")
    private Long productCategoryId;

    @ApiModelProperty(value = "店铺id")
    @TableField("store_id")
    private Long storeId;

    @ApiModelProperty(value = "店铺分类id")
    @TableField("store_product_category_id")
    private Long storeProductCategoryId;

    @ApiModelProperty(value = "品牌")
    @TableField("brand_id")
    private Long brandId;

    @ApiModelProperty(value = "发布商品人员id")
    @TableField("business_id")
    private Long businessId;

    @ApiModelProperty(value = "商品规格模板id")
    @TableField("template_id")
    private Long templateId;

    @ApiModelProperty(value = "商品编号")
    @TableField("sn")
    private String sn;

    @ApiModelProperty(value = "商品名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "副标题")
    @TableField("caption")
    private String caption;

    @ApiModelProperty(value = "搜索关键词")
    @TableField("keyword")
    private String keyword;

    @ApiModelProperty(value = "商品介绍")
    @TableField("introduction")
    private String introduction;

    @ApiModelProperty(value = "参数列表")
    @TableField("para_items")
    private String paraItems;

    @ApiModelProperty(value = "规格列表")
    @TableField("spec_items")
    private String specItems;

    @ApiModelProperty(value = "商品图片列表")
    @TableField("images")
    private String images;

    @ApiModelProperty(value = "门店编码")
    @TableField("store_no")
    private String storeNo;

    @ApiModelProperty(value = "商家名称")
    @TableField("business_name")
    private String businessName;

    @ApiModelProperty(value = "是否有效")
    @TableField("whether_effective")
    private Boolean whetherEffective;

    @ApiModelProperty(value = "是否需要物流")
    @TableField("whether_delivery")
    private Boolean whetherDelivery;

    @ApiModelProperty(value = "是否列出")
    @TableField("whether_list")
    private Boolean whetherList;

    @ApiModelProperty(value = "是否上架")
    @TableField("whether_marketable")
    private Boolean whetherMarketable;

    @ApiModelProperty(value = "是否置顶")
    @TableField("whether_top")
    private Boolean whetherTop;

    @ApiModelProperty(value = "最大佣金")
    @TableField("max_commission")
    private BigDecimal maxCommission;

    @ApiModelProperty(value = "备注")
    @TableField("memo")
    private String memo;

    @ApiModelProperty(value = "点击数")
    @TableField("hits")
    private Long hits;

    @ApiModelProperty(value = "周点击数")
    @TableField("week_hits")
    private Long weekHits;

    @ApiModelProperty(value = "周点击数更新日期")
    @TableField("week_hits_date")
    private LocalDateTime weekHitsDate;

    @ApiModelProperty(value = "月点击数")
    @TableField("month_hits")
    private Long monthHits;

    @ApiModelProperty(value = "月点击数更新日期")
    @TableField("month_hits_date")
    private LocalDateTime monthHitsDate;

    @ApiModelProperty(value = "销量")
    @TableField("sales")
    private Long sales;

    @ApiModelProperty(value = "月销量")
    @TableField("month_sales")
    private Long monthSales;

    @ApiModelProperty(value = "月销量更新日期")
    @TableField("month_sales_date")
    private LocalDateTime monthSalesDate;

    @ApiModelProperty(value = "评分")
    @TableField("score")
    private Float score;

    @ApiModelProperty(value = "评分数")
    @TableField("score_count")
    private Long scoreCount;

    @ApiModelProperty(value = "总评分")
    @TableField("total_score")
    private Long totalScore;

    @ApiModelProperty(value = "类型")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "单位")
    @TableField("unit")
    private String unit;

    @ApiModelProperty(value = "周销量")
    @TableField("week_sales")
    private Long weekSales;

    @ApiModelProperty(value = "周销量更新日期")
    @TableField("week_sales_date")
    private LocalDateTime weekSalesDate;

    @ApiModelProperty(value = "默认 同步：1；不同步：2")
    @TableField("erp_flag")
    private Boolean erpFlag;

    @ApiModelProperty(value = "用于ERP同步商品编号-老库数据")
    @TableField("internal_number")
    private String internalNumber;

    @ApiModelProperty(value = "是否促销商品")
    @TableField("promote_sales")
    private Boolean promoteSales;

    @ApiModelProperty(value = "更新标志")
    @TableField("sync_flag")
    private Boolean syncFlag;

    @ApiModelProperty(value = "同步时间")
    @TableField("sync_time")
    private LocalDateTime syncTime;

    @ApiModelProperty(value = "专柜编码")
    @TableField("counter_no")
    private String counterNo;

    @ApiModelProperty(value = "专柜名称")
    @TableField("counter_name")
    private String counterName;

    @ApiModelProperty(value = "商品提示ID")
    @TableField("note_ids")
    private String noteIds;

    @ApiModelProperty(value = "开始时间")
    @TableField("begin_date")
    private LocalDateTime beginDate;

    @ApiModelProperty(value = "结束时间")
    @TableField("end_date")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "注意事项")
    @TableField("note_contents")
    private String noteContents;

    @ApiModelProperty(value = "促销开始时间")
    @TableField("prom_start_time")
    private LocalDateTime promStartTime;

    @ApiModelProperty(value = "促销结束时间")
    @TableField("prom_end_time")
    private LocalDateTime promEndTime;

    @ApiModelProperty(value = "额外运费")
    @TableField("more_freight")
    private BigDecimal moreFreight;

    @ApiModelProperty(value = "ES促销标识")
    @TableField("promotion_flag")
    private Boolean promotionFlag;

    @ApiModelProperty(value = "ES库存标识")
    @TableField("stock_flag")
    private Boolean stockFlag;

    @ApiModelProperty(value = "是否锁定区域")
    @TableField("area_lock")
    private Boolean areaLock;

    @ApiModelProperty(value = "产品生产地")
    @TableField("area_ids")
    private String areaIds;

    @ApiModelProperty(value = "审核状态，0：未审核，1：已审核，2：审核不通过")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "版本")
    @TableField("version")
    private String version;

    @ApiModelProperty(value = "删除状态（false || 0：未删除，ftrue || 1：删除）")
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
