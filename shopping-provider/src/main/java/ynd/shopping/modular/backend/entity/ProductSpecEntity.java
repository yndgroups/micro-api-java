package ynd.shopping.modular.backend.entity;

import ynd.core.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_product_spec")
@ApiModel(value = "规格实体", description = "规格Model")
public class ProductSpecEntity extends BaseEntity {

    @ApiModelProperty(value = "商品规格id")
    @TableId(value = "spec_id", type = IdType.ASSIGN_UUID)
    private Long specId;

    @ApiModelProperty(value = "规格名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "绑定分类")
    @TableField("product_category_id")
    private String productCategoryId;

    @ApiModelProperty(value = "可选项")
    @TableField("options")
    private String options;

    @ApiModelProperty(value = "排序")
    @TableField("sort_by")
    private Integer sortBy;

    @ApiModelProperty(value = "版本")
    @TableField("version")
    private String version;

}
