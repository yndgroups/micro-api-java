package ynd.common.configuration;

import ynd.core.utils.HttpContextUtil;
import feign.*;
import feign.querymap.BeanQueryMapEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * description feign统一配置
 *
 * @author Yang Daqiong
 * @date 2021-12-19 13:49:26
 **/
@Configuration
public class FeignConfiguration implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header(Constant.reqHeader, "Bearer " + HttpContextUtil.getToken());
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        //设置日志等级
        return Logger.Level.FULL;
    }

    /**
     * 替换解析queryMap的类，实现父类中变量的映射
     * @return Feign.Builder
     */
    @Bean
    @Primary
    public Feign.Builder feignBuilder() {
        return Feign.builder().queryMapEncoder(new BeanQueryMapEncoder()).retryer(Retryer.NEVER_RETRY);
    }
}
