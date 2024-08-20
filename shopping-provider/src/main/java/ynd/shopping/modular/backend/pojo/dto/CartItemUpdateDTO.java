package ynd.shopping.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 购物车项
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "购物车项修改", description = "购物车项")
public class CartItemUpdateDTO extends CartItemInsertDTO {

    @ApiModelProperty(value = "购物车项id", required = true)
    @NotNull(message = "购物车项id不能为空")
    private Long ctId;

}
