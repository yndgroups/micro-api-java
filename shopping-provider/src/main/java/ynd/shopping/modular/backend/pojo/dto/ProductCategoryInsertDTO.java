package ynd.shopping.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 商品分类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-22
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "商品分类新增", description = "商品分类")
public class ProductCategoryInsertDTO {

    @ApiModelProperty(value = "名称", required = true)
    @NotBlank(message = "名称不能为空")
    private String name;

    @ApiModelProperty(value = "上级分类", required = true)
    @NotNull(message = "上级分类不能为空")
    private Long parentId;

    @ApiModelProperty(value = "普通店铺分佣比例")
    private Double profitSharing;

    @ApiModelProperty(value = "自营店铺分佣比例")
    private Double selfRate;

    @ApiModelProperty(value = "版本")
    private String version;

    @ApiModelProperty(value = "排序")
    private Integer sortBy;

}
