package ynd.shopping.modular.backend.entity;

import java.math.BigDecimal;

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
 * 店铺分类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_store_category")
@ApiModel(value="店铺分类Model", description="店铺分类")
public class StoreCategoryEntity extends BaseEntity {

    @ApiModelProperty(value = "店铺分类id")
    @TableId(value = "store_category_id", type = IdType.ASSIGN_UUID)
    private Long storeCategoryId;

    @ApiModelProperty(value = "保证金")
    @TableField("bail")
    private BigDecimal bail;

    @ApiModelProperty(value = "分类名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "排序")
    @TableField("sort_by")
    private Integer sortBy;

    @ApiModelProperty(value = "版本号")
    @TableField("version")
    private String version;
    
}
