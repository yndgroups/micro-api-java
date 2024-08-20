package ynd.cms.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "评论修改", description = "评论管理")
public class CommentUpdateDTO  extends CommentInsertDTO {

    @ApiModelProperty(value = "评论id", required = true)
    @NotNull(message = "评论id不能为空")
    private Long commentId;

}
