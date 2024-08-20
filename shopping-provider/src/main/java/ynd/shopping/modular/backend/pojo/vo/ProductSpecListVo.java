package ynd.shopping.modular.backend.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 规格
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-08
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "规格列表", description = "规格管理")
public class ProductSpecListVo {

    @ApiModelProperty(value = "规格id")
    private String specId;

    @ApiModelProperty(value = "规格名称")
    private String name;

    @ApiModelProperty(value = "绑定分类")
    private String templateId;

    @ApiModelProperty(value = "可选项")
    private String options;

    @ApiModelProperty(value = "排序")
    private Integer sortBy;

    @ApiModelProperty(value = "版本")
    private String version;

    @ApiModelProperty(value = "删除状态（false || 0：未删除，true || 1：删除）")
    private Boolean delStatus;

}
