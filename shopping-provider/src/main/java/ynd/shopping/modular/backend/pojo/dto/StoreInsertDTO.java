package ynd.shopping.modular.backend.pojo.dto;

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
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@ApiModel(value = "店铺新增", description = "店铺管理")
public class StoreInsertDTO {

    @ApiModelProperty(value = "地址", required = true)
    @NotBlank(message = "店铺地址不能为空")
    private String address;

    @ApiModelProperty(value = "已付保证金")
    private BigDecimal bailPaid;

    @ApiModelProperty(value = "E-mail")
    private String email;

    @ApiModelProperty(value = "简介", required = true)
    @NotBlank(message = "简介不能为空")
    private String introduction;

    @ApiModelProperty(value = "是否启用(1:启用（默认） 2：禁用)")
    private Boolean enabled;

    @ApiModelProperty(value = "搜索关键词")
    private String keyword;

    @ApiModelProperty(value = "logo")
    private String logo;

    @ApiModelProperty(value = "手机", required = true)
    @NotBlank(message = "手机不能为空")
    @Length(min = 11, max = 11, message = "请输入11位手机号")
    private String mobile;

    @ApiModelProperty(value = "名称")
    @NotBlank(message = "名称不能为空")
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
    @NotNull(message = "到期日期不能为空")
    // @Pattern(regexp = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$", message = "到期日期格式不正确")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "版本")
    private String version;

}
