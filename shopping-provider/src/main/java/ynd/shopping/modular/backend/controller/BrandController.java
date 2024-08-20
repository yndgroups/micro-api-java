package ynd.shopping.modular.backend.controller;

import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.core.dto.DeleteDTO;
import ynd.shopping.modular.backend.entity.BrandEntity;
import ynd.shopping.annotation.AdminController;
import ynd.shopping.modular.backend.pojo.param.BrandParam;
import ynd.shopping.modular.backend.pojo.dto.BrandInsertDTO;
import ynd.shopping.modular.backend.pojo.vo.BrandListVo;
import ynd.shopping.modular.backend.pojo.dto.BrandUpdateDTO;
import ynd.shopping.modular.backend.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 品牌 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-28
 */
@Api(tags = {"品牌管理"})
@Validated
@RequestMapping("/brand")
@AdminController("AdminBrandController")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @ApiOperation("新增")
    @PostMapping
    public BackResult insertBrand(@RequestBody @Valid BrandInsertDTO brandInsertDTO) throws Exception {
        return brandService.insertBrand(brandInsertDTO);
    }

    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteBrand(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return brandService.deleteBrand(deleteDTO);
    }

    @ApiOperation("修改")
    @PutMapping
    public BackResult updateBrand(@RequestBody @Valid BrandUpdateDTO brandUpdateVo) throws Exception {
        return brandService.updateBrand(brandUpdateVo);
    }

    @ApiOperation("列表查询")
    @PostMapping("/list")
    public BackResult<List<BrandListVo>> queryBrandPageList(@RequestBody @Valid QueryParameter<BrandParam> queryParameter) throws Exception {
        return brandService.queryBrandPageList(queryParameter);
    }

    @ApiOperation("根据商品分类查询商品列表")
    @GetMapping("/listByProductCategoryId/{productCategoryId}")
    public BackResult<List<BrandListVo>> listByProductCategoryId(@PathVariable String productCategoryId) throws Exception {
        return brandService.listByProductCategoryId(productCategoryId);
    }

    @ApiOperation("根据id查询详情")
    @GetMapping("/detailById/{id}")
    public BackResult<BrandEntity> queryBrandDetailById(@PathVariable(value = "id") String brandId) throws Exception {
        return brandService.queryBrandDetailById(brandId);
    }

}
