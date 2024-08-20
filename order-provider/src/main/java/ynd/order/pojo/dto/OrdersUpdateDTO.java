package ynd.order.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Orders: Vo", description="订单")
public class OrdersUpdateDTO extends OrdersInsertDTO {

    @ApiModelProperty(value = "订单id")
    private String orderId;

}
