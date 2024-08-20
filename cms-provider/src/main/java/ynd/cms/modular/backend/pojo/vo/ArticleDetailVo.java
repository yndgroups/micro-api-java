package ynd.cms.modular.backend.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
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
@Accessors(chain = true)
@ApiModel(value = "信息内容详情表详情", description = "信息内容详情表管理")
public class ArticleDetailVo {

    @ApiModelProperty(value = "文章id")
    private String artId;

    @ApiModelProperty(value = "新闻类型")
    private String colId;

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "标题缩略图片")
    private String thumb;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "来源（来自某某网站等等）")
    private String origin;

    @ApiModelProperty(value = "来源地址")
    private String originUrl;

    @ApiModelProperty(value = "访问计数器")
    private Integer viewsCount;

    @ApiModelProperty(value = "顶一下")
    private Integer digg;

    @ApiModelProperty(value = "踩一下")
    private Integer stamp;

    @ApiModelProperty(value = "删除状态（1：未删除 2：已删除）")
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
