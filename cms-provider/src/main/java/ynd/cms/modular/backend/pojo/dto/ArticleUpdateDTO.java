package ynd.cms.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotNull;

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
@ApiModel(value = "文章修改", description = "文章管理")
public class ArticleUpdateDTO  extends ArticleInsertDTO {

    @ApiModelProperty(value = "文章id", required = true)
    @NotNull(message = "文章id不能为空")
    private Long artId;

}
