package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

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
@ApiModel(value="字典新增", description="上传资源分类表")
public class DictInsertVo {

    @ApiModelProperty(value = "父id", required = true)
    @NotBlank(message = "字典父id不能为空")
    private String parentId;

    @ApiModelProperty(value = "字典解释/说明", required = true)
    private String explain;

}
