package ynd.gateway.configuration;

import lombok.Data;

/**
 * description 应用配置实体
 *
 *@author yangdaqiong
 *@date 2021-04-29 23:01:49
 **/
@Data
public class AppConfig {

    private String apiName;

    private String groupName;

    private String basePath;

}
