package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.vo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

/**
 * description 删除id映射类
 *@author yangdaqiong
 *@date 2019/11/23 23:45
 **/
@ApiModel("统一删除：Vo")
@Data
public class DeleteVo {
    @ApiModelProperty(value = "需要删除的id列表", required = true)
    @NotEmpty(message = "需要删除的id不能为空")
    ArrayList<String> ids;

    @ApiModelProperty(value = "更新者", hidden = true)
    private String updateBy;
}
