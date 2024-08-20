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
 * 信息内容详情表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_article")
@ApiModel(value = "信息内容详情表", description = "信息内容详情表Model")
public class ArticleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文章id")
    @TableId(value = "art_id", type = IdType.ASSIGN_UUID)
    private Long artId;

    @ApiModelProperty(value = "新闻类型")
    @TableField("category_id")
    private Long categoryId;

    @ApiModelProperty(value = "应用id")
    @TableField("app_id")
    private Long appId;

    @ApiModelProperty(value = "标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "标题缩略图片")
    @TableField("thumb")
    private String thumb;

    @ApiModelProperty(value = "内容")
    @TableField("cms")
    private String content;

    @ApiModelProperty(value = "来源（来自某某网站等等）")
    @TableField("origin")
    private String origin;

    @ApiModelProperty(value = "来源地址")
    @TableField("origin_url")
    private String originUrl;

    @ApiModelProperty(value = "访问计数器")
    @TableField("views_count")
    private Integer viewsCount;

    @ApiModelProperty(value = "顶一下")
    @TableField("digg")
    private Integer digg;

    @ApiModelProperty(value = "踩一下")
    @TableField("stamp")
    private Integer stamp;

    @ApiModelProperty(value = "删除状态（1：未删除 2：已删除）")
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
