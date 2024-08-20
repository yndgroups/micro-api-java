package ynd.common.service.feign;

import ynd.common.configuration.FeignConfiguration;
import ynd.common.handler.FeignTeachingServiceFallback;
import ynd.common.pojo.vo.WeChatUserInsertVo;
import ynd.core.result.BackResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * description 服务之间调用
 *
 * @author Yang Daqiong
 * @return BackVo<T>
 * @date 2021-02-08 16:26:50
 */

@FeignClient(
        value = "agile-teaching",
        configuration = FeignConfiguration.class,
        fallbackFactory = FeignTeachingServiceFallback.class
)
public interface FeignTeachingService {
    /**
     * description 同步微信登录信息至教学服务
     *
     * @param weChatUserInsertVo
     * @return BackResult<T>
     * @author Yang Daqiong
     * @date 2021-03-14 01:38:57
     **/
    // @SentinelResource(value = "fallback", blockHandler = "failBlockHandler", fallback = "failFallback")
    @PostMapping("/api/teaching/mobile/user/userInformationSynchronization")
    BackResult userInformationSynchronization(@RequestBody @Valid WeChatUserInsertVo weChatUserInsertVo) throws Exception;

}
