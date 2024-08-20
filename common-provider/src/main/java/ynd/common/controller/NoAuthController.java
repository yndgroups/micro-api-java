package ynd.common.controller;

import ynd.common.pojo.vo.JsSdkVo;
import ynd.common.pojo.vo.LoginBackVo;
import ynd.common.pojo.vo.WeChatUserInsertVo;
import ynd.common.pojo.vo.WeChatWebLoginVo;
import ynd.common.service.NoAuthService;
import ynd.core.result.BackResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "无效验的接口")
@Validated
@RestController
@RequestMapping("/noAuth")
public class NoAuthController {

    @Autowired
    private NoAuthService noAuthService;

    @ApiOperation("管理员登录")
    @PostMapping("/login")
    public BackResult login(@RequestBody @Valid LoginBackVo loginBackVo) {
        return noAuthService.login(loginBackVo);
    }

    @ApiOperation("微信小程序登录")
    @PostMapping("/wechatLogin")
    public BackResult wechatLogin(@RequestBody @Valid WeChatUserInsertVo weChatUserInsertVo) throws Exception {
        return noAuthService.wechatLogin(weChatUserInsertVo);
    }

    @ApiOperation("微信公众号登录")
    @PostMapping("/wechatWebLogin")
    public BackResult wechatWebLogin(@RequestBody @Valid WeChatWebLoginVo weChatWebLoginVo) throws Exception {
        return noAuthService.wechatWebLogin(weChatWebLoginVo);
    }

    @ApiOperation(value = "获取微信js-sdk授权")
    @PostMapping("/getWeChatJSSDK")
    public BackResult getWeChatJsSdk(@RequestBody @Valid JsSdkVo jsSdkVo) {
        return noAuthService.getWeChatJsSdk(jsSdkVo);
    }

    @ApiOperation("获取主键key")
    @PostMapping("/createPrimaryKey/{key}")
    public BackResult createPrimaryKey(@PathVariable String key) {
        return BackResult.success(noAuthService.createPrimaryKey(key));
    }

}
