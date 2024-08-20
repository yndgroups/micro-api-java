package ynd.shopping.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 品牌
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "品牌修改", description = "品牌管理")
public class BrandUpdateDTO extends BrandInsertDTO {

    @ApiModelProperty(value = "分类id")
    private Long brandId;

}
