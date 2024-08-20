package ynd.shopping.modular.backend.entity;

import java.math.BigDecimal;

import ynd.core.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 店铺等级
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_store_rank")
@ApiModel(value="StoreRankEntity对象", description="店铺等级")
public class StoreRankEntity extends BaseEntity {

    @ApiModelProperty(value = "ID")
    @TableId(value = "store_rank_id", type = IdType.ASSIGN_UUID)
    private Long storeRankId;

    @ApiModelProperty(value = "是否允许注册")
    @TableField("whether_allow_register")
    private Boolean whetherAllowRegister;

    @ApiModelProperty(value = "备注")
    @TableField("memo")
    private String memo;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "可发布商品数")
    @TableField("quantity")
    private Long quantity;

    @ApiModelProperty(value = "服务费")
    @TableField("service_fee")
    private BigDecimal serviceFee;

    @ApiModelProperty(value = "排序")
    @TableField("sort_by")
    private Integer sortBy;

    @ApiModelProperty(value = "版本")
    @TableField("version")
    private Long version;

}
