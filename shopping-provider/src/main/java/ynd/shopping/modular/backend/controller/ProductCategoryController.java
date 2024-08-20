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
import ynd.shopping.modular.backend.service.ProductCategoryService;
import ynd.shopping.modular.backend.pojo.dto.ProductCategoryInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.ProductCategoryUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.ProductCategoryParam;

/**
 * <p>
 * 商品分类前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-30
 */
@Api(tags = {"商品分类"})
@Validated
@RequestMapping("/productCategory")
@AdminController("AdminProductCategoryController")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @ApiOperation("新增")
    @PostMapping
    public BackResult insertProductCategory(@RequestBody @Valid ProductCategoryInsertDTO productCategoryInsertDTO) throws Exception {
        return productCategoryService.insertProductCategory(productCategoryInsertDTO);
    }

    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteProductCategory(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return productCategoryService.deleteProductCategory(deleteDTO);
    }

    @ApiOperation("修改")
    @PutMapping
    public BackResult updateProductCategory(@RequestBody @Valid ProductCategoryUpdateDTO productCategoryUpdateVo) throws Exception {
        return productCategoryService.updateProductCategory(productCategoryUpdateVo);
    }

    @ApiOperation("查询列表")
    @PostMapping("/list")
    public BackResult queryProductCategoryPageList(@RequestBody @Valid QueryParameter<ProductCategoryParam> queryParameter) throws Exception {
        return productCategoryService.queryProductCategoryPageList(queryParameter);
    }

    @ApiOperation("根据id查询详情")
    @GetMapping("/detailById/{id}")
    public BackResult queryProductCategoryDetailById(@PathVariable(value = "id") String productCategoryId) throws Exception {
        return productCategoryService.queryProductCategoryDetailById(productCategoryId);
    }

    @ApiOperation("根据父id列表")
    @GetMapping("/listByParentId/{parentId}")
    public BackResult queryProductCategoryListByParentId(@PathVariable String parentId) throws Exception {
        return productCategoryService.queryProductCategoryListByParentId(parentId);
    }

}
