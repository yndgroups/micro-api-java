package ynd.cms.modular.backend.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

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
@ApiModel(value = "信息内容详情表查询条件", description = "信息内容详情表管理")
public class ArticleParam {

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "栏目id", required = true)
    @NotBlank(message = "栏目id不能为空")
    private String categoryId;

}
