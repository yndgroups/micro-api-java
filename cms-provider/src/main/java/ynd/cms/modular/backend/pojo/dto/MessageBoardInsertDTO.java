package ynd.cms.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "新增", description = "管理")
public class MessageBoardInsertDTO {

    @ApiModelProperty(value = "留言类别")
    private Long categoryId;

    @ApiModelProperty(value = "应用id")
    private Long appId;

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

}
