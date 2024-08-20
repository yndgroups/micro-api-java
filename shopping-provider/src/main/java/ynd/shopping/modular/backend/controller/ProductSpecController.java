package ynd.shopping.modular.backend.controller;

import ynd.core.dto.DeleteDTO;
import ynd.shopping.annotation.AdminController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;
import ynd.shopping.modular.backend.service.ProductSpecService;
import ynd.shopping.modular.backend.pojo.dto.ProductSpecInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.ProductSpecUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.ProductSpecParam;

/**
 * <p>
 * 规格前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-08
 */
@Api(tags = {"商品规格管理"})
@Validated
@RequestMapping("/productSpec")
@AdminController("AdminProductSpecController")
public class ProductSpecController {

    @Autowired
    private ProductSpecService productSpecService;

    @ApiOperation("新增")
    @PostMapping
    public BackResult insertProductSpec(@RequestBody @Valid ProductSpecInsertDTO productSpecInsertDTO) throws Exception {
        return productSpecService.insertProductSpec(productSpecInsertDTO);
    }

    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteProductSpec(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return productSpecService.deleteProductSpec(deleteDTO);
    }

    @ApiOperation("修改")
    @PutMapping
    public BackResult updateProductSpec(@RequestBody @Valid ProductSpecUpdateDTO productSpecUpdateDTO) throws Exception {
        return productSpecService.updateProductSpec(productSpecUpdateDTO);
    }

    @ApiOperation("查询列表")
    @PostMapping("list")
    public BackResult queryProductSpecPageList(@RequestBody @Valid QueryParameter<ProductSpecParam> queryParameter) throws Exception {
        return productSpecService.queryProductSpecPageList(queryParameter);
    }

    @ApiOperation("根据productCategoryId查询列表")
    @GetMapping("listByProductCategoryId/{id}")
    public BackResult listProductSpecByProductCategoryId(@PathVariable(value = "id") String productCategoryId) throws Exception {
        return productSpecService.listProductSpecByProductCategoryId(productCategoryId);
    }

    @ApiOperation("根据id查询详情")
    @GetMapping("detailById/{id}")
    public BackResult queryProductSpecDetailById(@PathVariable(value = "id") String specId) throws Exception {
        return productSpecService.queryProductSpecDetailById(specId);
    }

}
