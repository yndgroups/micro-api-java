package ynd.cms.modular.backend.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 留言列表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "留言列表", description = "留言管理")
public class MessageBoardListVo {

    @ApiModelProperty(value = "留言板id")
    private String msgId;

    @ApiModelProperty(value = "留言类别")
    private String categoryId;

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "留言标题")
    private String title;

    @ApiModelProperty(value = "留言内容")
    private String content;

    @ApiModelProperty(value = "真实姓名")
    private String trueName;

    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelProperty(value = "电子邮箱")
    private String email;

    @ApiModelProperty(value = "删除状态（0：未删除 1：已删除, 默认为：0）")
    private Boolean delStatus;

}
