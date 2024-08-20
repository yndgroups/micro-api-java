package ynd.common.pojo.vo;

import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 应用表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@Accessors(chain = true)
@ApiModel(value="应用新增", description="应用表")
public class AppInsertVo {

    @ApiModelProperty(value = "名称", required = true)
    @NotBlank(message = "名称不能为空")
    private String name;

    @ApiModelProperty(value = "图标", required = true)
    @NotBlank(message = "图标不能为空")
    private String icon;

    @ApiModelProperty(value = "模块id", required = true)
    @NotBlank(message = "模块id不能为空")
    private String mdId;

    @ApiModelProperty(value = "介绍", required = true)
    @NotBlank(message = "介绍不能为空")
    private String introduce;

    @ApiModelProperty(value = "排序")
    private Integer sortBy;

    @ApiModelProperty(value = "启用状态（1:启用 2：已禁用）")
    private Integer enableStatus;

    @ApiModelProperty(value = "删除状态（1:未删除 2：已删除）")
    private Integer delStatus;

}
