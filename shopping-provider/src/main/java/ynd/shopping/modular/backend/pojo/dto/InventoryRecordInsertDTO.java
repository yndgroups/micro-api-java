package ynd.shopping.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 库存记录
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-10-04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "库存记录新增", description = "库存记录管理")
public class InventoryRecordInsertDTO {

    @ApiModelProperty(value = "入库数量")
    private Integer inQuantity;

    @ApiModelProperty(value = "出库数量")
    private Integer outQuantity;

    @ApiModelProperty(value = "当前库存")
    private Integer currentInventory;

    @ApiModelProperty(value = "类型(1:入库，0:出库，默认: 1)")
    private Boolean type;

    @ApiModelProperty(value = "关联sku_id")
    private Long skuId;

    @ApiModelProperty(value = "备注说明")
    private String memo;

    @ApiModelProperty(value = "版本")
    private String version;

}
