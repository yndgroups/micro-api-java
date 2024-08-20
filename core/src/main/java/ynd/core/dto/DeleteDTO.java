package ynd.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Accessors(chain = true)
@Data
public class DeleteDTO {

    @ApiModelProperty(value = "需要删除id列表", required = true)
    @NotEmpty(message = "需要删除的id[数组]不能为空")
    @NotNull(message = "ids为必传参数")
    ArrayList<String> ids;

    @JsonIgnore
    private Long updateBy;
}
