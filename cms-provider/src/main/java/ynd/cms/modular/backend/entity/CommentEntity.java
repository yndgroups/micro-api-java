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
 * 评论
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_comment")
@ApiModel(value = "评论", description = "评论Model")
public class CommentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论id")
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;

    @ApiModelProperty(value = "评论父id")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value = "内容评论")
    @TableField("cms")
    private String content;

    @ApiModelProperty(value = "被评论的ID")
    @TableField("target_id")
    private Long targetId;

    @ApiModelProperty(value = "审核状态（0：待审核，1：审核通过，2：审核不通过）")
    @TableField("examine_status")
    private Integer examineStatus;

    @ApiModelProperty(value = "赞同数")
    @TableField("fabulous")
    private Integer fabulous;

    @ApiModelProperty(value = "反对数")
    @TableField("oppose")
    private Integer oppose;

    @ApiModelProperty(value = "删除状态（0：未删除 1：已删除, 默认为：0）")
    @TableField("del_status")
    private Integer delStatus;

    @ApiModelProperty(value = "创建者(既评论者)")
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
