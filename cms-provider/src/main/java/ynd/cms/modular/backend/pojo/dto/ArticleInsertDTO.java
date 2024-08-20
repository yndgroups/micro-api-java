package ynd.cms.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "文章新增", description = "文章管理")
public class ArticleInsertDTO {

    @ApiModelProperty(value = "文章类型", required = true)
    private Long categoryId;

    @ApiModelProperty(value = "应用id", required = true)
    private Long appId;

    @ApiModelProperty(value = "标题", required = true)
    private String title;

    @ApiModelProperty(value = "描述", required = true)
    private String description;

    @ApiModelProperty(value = "标题缩略图片", required = true)
    private String thumb;

    @ApiModelProperty(value = "内容", required = true)
    private String content;

    @ApiModelProperty(value = "来源（来自某某网站等等）", required = true)
    private String origin;

    @ApiModelProperty(value = "来源地址", required = true)
    private String originUrl;

}
