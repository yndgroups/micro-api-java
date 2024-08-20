package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 上传资源分类表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@Accessors(chain = true)
@ApiModel(value="字典列表", description="上传资源分类表")
public class DictListVo {

    @ApiModelProperty(value = "字典id")
    private String dictId;

    @ApiModelProperty(value = "字典父id")
    private String parentId;

    @ApiModelProperty(value = "字典解释/说明")
    private String explain;

    @ApiModelProperty(value = "排序")
    private Integer sortBy;

    @ApiModelProperty(value = "子节点")
    private List<DictListVo> children;

}
