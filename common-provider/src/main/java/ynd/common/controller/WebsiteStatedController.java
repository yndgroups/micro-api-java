package ynd.common.controller;

import ynd.common.pojo.param.WebsiteStatedParam;
import ynd.core.annotation.AuthPermissions;
import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.common.pojo.vo.WebsiteStatedInsertVo;
import ynd.common.pojo.vo.WebsiteStatedUpdateVo;
import ynd.common.service.WebsiteStatedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Api(tags = {"网站声明管理"})
@Validated
@RestController
@RequestMapping("/websiteStated")
public class WebsiteStatedController {

    @Autowired
    private WebsiteStatedService websiteStatedService;

    @AuthPermissions("system:website:insert")
    @ApiOperation("新增")
    @PostMapping
    public BackResult insertWebsiteStated(@RequestBody @Valid WebsiteStatedInsertVo websiteStatedInsertVo) throws Exception {
        return websiteStatedService.insertWebsiteStated(websiteStatedInsertVo);
    }

    @AuthPermissions("system:website:delete")
    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteWebsiteStated(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return websiteStatedService.deleteWebsiteStated(deleteDTO);
    }

    @AuthPermissions("system:website:update")
    @ApiOperation("修改")
    @PutMapping
    public BackResult updateWebsiteState(@RequestBody @Valid WebsiteStatedUpdateVo websiteStatedUpdateVo) throws Exception {
        return websiteStatedService.updateWebsiteStated(websiteStatedUpdateVo);
    }

    @AuthPermissions("system:website:query")
    @ApiOperation("列表查询")
    @PostMapping("/findWebsiteStatedPageList")
    public BackResult findWebsiteStatedPageList(@RequestBody @Valid QueryParameter<WebsiteStatedParam> queryParameter) throws Exception {
        return websiteStatedService.findWebsiteStatedPageList(queryParameter);
    }

    @ApiOperation("根据appId获取网站声明详情")
    @GetMapping("findWebsiteStatedDetailByAppId/{appId}")
    public BackResult findWebsiteStatedDetailByAppId( @PathVariable String appId) {
        return websiteStatedService.findWebsiteStatedDetailByAppId(appId);
    }

    @ApiOperation("根据stateId获取网站声明详情")
    @GetMapping("findWebsiteStatedDetailByStateId/{stateId}")
    public BackResult findWebsiteStatedDetailByStateId(@PathVariable @NotBlank(message = "appId不能为空") String stateId) {
        return websiteStatedService.findWebsiteStatedDetailByStateId(stateId);
    }

}
