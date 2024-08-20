package ynd.shopping.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 店铺
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Store: Vo", description = "店铺")
public class StoreUpdateDTO extends StoreInsertDTO {

    @ApiModelProperty(value = "商店主键id", required = true)
    @NotNull(message = "商店主键id不能为空")
    private Long storeId;
}
