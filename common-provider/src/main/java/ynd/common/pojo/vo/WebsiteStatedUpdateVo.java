package ynd.common.pojo.vo;

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
 * @date 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Accessors(chain = true)
@ApiModel(value="站点使用协议及声明修改", description="站点使用协议及声管理")
public class WebsiteStatedUpdateVo  extends WebsiteStatedInsertVo{

    @ApiModelProperty(value = "声明id")
    @NotNull(message = "声明id不能为空")
    private Long stateId;
}
