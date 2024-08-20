package ynd.shopping.modular.backend.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 购物车查询参数
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "购物车查询条件", description = "购物车")
public class CartParam {

    @ApiModelProperty(value = "密钥")
    private String cartKey;

    @ApiModelProperty(value = "会员")
    private String memberId;

}
