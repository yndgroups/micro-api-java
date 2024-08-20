package ynd.common.controller;

import ynd.common.pojo.vo.RoleListVo;
import ynd.common.pojo.vo.RoleMenuInsert;
import ynd.core.annotation.AuthPermissions;
import ynd.core.dto.DeleteDTO;
import ynd.common.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import ynd.common.pojo.vo.RoleInsertVo;
import ynd.common.pojo.vo.RoleUpdateVo;
import ynd.common.pojo.param.RoleParam;
import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;

import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Api(tags = {"角色管理"})
@Validated
@RequestMapping("/role")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @AuthPermissions("system:role:insert")
    @ApiOperation("新增")
    @PostMapping
    public BackResult insertRole(@RequestBody @Valid RoleInsertVo roleInsertVo) throws Exception {
        return roleService.insertRole(roleInsertVo);
    }

    @AuthPermissions("system:role:delete")
    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteRole(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return roleService.deleteRole(deleteDTO);
    }

    @AuthPermissions("system:role:update")
    @ApiOperation("修改")
    @PutMapping
    public BackResult updateRole(@RequestBody @Valid RoleUpdateVo roleUpdateVo) throws Exception {
        return roleService.updateRole(roleUpdateVo);
    }

    // AuthPermissions("system:role:query")
    @ApiOperation("列表查询")
    @PostMapping("/findRolePageList")
    public BackResult<List<RoleListVo>> findRolePageList(@RequestBody @Valid QueryParameter<RoleParam> queryParameter) throws Exception {
        return roleService.findRolePageList(queryParameter);
    }

    // AuthPermissions("system:role:query")
    @ApiOperation("角色关联菜单")
    @PostMapping("/roleRelationMenu")
    public BackResult<List<RoleListVo>> roleRelationMenu(@RequestBody @Valid RoleMenuInsert roleMenuInsert) throws Exception {
        return roleService.roleRelationMenu(roleMenuInsert);
    }

}
