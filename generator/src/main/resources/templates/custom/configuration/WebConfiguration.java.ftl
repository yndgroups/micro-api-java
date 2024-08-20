package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *@description 拦截器
 *@return
 *@params
 *@author yangdaqiong
 *@date 2019-07-30 19:55
 **/
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private AuthFilter authFilter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * description /** 表示 拦截 url包括子url路径
         *@return
         *@param
         *@author yangdaqiong
         *@date 2019/10/31 23:35
         **/
        registry
                .addInterceptor(authFilter)
                .addPathPatterns("/**")
                .excludePathPatterns("/doc.html","/error","/v2/api-docs","/webjars/**","/swagger-resources/**")
                .excludePathPatterns("/content/public/query");
    }
}
