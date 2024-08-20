package ynd.common.handler;

import ynd.core.result.BackResult;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description 流量异常处理
 *
 * @param
 * @return BackResult<T>
 * @author Yang Daqiong
 * @date 2021-12-21 13:15:04
 **/
@Component
public class ProviderServiceFallback implements BlockExceptionHandler {

    public ProviderServiceFallback() {
    }

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        BackResult backResult = BackResult.fail(e.getMessage());
        httpServletResponse.setStatus(HttpStatus.OK.value());
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setHeader("Content-Type","application/json;charset=utf-8");
        new ObjectMapper().writeValue(httpServletResponse.getWriter(),backResult);
    }
}
