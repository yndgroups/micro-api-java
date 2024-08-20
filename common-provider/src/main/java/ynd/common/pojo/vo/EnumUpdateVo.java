package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Accessors(chain = true)
@ApiModel(value="枚举修改", description="枚举管理")
public class EnumUpdateVo  extends EnumInsertVo{

    @ApiModelProperty(value = "枚举id", required = true)
    @NotNull(message = "枚举id不能为空")
    private String enumId;

}
