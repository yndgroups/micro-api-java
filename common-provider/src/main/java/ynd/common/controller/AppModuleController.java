package ynd.common.controller;

import ynd.core.query.QueryParameter;
import ynd.common.service.AppModuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import ynd.core.result.BackResult;
import ynd.core.dto.DeleteDTO;
import ynd.common.pojo.vo.AppModuleInsertVo;
import ynd.common.pojo.vo.AppModuleUpdateVo;
import ynd.common.pojo.param.AppModuleParam;

/**
 * <p>
 * 应用模块 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-10-30
 */
@Api(tags = {"应用模块管理"})
@Validated
@RequestMapping("/appModule")
@RestController
public class AppModuleController {

    @Autowired
    private AppModuleService appModuleService;

    @ApiOperation("新增")
    @PostMapping
    public BackResult insertAppModule(@RequestBody @Valid AppModuleInsertVo appModuleInsertVo) throws Exception {
        return appModuleService.insertAppModule(appModuleInsertVo);
    }

    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteAppModule(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return appModuleService.deleteAppModule(deleteDTO);
    }

    @ApiOperation("修改")
    @PutMapping
    public BackResult updateAppModule(@RequestBody @Valid AppModuleUpdateVo appModuleUpdateVo) throws Exception {
        return appModuleService.updateAppModule(appModuleUpdateVo);
    }

    @ApiOperation("查询列表")
    @PostMapping("/findAppModulePageList")
    public BackResult findAppModulePageList(@RequestBody @Valid QueryParameter<AppModuleParam> queryParameter) throws Exception {
        return appModuleService.findAppModulePageList(queryParameter);
    }

    @ApiOperation("根据mdId查询详情")
    @GetMapping("/findAppModuleDetailById/{mdId}")
    public BackResult findAppModuleDetailById(@PathVariable String mdId) throws Exception {
        return appModuleService.findAppModuleDetailById(mdId);
    }

    @ApiOperation("根据appId查询模块列表")
    @GetMapping("/findAppModuleListByAppId/{appId}")
    public BackResult findAppModuleListByAppId(@PathVariable String appId) throws Exception {
        return appModuleService.findAppModuleListByAppId(appId);
    }

}
