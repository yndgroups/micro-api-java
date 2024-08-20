package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * description API文档配置
 *@return
 *@param
 *@author yangdaqiong
 *@date 2019/10/29 21:09
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private boolean enableSwagger = true;

    @Bean
    public Docket createBackendApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("${cfg.swaggerApiTitle} - API")
                .enable(enableSwagger)
                .apiInfo(new ApiInfoBuilder()
                        .title("${cfg.swaggerApiTitle} - API")
                        .description("${cfg.swaggerApiTitle} - API")
                        .version("1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("${package.Controller}"))
                .paths(PathSelectors.any())
                .build();
    }
}