package ynd.shopping.modular.backend.pojo.dto;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 店铺分类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-08
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "店铺分类新增", description = "店铺分类")
public class StoreCategoryInsertDTO {

    @ApiModelProperty(value = "分类名称", required = true)
    @NotBlank(message = "分类名称")
    private String name;

    @ApiModelProperty(value = "保证金")
    private BigDecimal bail;

    @ApiModelProperty(value = "排序")
    private Integer sortBy;

    @ApiModelProperty(value = "版本号")
    private String version;

}
