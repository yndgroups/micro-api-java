package ynd.cms.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "api.path")
@Data
public class ApiPathProperties {

    String mobilePrefix = "mobile";

    String frontPrefix = "front";

    String adminPrefix = "admin";

}
