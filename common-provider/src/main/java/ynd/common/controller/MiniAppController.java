package ynd.common.controller;

import ynd.common.pojo.vo.MiniAppListVo;
import ynd.core.annotation.AuthPermissions;
import ynd.core.dto.DeleteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import ynd.common.service.MiniAppService;
import ynd.common.pojo.vo.MiniAppInsertVo;
import ynd.common.pojo.vo.MiniAppUpdateVo;
import ynd.common.pojo.param.MiniAppParam;
import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;

import java.util.List;

/**
 * <p>
 * 微应用 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Api(tags = {"微应用管理"})
@Validated
@RequestMapping("/miniApp")
@RestController
public class MiniAppController {

    @Autowired
    private MiniAppService miniAppService;

    @AuthPermissions("system:mini-app:insert")
    @ApiOperation("新增")
    @PostMapping
    public BackResult insertMiniApp(@RequestBody @Valid MiniAppInsertVo miniAppInsertVo) throws Exception {
        return miniAppService.addMiniApp(miniAppInsertVo);
    }

    @AuthPermissions("system:mini-app:delete")
    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteMiniApp(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return miniAppService.deleteMiniApp(deleteDTO);
    }

    @AuthPermissions("system:mini-app:update")
    @ApiOperation("修改")
    @PutMapping
    public BackResult updateMiniApp(@RequestBody @Valid MiniAppUpdateVo miniAppUpdateVo) throws Exception {
        return miniAppService.updateMiniApp(miniAppUpdateVo);
    }

    @AuthPermissions("system:mini-app:query")
    @ApiOperation("列表查询")
    @PostMapping("/findMiniAppPageList")
    public BackResult<List<MiniAppListVo>> findMiniAppPageList(@RequestBody @Valid QueryParameter<MiniAppParam> queryParameter) throws Exception {
        return miniAppService.findMiniAppPageList(queryParameter);
    }

}
