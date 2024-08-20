package ynd.order.service.impl;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Test {
    @ApiModelProperty(value = "库存id")
    private String skuId;

    @ApiModelProperty(value = "已分配库存")
    private Double allocatedStock;
}
