package ynd.common.controller;

import ynd.common.pojo.vo.MenuListVo;
import ynd.core.annotation.AuthPermissions;
import ynd.core.result.BackResult;
import ynd.core.dto.DeleteDTO;
import ynd.common.pojo.vo.MenuInsertVo;
import ynd.common.pojo.vo.MenuUpdateVo;
import ynd.common.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Api(tags = {"菜单管理"})
@Validated
@RequestMapping("/menu")
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @AuthPermissions("system:menu:insert")
    @ApiOperation("新增")
    @PostMapping
    public BackResult insertMenu(@RequestBody @Valid MenuInsertVo menuInsertVo) throws Exception {
        return menuService.addMenu(menuInsertVo);
    }

    @AuthPermissions("system:menu:delete")
    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteMenu(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return menuService.deleteMenu(deleteDTO);
    }

    @AuthPermissions("system:menu:update")
    @ApiOperation("修改")
    @PutMapping
    public BackResult updateMenu(@RequestBody @Valid MenuUpdateVo menuUpdateVo) throws Exception {
        return menuService.updateMenu(menuUpdateVo);
    }

    // @AuthPermissions("system:menu:query")
    @ApiOperation("根据应用查询权限下的菜单")
    @GetMapping("/findMenuListByAppId/{appId}")
    public BackResult<List<MenuListVo>> findMenuListByAppId(@PathVariable @NotNull(message = "应用id不能为空") Long appId) throws Exception {
        return menuService.findMenuListByAppId(appId);
    }

     // @AuthPermissions("system:menu:query")
    @ApiOperation("根据角色查询菜单授权id")
    @GetMapping("/findMenuIdsByRoleIds/{roleId}")
    public BackResult<List<String>> findMenuIdsByRoleIds(@PathVariable @NotNull(message = "角色d不能为空") Long roleId) throws Exception {
        return menuService.findMenuIdsByRoleIds(roleId);
    }

}
