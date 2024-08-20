package ynd.shopping.modular.frontend.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 商品分类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "商品分类列表", description = "商品分类管理")
public class ProductCategoryListVo {

    @ApiModelProperty(value = "商品分类id")
    private String productCategoryId;

    @ApiModelProperty(value = "上级分类")
    private String parentId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "自营店铺分佣比例")
    private Double selfRate;

    @ApiModelProperty(value = "普通店铺分佣比例")
    private Double profitSharing;

    @ApiModelProperty(value = "排序")
    private Integer sortBy;

    @ApiModelProperty(value = "版本")
    private String version;

    @ApiModelProperty(value = "删除状态（删除：0，正常：1，默认：0）")
    private Integer delStatus;

    @ApiModelProperty(value = "子列表")
    private List<ProductCategoryListVo> children;

}
