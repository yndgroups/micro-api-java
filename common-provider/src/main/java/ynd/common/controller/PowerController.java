package ynd.common.controller;

import ynd.common.pojo.vo.PowerListVo;
import ynd.core.annotation.AuthPermissions;
import ynd.common.pojo.vo.RoleAndMenuVo;
import ynd.core.dto.DeleteDTO;
import ynd.common.service.PowerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import ynd.common.pojo.vo.PowerInsertVo;
import ynd.common.pojo.vo.PowerUpdateVo;
import ynd.common.pojo.param.PowerParam;
import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Api(tags = {"权限管理"})
@Validated
@RequestMapping("/power")
@RestController
public class PowerController {

    @Autowired
    private PowerService powerService;

    @AuthPermissions("system:power:insert")
    @ApiOperation("新增")
    @PostMapping
    public BackResult insertPower(@RequestBody @Valid PowerInsertVo powerInsertVo) throws Exception {
        return powerService.addPower(powerInsertVo);
    }

    @AuthPermissions("system:power:delete")
    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deletePower(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return powerService.deletePower(deleteDTO);
    }

    @AuthPermissions("system:power:update")
    @ApiOperation("修改")
    @PutMapping
    public BackResult updatePower(@RequestBody @Valid PowerUpdateVo powerUpdateVo) throws Exception {
        return powerService.updatePower(powerUpdateVo);
    }

    @AuthPermissions("system:power:query")
    @ApiOperation("列表查询")
    @PostMapping("/findPowerPageList")
    public BackResult<List<PowerListVo>> findPowerPageList(@RequestBody @Valid QueryParameter<PowerParam> queryParameter) throws Exception {
        return powerService.findPowerPageList(queryParameter);
    }

    @AuthPermissions("system:power:bind")
    @ApiOperation("绑定角色和菜单")
    @PostMapping("/bindRoleAndMenus")
    public BackResult bindRoleAndMenus(@RequestBody @Valid List<RoleAndMenuVo> roleAndMenuVos) throws Exception {
        return powerService.bindRoleAndMenus(roleAndMenuVos);
    }

}
