package ynd.shopping.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品分类修改
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "商品分类修改", description = "商品分类")
public class ProductCategoryUpdateDTO extends ProductCategoryInsertDTO {

    @ApiModelProperty(value = "商品分类id", required = true)
    private Long productCategoryId;

}
