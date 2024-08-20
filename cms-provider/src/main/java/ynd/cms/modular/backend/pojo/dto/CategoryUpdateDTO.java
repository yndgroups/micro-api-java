package ynd.cms.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 信息分类表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "分类修改", description = "分类管理")
public class CategoryUpdateDTO extends CategoryInsertDTO {

    @ApiModelProperty(value = "类型id的父id(默认：1是新闻，2：视频，3：图片)", required = true)
    @NotNull(message = "类型id的父id(默认：1是新闻，2：视频，3：图片)不能为空")
    private Long categoryId;

}
