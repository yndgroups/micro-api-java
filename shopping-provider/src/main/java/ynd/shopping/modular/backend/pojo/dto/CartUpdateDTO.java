package ynd.shopping.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "购物车更新", description = "购物车")
public class CartUpdateDTO extends CartInsertDTO {

    @ApiModelProperty(value = "购物车ID", required = true)
    @NotNull(message = "购物车id不能为空")
    private Long cartId;

}
