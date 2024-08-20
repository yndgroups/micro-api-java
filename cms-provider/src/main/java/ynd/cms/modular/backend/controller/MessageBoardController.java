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
import ynd.cms.modular.backend.service.MessageBoardService;
import ynd.cms.modular.backend.pojo.dto.MessageBoardInsertDTO;
import ynd.cms.modular.backend.pojo.dto.MessageBoardUpdateDTO;
import ynd.cms.modular.backend.pojo.param.MessageBoardParam;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-11
 */
@Api(tags = {"留言板管理"})
@Validated
@RequestMapping("/messageBoard")
@AdminController("AdminMessageBoardController")
public class MessageBoardController {

    @Autowired
    private MessageBoardService messageBoardService;

    @ApiOperation("新增")
    @PostMapping
    public BackResult insertMessageBoard(@RequestBody @Valid MessageBoardInsertDTO messageBoardInsertDTO) throws Exception {
        return messageBoardService.insertMessageBoard(messageBoardInsertDTO);
    }

    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteMessageBoard(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return messageBoardService.deleteMessageBoard(deleteDTO);
    }

    @ApiOperation("修改")
    @PutMapping
    public BackResult updateMessageBoard(@RequestBody @Valid MessageBoardUpdateDTO messageBoardUpdateDTO) throws Exception {
        return messageBoardService.updateMessageBoard(messageBoardUpdateDTO);
    }

    @ApiOperation("查询分页列表")
    @PostMapping("findMessageBoardPageList")
    public BackResult findMessageBoardPageList(@RequestBody @Valid QueryParameter<MessageBoardParam> queryParameter) throws Exception {
        return messageBoardService.findMessageBoardPageList(queryParameter);
    }

    @ApiOperation("根据id查询详情")
    @GetMapping("findMessageBoardDetailById/{id}")
    public BackResult findMessageBoardDetailById(@PathVariable(value = "id") String msgId) throws Exception {
        return messageBoardService.findMessageBoardDetailById(msgId);
    }

}
