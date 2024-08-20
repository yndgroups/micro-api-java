package ynd.shopping.modular.backend.entity;

import ynd.core.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_cart")
@ApiModel(value="CartEntity对象", description="购物车")
public class CartEntity extends BaseEntity {

    @ApiModelProperty(value = "购物车ID")
    @TableId(value = "cart_id", type = IdType.ASSIGN_UUID)
    private Long cartId;

    @ApiModelProperty(value = "密钥")
    @TableField("cart_key")
    private String cartKey;

    @ApiModelProperty(value = "会员")
    @TableField("member_id")
    private String memberId;

    @ApiModelProperty(value = "过期时间")
    @TableField("expire_time")
    private LocalDateTime expireTime;

    @ApiModelProperty(value = "版本")
    @TableField("version")
    private String version;

}
