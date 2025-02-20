package ynd.cms.modular.backend.pojo.dto;

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
 * @date 2021-12-15
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "站点使用协议及声明表新增", description = "站点使用协议及声明表管理")
public class WebsiteStatedInsertDTO {

    @ApiModelProperty(value = "属于某个应用的声明（关联appId）")
    private Long appId;

    @ApiModelProperty(value = "类型（1：网站声明永远只有一条， 2：其他相关内容比如操作手册）")
    private Integer stateType;

    @ApiModelProperty(value = "声明标题")
    private String title;

    @ApiModelProperty(value = "声明内容")
    private String content;

}
