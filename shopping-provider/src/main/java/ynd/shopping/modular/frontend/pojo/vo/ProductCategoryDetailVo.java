package ynd.shopping.modular.frontend.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
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
@ApiModel(value = "商品分类详情", description = "商品分类管理")
public class ProductCategoryDetailVo {

    @ApiModelProperty(value = "商品分类id")
    private Long productCategoryId;

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

    @ApiModelProperty(value = "删除状态（删除：0，正常：1，默认：0）")
    private Integer delStatus;

    @ApiModelProperty(value = "创建者")
    private Long createBy;

    @ApiModelProperty(value = "更新者")
    private Long updateBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
