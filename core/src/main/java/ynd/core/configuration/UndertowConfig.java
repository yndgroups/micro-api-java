package ynd.core.configuration;

import io.undertow.UndertowOptions;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * description  也就是说必须要开启这个配置，才能在访问日志里打印响应时间，
 * 至于undertow为什么不默认开启这个配置，是因为开启后会对性能造成影响
 * 在spring boot(2.0)要开启这个配置需要通过代码进行配置
 *
 * @author Yang Daqiong
 * @date 2020-06-28 09:44:43
 */
@Configuration
public class UndertowConfig {

    public UndertowServletWebServerFactory undertowServletWebServerFactory() {
        UndertowServletWebServerFactory undertowServletWebServerFactory = new UndertowServletWebServerFactory();
        undertowServletWebServerFactory.addBuilderCustomizers(builder -> builder.setServerOption(UndertowOptions.RECORD_REQUEST_START_TIME, true));
        return undertowServletWebServerFactory;
    }

}
