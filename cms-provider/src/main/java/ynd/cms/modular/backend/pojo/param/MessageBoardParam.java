package ynd.cms.modular.backend.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 留言板查询条件
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "留言板查询条件", description = "留言管理")
public class MessageBoardParam {

    @ApiModelProperty(value = "留言标题")
    private String title;

    @ApiModelProperty(value = "留言内容")
    private String content;

}
