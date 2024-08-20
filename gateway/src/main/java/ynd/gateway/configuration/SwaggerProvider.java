package ynd.gateway.configuration;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * description 配置SwaggerProvider，获取Api-doc，即SwaggerResources。
 *
 * @param
 * @author yangdaqiong
 * @return
 * @date 2019/11/15 0:39
 **/
@Component
@Primary
public class SwaggerProvider implements SwaggerResourcesProvider {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    private final RouteLocator routeLocator;
    private final GatewayProperties gatewayProperties;

    public SwaggerProvider(RouteLocator routeLocator, GatewayProperties gatewayProperties) {
        this.routeLocator = routeLocator;
        this.gatewayProperties = gatewayProperties;
    }

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<String> routes = new ArrayList<>();
        //取出gateway的route
        routeLocator.getRoutes().subscribe(route -> routes.add(route.getId()));
        //结合配置的route-路径(Path)，和route过滤，只获取有效的route节点
        gatewayProperties.getRoutes().stream()
                .filter(routeDefinition -> routes.contains(routeDefinition.getId()))
                .forEach(routeDefinition -> routeDefinition.getPredicates().stream()
                        .filter(predicateDefinition -> ("Path").equalsIgnoreCase(predicateDefinition.getName()))
                        .forEach(predicateDefinition -> {
                                    // 获取微服务注册的实例
                                    ServiceInstance serviceInstance = loadBalancerClient.choose(routeDefinition.getId());
                                    if (serviceInstance != null) {
                                        if (routeDefinition.getMetadata() != null && routeDefinition.getMetadata().get("api") != null) {
                                            List<AppConfig> appConfigLists = createAppConfigs(routeDefinition.getMetadata().get("api").toString());
                                            for (AppConfig appConfig : appConfigLists) {
                                                //String url = String.format("/%s/v2/api-docs?group=%s", appConfig.getBasePath(), appConfig.getGroupName());
                                                String url = String.format("/%s/swagger/doc.json", appConfig.getBasePath());
                                                resources.add(swaggerResource(url, appConfig.getApiName()));
                                            }
                                        } else {
                                            String url = String.format("/%s/swagger/doc.json", serviceInstance.getServiceId());
                                            resources.add(swaggerResource(url, serviceInstance.getServiceId()));
                                        }
                                    }
                                }
                        )
                );
        return resources;
    }

    /**
     * description
     *
     * @param apiText
     * @return List<AppConfig>
     * @author yangdaqiong
     * @date 2021-04-29 23:49:55
     **/
    private List<AppConfig> createAppConfigs(String apiText) {
        List<AppConfig> apiConfigList = new ArrayList<>();
        JSONArray apis = JSONArray.parseArray(apiText);
        for (Object api : apis) {
            AppConfig appConfig = JSON.toJavaObject(JSON.parseObject(api.toString()), AppConfig.class);
            apiConfigList.add(appConfig);
        }
        return apiConfigList;
    }

    /**
     * description 资源设置
     *
     * @param location 资源路径
     * @param name     资源名称
     * @return SwaggerResource
     * @author yangdaqiong
     * @date 2021-04-29 23:54:49
     **/
    private SwaggerResource swaggerResource(String location, String name) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}
