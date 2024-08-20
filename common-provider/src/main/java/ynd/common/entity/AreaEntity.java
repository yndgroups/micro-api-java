package ynd.common.entity;

import ynd.core.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_area")
@ApiModel(value="AreaEntity对象", description="2020区划代码")
public class AreaEntity extends BaseEntity {

    @TableField("area_id")
    private Long areaId;

    @ApiModelProperty(value = "地区码")
    @TableId(value = "area_code", type = IdType.ASSIGN_UUID)
    private String areaCode;

    @ApiModelProperty(value = "地区名称")
    @TableField("area_name")
    private String areaName;

    @ApiModelProperty(value = "区划等级")
    @TableField("area_tag")
    private Integer areaTag;

    @ApiModelProperty(value = "父级代码")
    @TableField("parent_code")
    private String parentCode;

    @ApiModelProperty(value = "全称")
    @TableField("full_area_name")
    private String fullAreaName;

    @ApiModelProperty(value = "年份")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "是否国标码")
    @TableField("is_standard")
    private Integer isStandard;

    @TableField("like_column")
    private String likeColumn;

}
