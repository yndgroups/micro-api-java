package ynd.cms.modular.backend.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
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
@ApiModel(value = "评论详情", description = "评论管理")
public class CommentDetailVo {

    @ApiModelProperty(value = "评论id")
    private String commentId;

    @ApiModelProperty(value = "评论父id")
    private String parentId;

    @ApiModelProperty(value = "内容评论")
    private String content;

    @ApiModelProperty(value = "被评论的ID")
    private String targetId;

    @ApiModelProperty(value = "审核状态（0：待审核，1：审核通过，2：审核不通过）")
    private Integer examineStatus;

    @ApiModelProperty(value = "赞同数")
    private Integer fabulous;

    @ApiModelProperty(value = "反对数")
    private Integer oppose;

    @ApiModelProperty(value = "删除状态（0：未删除 1：已删除, 默认为：0）")
    private Boolean delStatus;

    @ApiModelProperty(value = "创建者(既评论者)")
    private String createBy;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
