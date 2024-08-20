package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 应用模块
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="应用模块修改", description="应用模块管理")
public class AppModuleUpdateVo extends AppModuleInsertVo {

    @ApiModelProperty(value = "模块id", required = true)
    @NotNull(message = "模块id不能为空")
    private Long mdId;

}
