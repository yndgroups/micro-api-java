package ynd.shopping.modular.backend.pojo.vo;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
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
@Accessors(chain = true)
@ApiModel(value = "店铺列表", description = "店铺")
public class StoreListVo {

    @ApiModelProperty(value = "商店主键id")
    private Long storeId;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "已付保证金")
    private BigDecimal bailPaid;

    @ApiModelProperty(value = "E-mail")
    private String email;

    @ApiModelProperty(value = "简介")
    private String introduction;

    @ApiModelProperty(value = "是否启用(1:启用（默认） 2：禁用)")
    private Boolean enabled;

    @ApiModelProperty(value = "搜索关键词")
    private String keyword;

    @ApiModelProperty(value = "logo")
    private String logo;

    @ApiModelProperty(value = "手机")
    private String mobile;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "类型")
    private Integer type;

    @ApiModelProperty(value = "邮编")
    private String zipCode;

    @ApiModelProperty(value = "商家")
    private String businessId;

    @ApiModelProperty(value = "店铺分类")
    private String storeCategoryId;

    @ApiModelProperty(value = "店铺等级")
    private String storeRankId;

    @ApiModelProperty(value = "店铺管理人员")
    private String storeUsers;

    @ApiModelProperty(value = "门店编码")
    private String storeNo;

    @ApiModelProperty(value = "地区ID，逗号隔开")
    private String areaTids;

    @ApiModelProperty(value = "运费起步价")
    private String maxPrice;

    @ApiModelProperty(value = "额外运费")
    private BigDecimal extraFreight;

    @ApiModelProperty(value = "到期日期")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "版本")
    private String version;

    @ApiModelProperty(value = "删除状态（false || 0：未删除，true || 1：删除）")
    private Boolean delStatus;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
