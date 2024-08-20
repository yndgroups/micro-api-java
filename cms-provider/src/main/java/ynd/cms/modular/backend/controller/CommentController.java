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
import ynd.cms.modular.backend.service.CommentService;
import ynd.cms.modular.backend.pojo.dto.CommentInsertDTO;
import ynd.cms.modular.backend.pojo.dto.CommentUpdateDTO;
import ynd.cms.modular.backend.pojo.param.CommentParam;

/**
 * <p>
 * 评论 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-10
 */
@Api(tags = {"评论管理"})
@Validated
@RequestMapping("/comment")
@AdminController("AdminCommentController")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ApiOperation("新增")
    @PostMapping
    public BackResult insertComment(@RequestBody @Valid CommentInsertDTO commentInsertDTO) throws Exception {
        return commentService.insertComment(commentInsertDTO);
    }

    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteComment(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return commentService.deleteComment(deleteDTO);
    }

    @ApiOperation("修改")
    @PutMapping
    public BackResult updateComment(@RequestBody @Valid CommentUpdateDTO commentUpdateDTO) throws Exception {
        return commentService.updateComment(commentUpdateDTO);
    }

    @ApiOperation("查询分页列表")
    @PostMapping("findCommentPageList")
    public BackResult findCommentPageList(@RequestBody @Valid QueryParameter<CommentParam> queryParameter) throws Exception {
        return commentService.findCommentPageList(queryParameter);
    }

    @ApiOperation("根据id查询详情")
    @GetMapping("findCommentDetailById/{id}")
    public BackResult findCommentDetailById(@PathVariable(value = "id") String commentId) throws Exception {
        return commentService.findCommentDetailById(commentId);
    }

}
