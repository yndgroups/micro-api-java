package ynd.common.controller;

import ynd.common.pojo.param.UserParam;
import ynd.common.pojo.vo.UserInsertVo;
import ynd.common.pojo.vo.UserListVo;
import ynd.common.pojo.vo.UserRelationRoleVo;
import ynd.common.pojo.vo.UserUpdateVo;
import ynd.common.service.UserService;
import ynd.core.annotation.AuthPermissions;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.core.dto.DeleteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Api(tags = {"用户管理"})
@Validated
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @AuthPermissions("system:user:insert")
    @ApiOperation("新增")
    @PostMapping
    public BackResult insertUser(@RequestBody @Valid UserInsertVo userInsertVo) throws Exception {
        return userService.addUser(userInsertVo);
    }

    @AuthPermissions("system:user:delete")
    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteUser(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return userService.deleteUser(deleteDTO);
    }

    @AuthPermissions("system:user:update")
    @ApiOperation("修改")
    @PutMapping
    public BackResult updateUser(@RequestBody @Valid UserUpdateVo adminUpdateVo) throws Exception {
        return userService.updateUser(adminUpdateVo);
    }

    @AuthPermissions("system:user:query")
    @ApiOperation("列表查询")
    @PostMapping("/findUserPageList")
    public BackResult<List<UserListVo>> findUserPageList(@RequestBody @Valid QueryParameter<UserParam> queryParameter) throws Exception {
        return userService.findUserPageList(queryParameter);
    }

    @AuthPermissions("system:user:query")
    @ApiOperation("查询用户授权角色id[回调]")
    @GetMapping("/queryRoleIds/{appId}/{userId}")
    public BackResult<List<String>> queryRoleIds(@PathVariable String appId, @PathVariable String userId) throws Exception {
        return userService.queryRoleIds(appId, userId);
    }

    @ApiOperation("查询微信公众号用户信息")
    @GetMapping("/queryWeChatWebUserInfo/{confId}")
    public BackResult queryWeChatWebUserInfo(@PathVariable String confId) throws Exception {
        return userService.queryWeChatWebUserInfo(confId);
    }

    @ApiOperation("用户关联角色")
    @PostMapping("/userRelation")
    public BackResult userRelation(@RequestBody @Valid UserRelationRoleVo userRelationRoleVo) throws Exception {
        return userService.userRelation(userRelationRoleVo);
    }

}
