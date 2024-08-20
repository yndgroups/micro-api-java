package ynd.cms.modular.backend.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 留言详情
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "留言详情", description = "留言管理")
public class MessageBoardDetailVo {

    @ApiModelProperty(value = "留言id")
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

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
