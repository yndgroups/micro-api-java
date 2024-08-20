package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 应用表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Accessors(chain = true)
@ApiModel(value="应用修改", description="应用表")
public class AppUpdateVo  extends AppInsertVo{

    @ApiModelProperty(value = "应用主键id", required = true)
    @NotNull(message = "appId不能为空")
    private Long appId;

}
