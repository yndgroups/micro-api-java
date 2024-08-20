package ynd.shopping.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 属性
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "规格修改", description = "规格管理")
public class ProductSpecUpdateDTO extends ProductSpecInsertDTO {

    @ApiModelProperty(value = "规格id", required = true)
    @NotNull(message = "规格id不能为空")
    private Long specId;

}
