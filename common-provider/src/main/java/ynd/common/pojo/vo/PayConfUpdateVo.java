package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 *  第三方配置修改
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Accessors(chain = true)
@ApiModel(value="配置修改", description="配置管理")
public class PayConfUpdateVo  extends PayConfInsertVo{

    @ApiModelProperty(value = "配置id", required = true)
    @NotNull(message = "配置id不能为空")
    private Long confId;

}
