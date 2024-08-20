package ynd.shopping.modular.backend.pojo.param;

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
 * 店铺分类查询参数
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-08
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "店铺分类查询条件", description = "店铺分类")
public class StoreCategoryParam {

    @ApiModelProperty(value = "保证金")
    private BigDecimal bail;

    @ApiModelProperty(value = "分类名称")
    private String name;

}
