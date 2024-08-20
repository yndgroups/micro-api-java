package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@Accessors(chain = true)
@ApiModel(value="枚举列表", description="枚举管理")
public class EnumListVo {

    @ApiModelProperty(value = "枚举id")
    private String enumId;

    @ApiModelProperty(value = "枚举父id")
    private String parentId;

    @ApiModelProperty(value = "枚举名称")
    private String enName;

    @ApiModelProperty(value = "枚举值")
    private String enVal;

    @ApiModelProperty(value = "删除（1：未删除，2：已删除）")
    private Integer delStatus;

}
