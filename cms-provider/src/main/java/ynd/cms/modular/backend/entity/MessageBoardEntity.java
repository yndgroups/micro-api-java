package ynd.cms.modular.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_message_board")
@ApiModel(value = "", description = "Model")
public class MessageBoardEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "留言板id")
    @TableId(value = "msg_id", type = IdType.ASSIGN_UUID)
    private Long msgId;

    @ApiModelProperty(value = "留言类别")
    @TableField("category_id")
    private Long categoryId;

    @ApiModelProperty(value = "应用id")
    @TableField("app_id")
    private Long appId;

    @ApiModelProperty(value = "留言标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "留言内容")
    @TableField("cms")
    private String content;

    @ApiModelProperty(value = "真实姓名")
    @TableField("true_name")
    private String trueName;

    @ApiModelProperty(value = "联系电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "电子邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "删除状态（0：未删除 1：已删除, 默认为：0）")
    @TableField("del_status")
    private Integer delStatus;

    @ApiModelProperty(value = "创建者")
    @TableField("create_by")
    private Long createBy;

    @ApiModelProperty(value = "更新者")
    @TableField("update_by")
    private Long updateBy;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private Date updateTime;


}
