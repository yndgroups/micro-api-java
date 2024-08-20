package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;


/**
 * description 启动类
 *
 * @param
 * @return
 * @author yangdaqiong
 * @date ${date}
 **/
@Configuration
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}