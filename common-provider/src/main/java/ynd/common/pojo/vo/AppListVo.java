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
@ApiModel(value="应用列表", description="应用表")
public class AppListVo {

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "模块id")
    private String mdId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "介绍")
    private String introduce;

    @ApiModelProperty(value = "排序")
    private Integer sortBy;

    @ApiModelProperty(value = "启用状态（0:禁用 1：启用）")
    private Boolean enableStatus;

    @ApiModelProperty(value = "删除状态（0:未删除 1：删除）")
    private Boolean delStatus;

}
