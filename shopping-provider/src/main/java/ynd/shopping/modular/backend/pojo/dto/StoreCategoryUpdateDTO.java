package ynd.shopping.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 店铺分类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "店铺分类修改", description = "店铺分类")
public class StoreCategoryUpdateDTO extends StoreCategoryInsertDTO {

    @ApiModelProperty(value = "店铺分类id")
    private Long storeCategoryId;

}
