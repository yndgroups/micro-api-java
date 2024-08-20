package ynd.shopping.modular.backend.entity;

import java.math.BigDecimal;

import ynd.core.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 店铺
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_store")
@ApiModel(value="StoreEntity对象", description="店铺")
public class StoreEntity extends BaseEntity {

    @ApiModelProperty(value = "商店主键id")
    @TableId(value = "store_id", type = IdType.ASSIGN_UUID)
    private Long storeId;

    @ApiModelProperty(value = "商家")
    @TableField("business_id")
    private String businessId;

    @ApiModelProperty(value = "店铺分类")
    @TableField("store_category_id")
    private String storeCategoryId;

    @ApiModelProperty(value = "店铺等级")
    @TableField("store_rank_id")
    private String storeRankId;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "搜索关键词")
    @TableField("keyword")
    private String keyword;

    @ApiModelProperty(value = "简介")
    @TableField("introduction")
    private String introduction;

    @ApiModelProperty(value = "地址")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "已付保证金")
    @TableField("bail_paid")
    private Integer bailPaid;

    @ApiModelProperty(value = "手机")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty(value = "电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "E-mail")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "是否启用(1:启用（默认） 0：禁用)")
    @TableField("enabled")
    private Boolean enabled;

    @ApiModelProperty(value = "logo")
    @TableField("logo")
    private String logo;

    @ApiModelProperty(value = "状态")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "类型")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "邮编")
    @TableField("zip_code")
    private String zipCode;

    @ApiModelProperty(value = "店铺管理人员")
    @TableField("store_users")
    private String storeUsers;

    @ApiModelProperty(value = "门店编码")
    @TableField("store_no")
    private String storeNo;

    @ApiModelProperty(value = "地区ID，逗号隔开")
    @TableField("area_ids")
    private String areaTids;

    @ApiModelProperty(value = "运费起步价")
    @TableField("max_price")
    private String maxPrice;

    @ApiModelProperty(value = "额外运费")
    @TableField("extra_freight")
    private BigDecimal extraFreight;

    @ApiModelProperty(value = "到期日期")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("end_date")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "版本")
    @TableField("version")
    private String version;

}
