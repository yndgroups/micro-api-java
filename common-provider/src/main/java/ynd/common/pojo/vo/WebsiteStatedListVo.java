package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 站点使用协议及声明表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@Accessors(chain = true)
@ApiModel(value="站点使用协议及声明列表", description="站点使用协议及声明表")
public class WebsiteStatedListVo {

    @ApiModelProperty(value = "声明主键id")
    private Long stateId;

    @ApiModelProperty(value = "属于某个应用的声明（关联appId）")
    private Long appId;

    @ApiModelProperty(value = "类型（1：网站声明永远只有一条， 2：其他相关内容比如操作手册）")
    private Integer stateType;

    @ApiModelProperty(value = "声明标题")
    private String title;

    @ApiModelProperty(value = "声明内容")
    private String content;

    @ApiModelProperty(value = "删除状态")
    private Integer delStatus;

}
