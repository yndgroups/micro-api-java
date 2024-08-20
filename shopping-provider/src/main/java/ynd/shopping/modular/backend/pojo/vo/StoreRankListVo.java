package ynd.shopping.modular.backend.pojo.vo;

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
public class StoreRankListVo {

    @ApiModelProperty(value = "id")
    private Long storeRankId;

    @ApiModelProperty(value = "版本")
    private Long version;

    @ApiModelProperty(value = "排序")
    private Integer orderBy;

    @ApiModelProperty(value = "是否允许注册")
    private Boolean whetherAllowRegister;

    @ApiModelProperty(value = "memo")
    private String memo;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "可发布商品数")
    private Long quantity;

    @ApiModelProperty(value = "服务费")
    private BigDecimal serviceFee;

    @ApiModelProperty(value = "删除状态（false || 0：未删除，true || 1：删除）")
    private Boolean delStatus;

}
