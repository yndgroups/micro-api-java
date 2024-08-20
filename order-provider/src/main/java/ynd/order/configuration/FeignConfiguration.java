package ynd.order.configuration;

import ynd.core.utils.HttpContextUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
       template.header("accessToken", HttpContextUtil.getToken());
    }
}
