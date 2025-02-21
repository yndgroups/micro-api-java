package ynd.shopping.modular.backend.pojo.vo;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 购物车列表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "购物车列表", description = "购物车")
public class CartListVo {

    @ApiModelProperty(value = "购物车ID")
    private Long cartId;

    @ApiModelProperty(value = "密钥")
    private String cartKey;

    @ApiModelProperty(value = "会员")
    private Long memberId;

    @ApiModelProperty(value = "过期时间")
    private LocalDateTime expireTime;

    @ApiModelProperty(value = "版本")
    private String version;

    @ApiModelProperty(value = "删除状态（false || 0：未删除，true || 1：删除）")
    private Boolean delStatus;

}
