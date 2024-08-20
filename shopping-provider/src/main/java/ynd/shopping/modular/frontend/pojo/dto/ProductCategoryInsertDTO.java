package ynd.shopping.modular.frontend.pojo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品分类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "商品分类新增", description = "商品分类管理")
public class ProductCategoryInsertDTO {

    @ApiModelProperty(value = "上级分类")
    private Long parentId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "自营店铺分佣比例")
    private Double selfRate;

    @ApiModelProperty(value = "普通店铺分佣比例")
    private Double profitSharing;

    @ApiModelProperty(value = "排序")
    private Integer sortBy;

    @ApiModelProperty(value = "版本")
    private String version;

}
