package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 上传资源分类表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Accessors(chain = true)
@ApiModel(value="字典修改", description="上传资源分类表")
public class DictUpdateVo  extends DictInsertVo{

    @ApiModelProperty(value = "字典id", required = true)
    @NotNull(message = "字典id不能为空")
    private String dictId;

}
