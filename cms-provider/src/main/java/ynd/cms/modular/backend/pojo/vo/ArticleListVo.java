package ynd.cms.modular.backend.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

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
@ApiModel(value = "信息内容详情表列表", description = "信息内容详情表管理")
public class ArticleListVo {

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

    @ApiModelProperty(value = "删除状态（0：未删除 1：已删除）")
    private Boolean delStatus;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createTime;

}
