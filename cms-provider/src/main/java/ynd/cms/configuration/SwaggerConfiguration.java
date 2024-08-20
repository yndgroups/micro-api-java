package ynd.cms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private ArrayList<Parameter> parameterList = new ArrayList<Parameter>();

    public SwaggerConfiguration() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder.name(Constant.reqHeader).description("登录校验")
                // name表示名称，description表示描述
                .modelRef(new ModelRef("string")).parameterType("header")
                // required表示是否必填，defaultvalue表示默认值
                .required(true).defaultValue("Bearer token");
        parameterList.add(parameterBuilder.build());
    }

    @Bean
    public Docket createBackendApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("cms-backend")
                .enable(Constant.swaggerEnable)
                .apiInfo(new ApiInfoBuilder()
                        .title("内容管理 - 后台API")
                        .description("内容管理 - 后台API")
                        .version("2.9.2")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("ynd.cms.modular.backend.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameterList);
    }

    @Bean
    public Docket createFrontendApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("cms-frontend")
                .enable(Constant.swaggerEnable)
                .apiInfo(new ApiInfoBuilder()
                        .title("内容管理 - 前端API")
                        .description("内容管理 - 前端API")
                        .version("2.9.2")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("ynd.cms.modular.frontend.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameterList);
    }

}
