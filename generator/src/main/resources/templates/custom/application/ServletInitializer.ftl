package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * description 解决打war包起不来的问题
 *
 * @param
 * @return
 * @author yangdaqiong
 * @date 2020/05/07 14:25
 **/
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

}
