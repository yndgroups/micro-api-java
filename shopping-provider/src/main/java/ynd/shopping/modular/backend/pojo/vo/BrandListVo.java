package ynd.shopping.modular.backend.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 品牌列表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-28
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "品牌列表", description = "品牌管理")
public class BrandListVo {

    @ApiModelProperty(value = "分类id")
    private String brandId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "介绍")
    private String introduction;

    @ApiModelProperty(value = "logo")
    private String logo;

    @ApiModelProperty(value = "类型（1：图片，0：文字）")
    private Boolean type;

    @ApiModelProperty(value = "网址")
    private String url;

    @ApiModelProperty(value = "排序")
    private Integer orderBy;

    @ApiModelProperty(value = "版本")
    private String version;

    @ApiModelProperty(value = "删除状态（false || 0：未删除，true || 1：删除）")
    private Boolean delStatus;

}
