package ynd.core.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * description 拦截器
 *
 * @author yangdaqiong
 * @date 2019-07-30 19:55
 **/
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private AuthFilter authFilter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] config = {
                "/v2/**",
                "/error",
                "/**/v2/**",
                "/**/error",
                "/doc.html",
                "/swagger-ui.html",
                "/webjars/**",
                "/noAuth/**",
                "/**/noAuth/**",
                "/**/**/noAuth/**",
                "/**/doc.html",
                "/**/swagger-ui.html",
                "/**/webjars/**",
                "/swagger-resources/**",
                "/**/swagger-resources/**",
                "/**/**/swagger-resources/**",
                "/**/**/swagger-resources/**/**",
        };

        /**
         * description 表示 拦截 url包括子url路径
         *
         * @param authFilter
         * @return registry
         * @author yangdaqiong
         * @date 2019-10-31 23:35
         */
        registry.addInterceptor(authFilter).addPathPatterns("/**").excludePathPatterns(config);
    }

    /**
     * description  CORS跨域配置
     *
     * @return CorsFilter
     * @author yangdaqiong
     * @date 2020/06/26 20:59:00
     **/
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 允许跨域的接口
        source.registerCorsConfiguration("/v2/api-docs", buildConfig());
        return new CorsFilter(source);
    }

    /**
     * description  CORS跨域配置
     *
     * @author yangdaqiong
     * @date 2020/06/26 20:58:33
     **/
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //允许的域名或IP地址
        corsConfiguration.addAllowedOrigin("*");
        //允许的请求头
        corsConfiguration.addAllowedHeader("*");
        //允许的HTTP请求方法
        corsConfiguration.addAllowedMethod("*");
        //允许发送跨域凭据，前端Axios存取JSESSIONID必须要
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }
}
