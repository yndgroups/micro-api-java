package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@Accessors(chain = true)
@ApiModel(value="枚举新增", description="枚举管理")
public class EnumInsertVo {

    @ApiModelProperty(value = "枚举父id", required = true)
    @NotBlank(message = "枚举父id不能为空")
    private String parentId;

    @ApiModelProperty(value = "枚举名称", required = true)
    @NotBlank(message = "枚举名称不能为空")
    private String enName;

    @ApiModelProperty(value = "枚举值", required = true)
    @NotBlank(message = "枚举值不能为空")
    private String enVal;

}
