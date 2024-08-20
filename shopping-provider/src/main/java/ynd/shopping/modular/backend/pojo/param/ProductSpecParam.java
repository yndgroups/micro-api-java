package ynd.shopping.modular.backend.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 属性
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-08
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "属性查询条件", description = "属性管理")
public class ProductSpecParam {

    @ApiModelProperty(value = "规格名称")
    private String name;

}
