package ynd.shopping.modular.backend.entity;

import ynd.core.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品分类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_product_category")
@ApiModel(value = "ProductCategoryEntity对象", description = "商品分类")
public class ProductCategoryEntity  extends BaseEntity {

    @ApiModelProperty(value = "商品分类id")
    @TableId("product_category_id")
    private Long productCategoryId;

    @ApiModelProperty(value = "父级分类")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "自营店铺分佣比例")
    @TableField("self_rate")
    private Double selfRate;

    @ApiModelProperty(value = "普通店铺分佣比例")
    @TableField("profit_sharing")
    private Double profitSharing;

    @ApiModelProperty(value = "版本")
    @TableField("version")
    private String version;

    @ApiModelProperty(value = "排序")
    @TableField("sort_by")
    private Integer sortBy;

}
