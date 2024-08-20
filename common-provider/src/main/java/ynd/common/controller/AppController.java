package ynd.common.controller;

import ynd.common.pojo.vo.AppListVo;
import ynd.core.annotation.AuthPermissions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import ynd.common.service.AppService;
import ynd.common.pojo.vo.AppInsertVo;
import ynd.common.pojo.vo.AppUpdateVo;
import ynd.common.pojo.param.AppParam;
import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;
import ynd.core.dto.DeleteDTO;

import java.util.List;

/**
 * <p>
 * 应用表 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Api(tags = {"应用管理"})
@Validated
@RequestMapping("/app")
@RestController
public class AppController {

    @Autowired
    private AppService appService;

    @AuthPermissions("system:app:insert")
    @ApiOperation("新增")
    @PostMapping
    public BackResult insertApp(@RequestBody @Valid AppInsertVo appInsertVo) throws Exception {
        return appService.addApp(appInsertVo);
    }

    @AuthPermissions("system:app:delete")
    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteApp(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return appService.deleteApp(deleteDTO);
    }

    @AuthPermissions("system:app:update")
    @ApiOperation("修改")
    @PutMapping
    public BackResult updateApp(@RequestBody @Valid AppUpdateVo appUpdateVo) throws Exception {
        return appService.updateApp(appUpdateVo);
    }

    @AuthPermissions("system:app:query")
    @ApiOperation("列表查询")
    @PostMapping("/findAppPageList")
    public BackResult<List<AppListVo>> findPageList(@RequestBody @Valid QueryParameter<AppParam> queryParameter) throws Exception {
        return appService.findPageList(queryParameter);
    }

    // @AuthPermissions("system:app:query")
    @ApiOperation("查询权限下应用")
    @GetMapping("/findAppListByUserId")
    public BackResult<List<AppListVo>>  findAppListByUserId() throws Exception {
        return appService.findAppListByUserId();
    }

}
