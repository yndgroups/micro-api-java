package ynd.shopping.modular.backend.controller;

import ynd.shopping.annotation.AdminController;
import ynd.shopping.modular.backend.pojo.dto.GoodsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;
import ynd.core.dto.DeleteDTO;
import ynd.shopping.modular.backend.service.ProductService;
import ynd.shopping.modular.backend.pojo.dto.ProductUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.ProductParam;

/**
 * <p>
 * 商品 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-12
 */
@Api(tags = {"商品管理"})
@Validated
@RequestMapping("/product")
@AdminController("AdminProductController")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("新增")
    @PostMapping
    public BackResult insertProduct(@RequestBody @Valid GoodsDTO goodsDTO) throws Exception {
        return productService.insertProduct(goodsDTO);
    }

    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteProduct(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return productService.deleteProduct(deleteDTO);
    }

    @ApiOperation("修改")
    @PutMapping
    public BackResult updateProduct(@RequestBody @Valid ProductUpdateDTO productUpdateDTO) throws Exception {
        return productService.updateProduct(productUpdateDTO);
    }

    @ApiOperation("查询列表")
    @PostMapping("findProductPageList")
    public BackResult findProductPageList(@RequestBody @Valid QueryParameter<ProductParam> queryParameter) throws Exception {
        return productService.findProductPageList(queryParameter);
    }

    @ApiOperation("根据id查询详情")
    @GetMapping("findProductDetailById/{id}")
    public BackResult findProductDetailById(@PathVariable(value = "id") String productId) throws Exception {
        return productService.findProductDetailById(productId);
    }

}
