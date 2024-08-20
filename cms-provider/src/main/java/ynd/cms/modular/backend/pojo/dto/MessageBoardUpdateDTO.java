package ynd.cms.modular.backend.pojo.dto;

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
 * @date 2021-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "修改", description = "管理")
public class MessageBoardUpdateDTO  extends MessageBoardInsertDTO {

    @ApiModelProperty(value = "留言板id", required = true)
    @NotNull(message = "留言板id不能为空")
    private Long msgId;

}
