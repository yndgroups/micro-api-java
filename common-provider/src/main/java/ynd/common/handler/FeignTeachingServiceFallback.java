package ynd.common.handler;

import ynd.common.pojo.vo.WeChatUserInsertVo;
import ynd.common.service.feign.FeignTeachingService;
import ynd.core.exception.CustomException;
import ynd.core.result.BackResult;
import org.springframework.stereotype.Component;

@Component
public class FeignTeachingServiceFallback implements FeignTeachingService {

    @Override
    public BackResult userInformationSynchronization(WeChatUserInsertVo weChatUserInsertVo) {
        throw new CustomException(0, "fail");
    }

}
