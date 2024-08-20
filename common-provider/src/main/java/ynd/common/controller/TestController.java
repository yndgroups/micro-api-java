package ynd.common.controller;

import ynd.common.pojo.vo.WeChatUserInsertVo;
import ynd.common.service.feign.FeignTeachingService;
import ynd.core.result.BackResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试接口")
@Validated
@RestController
@RequestMapping("/noAuth/test")
public class TestController {

    @Autowired
    private FeignTeachingService feignTeachingService;

    @ApiOperation("测试feign")
    @GetMapping("feign")
    public BackResult testFeign() throws Exception {
        WeChatUserInsertVo weChatUserInsertVo = new WeChatUserInsertVo();
        BackResult backResult = feignTeachingService.userInformationSynchronization(weChatUserInsertVo);
        if (backResult.getCode() == 200) {
            return BackResult.success(backResult.getData());
        } else {
            return BackResult.fail("微服务数据同步失败");
        }
    }

}
