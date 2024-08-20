package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

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
@ApiModel(value="地区列表", description="2020区划代码")
public class AreaListVo {

    private String areaId;

    @ApiModelProperty(value = "地区码")
    private String areaCode;

    @ApiModelProperty(value = "地区名称")
    private String areaName;

    @ApiModelProperty(value = "区划等级")
    private Integer areaTag;

    @ApiModelProperty(value = "父级代码")
    private String parentCode;

    @ApiModelProperty(value = "全称")
    private String fullAreaName;

    @ApiModelProperty(value = "年份")
    private String year;

    @ApiModelProperty(value = "是否国标码")
    private Integer isStandard;

    @ApiModelProperty(value = "匹配条件")
    private String likeColumn;

    @ApiModelProperty(value = "删除状态（1||true：正常，0||false：删除）")
    private Boolean delStatus;

}
