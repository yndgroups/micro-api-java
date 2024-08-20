package ynd.shopping.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel("商品添加")
@Data
public class GoodsDTO {

    @ApiModelProperty(value = "商品基本信息", required = true)
    private ProductInsertDTO productInsertDTO;

    @ApiModelProperty(value = "SKU", required = true)
    private List<ProductSkuInsertDTO> productSkuInsertDTO;

}
