package ynd.shopping.modular.backend.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 库存记录查询参数
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-10-04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "库存记录查询条件", description = "库存记录管理")
public class InventoryRecordParam {

}
