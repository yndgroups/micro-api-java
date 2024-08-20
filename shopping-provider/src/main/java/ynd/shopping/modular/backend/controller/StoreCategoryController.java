package ynd.shopping.modular.backend.controller;

import ynd.shopping.annotation.AdminController;
import ynd.shopping.modular.backend.pojo.vo.StoreCategoryListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;
import ynd.core.dto.DeleteDTO;
import ynd.shopping.modular.backend.service.StoreCategoryService;
import ynd.shopping.modular.backend.pojo.dto.StoreCategoryInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.StoreCategoryUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.StoreCategoryParam;

import java.util.List;

/**
 * <p>
 * 店铺分类 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-08
 */
@Api(tags = {"店铺分类管理"})
@Validated
@RequestMapping("/storeCategory")
@AdminController("AdminStoreCategoryController")
public class StoreCategoryController {

    @Autowired
    private StoreCategoryService storeCategoryService;

    @ApiOperation("新增")
    @PostMapping
    public BackResult insertStoreCategory(@RequestBody @Valid StoreCategoryInsertDTO storeCategoryInsertDTO) throws Exception {
        return storeCategoryService.insertStoreCategory(storeCategoryInsertDTO);
    }

    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteStoreCategory(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return storeCategoryService.deleteStoreCategory(deleteDTO);
    }

    @ApiOperation("修改")
    @PutMapping
    public BackResult updateStoreCategory(@RequestBody @Valid StoreCategoryUpdateDTO storeCategoryUpdateVo) throws Exception {
        return storeCategoryService.updateStoreCategory(storeCategoryUpdateVo);
    }

    @ApiOperation("列表查询")
    @PostMapping("/list")
    public BackResult<List<StoreCategoryListVo>> queryStoreCategoryPageList(@RequestBody @Valid QueryParameter<StoreCategoryParam> queryParameter) throws Exception {
        return storeCategoryService.queryStoreCategoryPageList(queryParameter);
    }

}
