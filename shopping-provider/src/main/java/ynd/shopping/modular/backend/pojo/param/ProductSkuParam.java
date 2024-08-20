package ynd.shopping.modular.backend.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * sku 库存表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-12
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "sku 库存表查询条件", description = "sku 库存表管理")
public class ProductSkuParam {

}
