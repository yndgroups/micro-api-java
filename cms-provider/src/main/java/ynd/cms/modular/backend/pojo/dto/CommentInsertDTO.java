package ynd.cms.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 评论
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-10
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "评论新增", description = "评论管理")
public class CommentInsertDTO {

    @ApiModelProperty(value = "评论父id", required = true)
    @NotNull(message = "评论父id不能为空")
    private Long parentId;

    @ApiModelProperty(value = "内容评论", required = true)
    @NotBlank(message = "内容评论不能为空")
    private String content;

    @ApiModelProperty(value = "被评论的id" , required = true)
    @NotNull(message = "被评论的id不能为空")
    private Long targetId;

}
