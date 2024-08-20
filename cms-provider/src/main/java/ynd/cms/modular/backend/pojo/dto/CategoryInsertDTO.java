package ynd.cms.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 信息分类表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-10
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "分类新增", description = "分类管理")
public class CategoryInsertDTO {

    @ApiModelProperty(value = "类型id的父id(默认：1是新闻，2：视频，3：图片)", required = true)
    private Long parentId;

    @ApiModelProperty(value = "应用id", required = true)
    private Long appId;

    @ApiModelProperty(value = "新闻类型名称(栏目名称不能重复)", required = true)
    private String name;

    @ApiModelProperty(value = "类型标识", required = true)
    private String mark;

    @ApiModelProperty(value = "排序")
    private Integer sortBy;

    @ApiModelProperty(value = "分类描述")
    private String description;

}
