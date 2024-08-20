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
import ynd.cms.modular.backend.service.ArticleService;
import ynd.cms.modular.backend.pojo.dto.ArticleInsertDTO;
import ynd.cms.modular.backend.pojo.dto.ArticleUpdateDTO;
import ynd.cms.modular.backend.pojo.param.ArticleParam;

/**
 * <p>
 * 信息内容详情表 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-10
 */
@Api(tags = {"文章管理"})
@Validated
@RequestMapping("/article")
@AdminController("AdminArticleController")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation("新增")
    @PostMapping
    public BackResult insertArticle(@RequestBody @Valid ArticleInsertDTO articleInsertDTO) throws Exception {
        return articleService.insertArticle(articleInsertDTO);
    }

    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteArticle(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return articleService.deleteArticle(deleteDTO);
    }

    @ApiOperation("修改")
    @PutMapping
    public BackResult updateArticle(@RequestBody @Valid ArticleUpdateDTO articleUpdateDTO) throws Exception {
        return articleService.updateArticle(articleUpdateDTO);
    }

    @ApiOperation("查询分页列表")
    @PostMapping("findArticlePageList")
    public BackResult findArticlePageList(@RequestBody @Valid QueryParameter<ArticleParam> queryParameter) throws Exception {
        return articleService.findArticlePageList(queryParameter);
    }

    @ApiOperation("根据id查询详情")
    @GetMapping("findArticleDetailById/{id}")
    public BackResult findArticleDetailById(@PathVariable(value = "id") String artId) throws Exception {
        return articleService.findArticleDetailById(artId);
    }

}
