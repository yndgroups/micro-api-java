package ynd.shopping.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

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
@ApiModel(value = "规格新增", description = "规格管理")
public class ProductSpecInsertDTO {

    @ApiModelProperty(value = "规格名称", required = true)
    @NotBlank(message = "规格")
    private String name;

    @ApiModelProperty(value = "商品分类id", required = true)
    @NotBlank(message = "商品分类id")
    private String productCategoryId;

    @ApiModelProperty(value = "可选项", required = true)
    @NotBlank(message = "可选项不能为空")
    private String options;

    @ApiModelProperty(value = "排序")
    private Integer sortBy;

    @ApiModelProperty(value = "版本")
    private String version;

}
