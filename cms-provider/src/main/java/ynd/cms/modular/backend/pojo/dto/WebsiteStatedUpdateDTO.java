package ynd.cms.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 站点使用协议及声明表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "站点使用协议及声明表修改", description = "站点使用协议及声明表管理")
public class WebsiteStatedUpdateDTO  extends WebsiteStatedInsertDTO {

    @ApiModelProperty(value = "声明主键id", required = true)
    @NotNull(message = "声明主键id不能为空")
    private Long stateId;

}
