package ynd.cms.modular.backend.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

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
@ApiModel(value = "信息分类表列表", description = "信息分类表管理")
public class CategoryListVo {

    @ApiModelProperty(value = "类型id的父id(默认：1是新闻，2：视频，3：图片)")
    private String categoryId;

    @ApiModelProperty(value = "类型id的父id(默认：1是新闻，2：视频，3：图片)")
    private String parentId;

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "新闻类型名称(栏目名称不能重复)")
    private String name;

    @ApiModelProperty(value = "类型标识")
    private String mark;

    @ApiModelProperty(value = "排序")
    private Integer sortBy;

    @ApiModelProperty(value = "分类描述")
    private String description;

    @ApiModelProperty(value = "逻辑删除状态（1：未删除、2：已经删除）")
    private Boolean delStatus;

    @ApiModelProperty(value = "子集")
    private List<CategoryListVo> children;

}
