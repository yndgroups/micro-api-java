package ynd.shopping.modular.frontend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
 * @date 2021-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_product_category")
@ApiModel(value = "商品分类", description = "商品分类Model")
public class ProductCategoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品分类id")
    @TableId(value = "product_category_id", type = IdType.ASSIGN_UUID)
    private Long productCategoryId;

    @ApiModelProperty(value = "上级分类")
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

    @ApiModelProperty(value = "排序")
    @TableField("sort_by")
    private Integer sortBy;

    @ApiModelProperty(value = "版本")
    @TableField("version")
    private String version;

    @ApiModelProperty(value = "删除状态（删除：0，正常：1，默认：0）")
    @TableField("del_status")
    private Integer delStatus;

    @ApiModelProperty(value = "创建者")
    @TableField("create_by")
    private Long createBy;

    @ApiModelProperty(value = "更新者")
    @TableField("update_by")
    private Long updateBy;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private Date updateTime;


}
