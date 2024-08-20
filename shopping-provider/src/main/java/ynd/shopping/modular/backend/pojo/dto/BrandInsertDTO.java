package ynd.shopping.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 品牌
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-28
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "品牌新增", description = "品牌管理")
public class BrandInsertDTO {

    @ApiModelProperty(value = "名称", required = true)
    @NotBlank(message = "名称不能为空")
    private String name;

    @ApiModelProperty(value = "介绍", required = true)
    @NotBlank(message = "介绍不能为空")
    private String introduction;

    @ApiModelProperty(value = "logo")
    private String logo;

    @ApiModelProperty(value = "展示类型（true || 1：图片，false || 0：文字）", required = true)
    @NotBlank(message = "展示类型")
    private Boolean showType;

    @ApiModelProperty(value = "网址")
    private String url;

    @ApiModelProperty(value = "排序")
    private Integer sortBy;

}
