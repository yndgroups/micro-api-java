package ynd.shopping.modular.backend.controller;

import ynd.shopping.annotation.AdminController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;
import ynd.core.dto.DeleteDTO;
import ynd.shopping.modular.backend.service.ProductSkuService;
import ynd.shopping.modular.backend.pojo.dto.ProductSkuInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.ProductSkuUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.ProductSkuParam;

/**
 * <p>
 * sku 库存表 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-12
 */
@Api(tags = {"商品SKU"})
@Validated
@RequestMapping("/sku")
@AdminController("AdminProductSkuController")
public class ProductSkuController {

    @Autowired
    private ProductSkuService productSkuService;

    @ApiOperation("新增")
    @PostMapping
    public BackResult insertProductSku(@RequestBody @Valid ProductSkuInsertDTO productSkuInsertDTO) throws Exception {
        return productSkuService.insertProductSku(productSkuInsertDTO);
    }

    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteProductSku(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return productSkuService.deleteProductSku(deleteDTO);
    }

    @ApiOperation("修改")
    @PutMapping
    public BackResult updateProductSku(@RequestBody @Valid ProductSkuUpdateDTO productSkuUpdateDTO) throws Exception {
        return productSkuService.updateProductSku(productSkuUpdateDTO);
    }

    @ApiOperation("查询列表")
    @PostMapping("list")
    public BackResult queryProductSkuPageList(@RequestBody @Valid QueryParameter<ProductSkuParam> queryParameter) throws Exception {
        return productSkuService.queryProductSkuPageList(queryParameter);
    }

    @ApiOperation("根据skuId查询详情")
    @GetMapping("detailById/{id}")
    public BackResult queryProductSkuDetailById(@PathVariable(value = "id") String skuId) throws Exception {
        return productSkuService.queryProductSkuDetailById(skuId);
    }

}
