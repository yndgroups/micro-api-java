package ynd.shopping.modular.backend.pojo.vo;

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
 * @date 2021-09-22
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "商品分类列表", description = "商品分类")
public class ProductCategoryListVo {

    @ApiModelProperty(value = "商品分类id")
    private String productCategoryId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "上级分类")
    private String parentId;

    @ApiModelProperty(value = "普通店铺分佣比例")
    private String profitSharing;

    @ApiModelProperty(value = "自营店铺分佣比例")
    private String selfRate;

    @ApiModelProperty(value = "版本")
    private String version;

    @ApiModelProperty(value = "排序")
    private String sortBy;

    @ApiModelProperty(value = "删除状态（false || 0：未删除，true || 1：删除）")
    private Boolean delStatus;

    @ApiModelProperty("下级数据统计")
    private Integer childCount;

}
