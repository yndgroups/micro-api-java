package ynd.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * description 订单服务
 *
 * @author Yang Daqiong
 * @date 2021-04-21 17:08:26
 **/
@EntityScan("ynd.core")
@ComponentScan({"ynd.core", "ynd.cms"})
@MapperScan({"ynd.cms.modular.*.mapper"})
@EnableDiscoveryClient
@SpringBootApplication
public class CmsApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class);
    }

    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder.sources(CmsApplication.class);
    }

}
