package ynd.shopping.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 库存记录
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-10-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "库存记录修改", description = "库存记录管理")
public class InventoryRecordUpdateDTO extends InventoryRecordInsertDTO {

    @ApiModelProperty(value = "库存记录id")
    @NotNull(message = "库存记录id不能为空")
    private Long inventoryRecordId;

}
