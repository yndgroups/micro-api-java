package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 微应用
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Accessors(chain = true)
@ApiModel(value="微应用修改", description="微应用")
public class MiniAppUpdateVo  extends MiniAppInsertVo{

    @ApiModelProperty(value = "微应用id", required = true)
    @NotNull(message = "微应用id不能为空")
    private Long appId;

}
