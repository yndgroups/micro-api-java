package ynd.gateway.filter;

import ynd.core.exception.CustomException;
import ynd.gateway.configuration.GatewayConstant;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;

/**
 * description 网关控制
 *
 *@author yangdaqiong
 *@date 2021-04-30 09:43:21
 **/
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String url = request.getURI().getPath();
        exchange.getRequest().mutate().header("source-id", GatewayConstant.jwtPublicSecret).build();
        String noAuthPath = GatewayConstant.noAuthPath;
        if (StringUtils.isNotEmpty(noAuthPath)) {
            String[] split = noAuthPath.split(",");
            if (split.length > 0) {
                for (String s: split ) {
                    System.out.printf("s=" + s);
                    if (url.indexOf(s) >= 0) {
                        return chain.filter(exchange);
                    }
                }
            }
        }

        String token = request.getHeaders().getFirst(GatewayConstant.reqHeader);
        if (token != null && StringUtils.isNotBlank(token)) {
            try {
                if (token.length() < 50) {
                    return getVoidMono(response,0, "gateway -> 无效token");
                }
                // 验证token的合法性，不再进行redis验证
                Boolean isLogin = true; // redisUserService.isLogin(token);
                if (!isLogin) {
                    return getVoidMono(response);
                } else {
                    return chain.filter(exchange);
                }
            } catch (CustomException e) {
                return getVoidMono(response,e.getCode(), e.getMessage());
            } catch (Exception e) {
                if (e.getMessage().indexOf("Unable to read JSON") != -1) {
                    return getVoidMono(response,401 , "gateway -> 无效Token");
                } else {
                    return getVoidMono(response,401 , "gateway -> token引起的未知错误");
                }
            }
        } else {
            return getVoidMono(response);
        }
    }

    public Mono<Void> getVoidMono(ServerHttpResponse serverHttpResponse) {
        serverHttpResponse.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 401);
        map.put("msg", "您没有权限或登录的授权信息已过期");
        map.put("data", "您没有权限或登录的授权信息已过期");
        DataBuffer wrap = serverHttpResponse.bufferFactory().wrap(JSONObject.toJSONBytes(map));
        return serverHttpResponse.writeWith(Flux.just(wrap));
    }

    public Mono<Void> getVoidMono(ServerHttpResponse serverHttpResponse, Integer code, String msg) {
        serverHttpResponse.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        HashMap<String, Object> map = new HashMap<>();
        if (code == 0 || code == 401) {
            map.put("code", 401);
            map.put("msg", "无访问权限");
            map.put("data", msg);
        } else {
            map.put("code", 400);
            map.put("msg", "系统参数错误");
            map.put("data", "系统参数错误！请联系管理员！");
        }

        DataBuffer wrap = serverHttpResponse.bufferFactory().wrap(JSON.toJSONString(map).getBytes());
        return serverHttpResponse.writeWith(Flux.just(wrap));
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
