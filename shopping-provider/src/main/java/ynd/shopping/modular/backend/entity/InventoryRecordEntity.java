package ynd.shopping.modular.backend.entity;

import ynd.core.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_inventory_record")
@ApiModel(value = "库存记录", description = "库存记录Model")
public class InventoryRecordEntity extends BaseEntity {

    @ApiModelProperty(value = "库存记录id")
    @TableId(value = "inventory_record_id")
    private Long inventoryRecordId;

    @ApiModelProperty(value = "入库数量")
    @TableField("in_quantity")
    private Integer inQuantity;

    @ApiModelProperty(value = "出库数量")
    @TableField("out_quantity")
    private Integer outQuantity;

    @ApiModelProperty(value = "当前库存")
    @TableField("current_inventory")
    private Integer currentInventory;

    @ApiModelProperty(value = "类型(1:入库，0:出库，默认: 1)")
    @TableField("type")
    private Boolean type;

    @ApiModelProperty(value = "关联sku_id")
    @TableField("sku_id")
    private Long skuId;

    @ApiModelProperty(value = "备注说明")
    @TableField("memo")
    private String memo;

    @ApiModelProperty(value = "版本")
    @TableField("version")
    private String version;

}
