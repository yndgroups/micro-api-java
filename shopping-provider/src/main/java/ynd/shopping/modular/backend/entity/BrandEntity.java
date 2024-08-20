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
 * 品牌
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_brand")
@ApiModel(value="BrandEntity对象", description="品牌")
public class BrandEntity extends BaseEntity {

    @ApiModelProperty(value = "分类id")
    @TableId(value = "brand_id", type = IdType.ASSIGN_UUID)
    private Long brandId;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "介绍")
    @TableField("introduction")
    private String introduction;

    @ApiModelProperty(value = "logo")
    @TableField("logo")
    private String logo;

    @ApiModelProperty(value = "类型（1：图片，0：文字）")
    @TableField("show_type")
    private Boolean showType;

    @ApiModelProperty(value = "网址")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "排序")
    @TableField("sort_by")
    private Integer sortBy;

    @ApiModelProperty(value = "版本")
    @TableField("version")
    private String version;

}
