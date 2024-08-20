package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

/**
 * description 公共工具
 *@return
 *@param
 *@author yangdaqiong
 *@date 2019/10/25 22:47
 **/
public class CommonUtil {

    /** 未知的 */
    private final static String UNKNOWN = "unknown";

    /** 空格 */
    private final static String SPACE = " ";

    /** 逗号 */
    private final static String COMMA = ",";

    /**
     * description token字符串转数组
     * @param authorization
     * @return String
     * @auther: yangdaqiong
     * @date 2019-07-05 19:25
     */
    public static String tokenFormat(String authorization){
        return authorization.split(SPACE)[1];
    }

    /**
     * description 获取IP地址
     *
     * @return String ip
     * @auther: yangdaqiong
     * @date 2019-07-05 19:25
     */
    public static String getIpAddr(){
        HttpServletRequest request = HttpContextUtil.getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (ip != null && ip.length() != 0 && !UNKNOWN.equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if (ip.indexOf(COMMA) != -1) {
                ip = ip.split(COMMA)[0];
            }
        }

        /** 这个一般是经过apache http服务器的请求才会有，用apache http做代理时一般会加上Proxy-Client-IP请求头，而WL- Proxy-Client-IP是他的weblogic插件加上的头 */
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            System.out.println("Proxy-Client-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            System.out.println("WL-Proxy-Client-IP ip: " + ip);
        }

        /** 有些代理服务器会加上此相应头 */
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            System.out.println("HTTP_CLIENT_IP ip: " + ip);
        }

        /** 这是一个 Squid 开发的字段，只有在通过了 HTTP 代理或者负载均衡服务器时才会添加该项。
         * 格式为X-Forwarded-For: client1, proxy1, proxy2，一般情况下，
         * 第一个ip为客户端真实ip，后
         * 面的为经过的代理服务器ip。现在大部分的代理都会加上这个请求头
         */
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            System.out.println("HTTP_X_FORWARDED_FOR ip: " + ip);
        }

        /** nginx代理一般会加上此请求头 X-Real-IP */
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
            System.out.println("X-Real-IP ip: " + ip);
        }

        /**  */
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            System.out.println("getRemoteAddr ip: " + ip);
        }
        return ip;
    }

    /**
     * description 32 UUID + time stamp
     *
     *@return String
     *@author yangdaqiong
     *@date 2019/11/17 21:55
     **/
    public static String getUuid() {
        /** 全大写 .toUpperCase() */
        return UUID.randomUUID().toString().replace("-", "") + System.currentTimeMillis();
    }

    /**
     * description Area code processing
     *
     *@param areaCode
     *@param areaTag
     *@return String
     *@author yangdaqiong
     *@date 2020/3/20 9:12
     **/
    public static String substringAreaCode(String areaCode, int areaTag) {
        switch (areaTag) {
            case 1:
                areaCode = "000000000000";
                break;
            case 2:
                areaCode = areaCode.substring(0, 2);
                break;
            case 3:
                areaCode = areaCode.substring(0, 4);
                break;
            case 4:
                areaCode = areaCode.substring(0, 6);
                break;
            default:
                areaCode = areaCode.substring(0, 6);
        }
        return areaCode;
    }

}
