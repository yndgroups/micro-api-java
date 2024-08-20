package ynd.shopping.modular.frontend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 商品分类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "商品分类修改", description = "商品分类管理")
public class ProductCategoryUpdateDTO  extends ProductCategoryInsertDTO {

    @ApiModelProperty(value = "商品分类id", required = true)
    @NotNull(message = "商品分类id不能为空")
    private Long productCategoryId;

}
