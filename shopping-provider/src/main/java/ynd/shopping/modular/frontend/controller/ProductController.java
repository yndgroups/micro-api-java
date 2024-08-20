package ynd.shopping.modular.frontend.controller;

import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.shopping.annotation.FrontendController;
import ynd.shopping.modular.frontend.pojo.param.ProductParam;
import ynd.shopping.modular.frontend.pojo.vo.ProductCategoryListVo;
import ynd.shopping.modular.frontend.pojo.vo.ProductDetailVo;
import ynd.shopping.modular.frontend.pojo.vo.ProductListVo;
import ynd.shopping.modular.frontend.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 商品 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-11
 */
@Api(tags = {"商品相关"})
@Validated
@RequestMapping("/noAuth/product")
@FrontendController("FrontendProductController")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("查询分页列表")
    @PostMapping("findProductPageList")
    public BackResult<List<ProductListVo>> findProductPageList(@RequestBody @Valid QueryParameter<ProductParam> queryParameter) throws Exception {
        return productService.findProductPageList(queryParameter);
    }

    @ApiOperation("根据id查询详情")
    @GetMapping("findProductDetailById/{id}")
    public BackResult<ProductDetailVo> findProductDetailById(@PathVariable(value = "id") String productId) throws Exception {
        return productService.findProductDetailById(productId);
    }

    @ApiOperation("查询商品分类")
    @PostMapping("findProductCategory")
    public BackResult<List<ProductCategoryListVo>> findProductCategory() throws Exception {
        return productService.findProductCategory();
    }

}
