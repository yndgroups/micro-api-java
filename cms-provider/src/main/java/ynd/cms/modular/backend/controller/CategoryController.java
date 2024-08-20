package ynd.cms.modular.backend.controller;

import ynd.cms.annotation.AdminController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;
import ynd.core.dto.DeleteDTO;
import ynd.cms.modular.backend.service.CategoryService;
import ynd.cms.modular.backend.pojo.dto.CategoryInsertDTO;
import ynd.cms.modular.backend.pojo.dto.CategoryUpdateDTO;
import ynd.cms.modular.backend.pojo.param.CategoryParam;

/**
 * <p>
 * 信息分类表 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-10
 */
@Api(tags = {"分类管理"})
@Validated
@RequestMapping("/category")
@AdminController("AdminCategoryController")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation("新增")
    @PostMapping
    public BackResult insertCategory(@RequestBody @Valid CategoryInsertDTO categoryInsertDTO) throws Exception {
        return categoryService.insertCategory(categoryInsertDTO);
    }

    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteCategory(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return categoryService.deleteCategory(deleteDTO);
    }

    @ApiOperation("修改")
    @PutMapping
    public BackResult updateCategory(@RequestBody @Valid CategoryUpdateDTO categoryUpdateDTO) throws Exception {
        return categoryService.updateCategory(categoryUpdateDTO);
    }

    @ApiOperation("查询分页列表")
    @PostMapping("findCategoryPageList")
    public BackResult findCategoryPageList(@RequestBody @Valid QueryParameter<CategoryParam> queryParameter) throws Exception {
        return categoryService.findCategoryPageList(queryParameter);
    }

    @ApiOperation("根据父id查询子列表")
    @GetMapping("findCategoryListByParentId/{parentId}")
    public BackResult findCategoryListByParentId(@PathVariable String parentId) throws Exception {
        return categoryService.findCategoryListByParentId(parentId);
    }

    @ApiOperation("根据父id查询树状列表")
    @GetMapping("findCategoryTreeListByParentId/{parentId}")
    public BackResult findCategoryTreeListByParentId(@PathVariable String parentId) throws Exception {
        return categoryService.findCategoryTreeListByParentId(parentId);
    }

    @ApiOperation("根据id查询详情")
    @GetMapping("findCategoryDetailById/{id}")
    public BackResult findCategoryDetailById(@PathVariable(value = "id") String categoryId) throws Exception {
        return categoryService.findCategoryDetailById(categoryId);
    }

}
