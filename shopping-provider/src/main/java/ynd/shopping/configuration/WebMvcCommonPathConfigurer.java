package ynd.shopping.configuration;

import ynd.shopping.annotation.FrontendController;
import ynd.shopping.annotation.AdminController;
import ynd.shopping.annotation.MobileController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcCommonPathConfigurer implements WebMvcConfigurer {

    @Autowired
    private ApiPathProperties apiPathProperties;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

        // 移动端
        configurer.addPathPrefix(apiPathProperties.getMobilePrefix(), c -> c.isAnnotationPresent(MobileController.class));
        // 前端
        configurer.addPathPrefix(apiPathProperties.getFrontPrefix(), c -> c.isAnnotationPresent(FrontendController.class));
        // 后端
        configurer.addPathPrefix(apiPathProperties.getAdminPrefix(), c -> c.isAnnotationPresent(AdminController.class));

    }
}
