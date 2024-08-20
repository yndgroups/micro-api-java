package ynd.shopping.modular.backend.pojo.dto;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
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
@Accessors(chain = true)
@ApiModel(value = "店铺等级列表", description = "店铺等级")
public class StoreRankInsertDTO {

    @ApiModelProperty(value = "排序")
    private Integer orderBy;

    @ApiModelProperty(value = "是否允许注册")
    private Boolean whetherAllowRegister;

    @ApiModelProperty(value = "备注")
    private String memo;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "可发布商品数")
    private Long quantity;

    @ApiModelProperty(value = "服务费")
    private BigDecimal serviceFee;

    @ApiModelProperty(value = "版本")
    private Long version;

}
