package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 2020区划代码
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "地区新增", description = "2020区划代码")
public class AreaInsertVo {

    @ApiModelProperty(value = "地区码", required = true)
    @NotBlank(message = "地区编码不能为空")
    private String areaCode;

    @ApiModelProperty(value = "地区名称", required = true)
    @NotBlank(message = "地区名称不能为空")
    private String areaName;

    @ApiModelProperty(value = "区划等级", required = true)
    @NotBlank(message = "区划等级不能为空")
    private Integer areaTag;

    @ApiModelProperty(value = "父级代码", required = true)
    @NotBlank(message = "父级代码不能为空")
    private String parentCode;

    @ApiModelProperty(value = "全称")
    private String fullAreaName;

    @ApiModelProperty(value = "年份")
    private String year;

    @ApiModelProperty(value = "是否国标码")
    private Integer isStandard;

    @ApiModelProperty(value = "匹配条件")
    private String likeColumn;

}
