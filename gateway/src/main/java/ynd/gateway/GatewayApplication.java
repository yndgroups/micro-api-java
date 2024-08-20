package ynd.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description 网关服务
 *
 * @author Yang Daqiong
 * @date 2021-04-21 17:08:26
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication  extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class);
    }

    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder.sources(GatewayApplication.class);
    }
}
