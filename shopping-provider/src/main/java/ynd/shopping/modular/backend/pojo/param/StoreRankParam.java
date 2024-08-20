package ynd.shopping.modular.backend.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 店铺等级查询参数
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-15
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "店铺等级查询条件", description = "店铺等级")
public class StoreRankParam {

    @ApiModelProperty(value = "memo")
    private String memo;

    @ApiModelProperty(value = "名称")
    private String name;

}
