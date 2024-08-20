package ynd.shopping.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 店铺等级
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "店铺等级修改", description = "店铺等级")
public class StoreRankUpdateDTO extends StoreRankInsertDTO {

    @ApiModelProperty(value = "店铺等级id", required = true)
    @NotNull(message = "店铺等级id不能为空")
    private Long storeRankId;

}
