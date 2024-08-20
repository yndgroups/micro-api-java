package ynd.cms.modular.backend.controller;

import ynd.cms.annotation.AdminController;
import ynd.cms.modular.backend.pojo.vo.WebsiteStatedDetailVo;
import ynd.cms.modular.backend.pojo.vo.WebsiteStatedListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;
import ynd.core.dto.DeleteDTO;
import ynd.cms.modular.backend.service.WebsiteStatedService;
import ynd.cms.modular.backend.pojo.dto.WebsiteStatedInsertDTO;
import ynd.cms.modular.backend.pojo.dto.WebsiteStatedUpdateDTO;
import ynd.cms.modular.backend.pojo.param.WebsiteStatedParam;

import java.util.List;

/**
 * <p>
 * 站点使用协议及声明表 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-15
 */
@Api(tags = {"站长声明管理"})
@Validated
@RequestMapping("/websiteStated")
@AdminController("AdminWebsiteStatedController")
public class WebsiteStatedController {

    @Autowired
    private WebsiteStatedService websiteStatedService;

    @ApiOperation("新增")
    @PostMapping
    public BackResult insertWebsiteStated(@RequestBody @Valid WebsiteStatedInsertDTO websiteStatedInsertDTO) throws Exception {
        return websiteStatedService.insertWebsiteStated(websiteStatedInsertDTO);
    }

    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteWebsiteStated(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return websiteStatedService.deleteWebsiteStated(deleteDTO);
    }

    @ApiOperation("修改")
    @PutMapping
    public BackResult updateWebsiteStated(@RequestBody @Valid WebsiteStatedUpdateDTO websiteStatedUpdateDTO) throws Exception {
        return websiteStatedService.updateWebsiteStated(websiteStatedUpdateDTO);
    }

    @ApiOperation("查询分页列表")
    @PostMapping("findWebsiteStatedPageList")
    public BackResult<List<WebsiteStatedListVo>> findWebsiteStatedPageList(@RequestBody @Valid QueryParameter<WebsiteStatedParam> queryParameter) throws Exception {
        return websiteStatedService.findWebsiteStatedPageList(queryParameter);
    }

    @ApiOperation("根据id查询详情")
    @GetMapping("findWebsiteStatedDetailById/{id}")
    public BackResult<WebsiteStatedDetailVo> findWebsiteStatedDetailById(@PathVariable(value = "id") String stateId) throws Exception {
        return websiteStatedService.findWebsiteStatedDetailById(stateId);
    }

}
