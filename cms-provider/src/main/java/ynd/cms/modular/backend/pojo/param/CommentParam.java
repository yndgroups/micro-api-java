package ynd.cms.modular.backend.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

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
@ApiModel(value = "评论查询条件", description = "评论管理")
public class CommentParam {

    @ApiModelProperty(value = "内容")
    private String content;

}
