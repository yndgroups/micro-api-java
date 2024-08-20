package ynd.shopping.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * sku 库存表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "sku 库存表修改", description = "sku 库存表管理")
public class ProductSkuUpdateDTO extends ProductSkuInsertDTO {

    @ApiModelProperty(value = "库存id", required = true)
    @NotNull(message = "库存id不能为空")
    private Long skuId;

}
