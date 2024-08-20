package ynd.core.utils;

import ynd.core.exception.CustomException;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

/**
 * description 公共工具
 *
 * @author yangdaqiong
 * @return
 * @date 2019-10-25 22:47
 **/
public class CommonUtil {
    /**
     * description token字符串转数组
     *
     * @param authorization
     * @return String
     * @author yangdaqiong
     * @date 2019-07-05 19:25
     */
    public static String tokenFormat(String authorization) {
        return authorization.split(" ")[1];
    }

    /**
     * description 获取IP地址
     *
     * @return String
     * @author yangdaqiong
     * @date 2019-07-05 19:25
     */
    public static String getIpAddress() {
        HttpServletRequest request = HttpContextUtil.getRequest();
        String unknown = "unknown";
        String localIp = "127.0.0.1";
        String localIpCommon = "0:0:0:0:0:0:0:1";
        int len = 15;
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || unknown.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || unknown.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || unknown.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (localIp.equals(ipAddress) || localIpCommon.equals(ipAddress)) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    // e.printStackTrace();
                    throw new CustomException(0, e.getMessage());
                }
                ipAddress = inet.getHostAddress();
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > len) {
            // "***.***.***.***".length() = 15
            String[] ips = ipAddress.split(",");
            if (ips != null && ips.length > 0) {
                ipAddress = ips[0];
            }
        }
        return ipAddress;
    }

    /**
     * description 32 UUID + time stamp
     *
     * @return String
     * @author yangdaqiong
     * @date 2019-11-17 21:55
     **/
    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "") + System.currentTimeMillis();
        //.toUpperCase();
    }

    /**
     * description Area code processing
     *
     * @param areaCode
     * @param areaTag
     * @return String
     * @author yangdaqiong
     * @date 2020-3-20 09:12
     **/
    public static String substringAreaCode(String areaCode, int areaTag) {
        switch (areaTag) {
            case 1:
                areaCode = areaCode.substring(0, 2);
                break;
            case 2:
                areaCode = areaCode.substring(0, 4);
                break;
            case 3:
                areaCode = areaCode.substring(0, 6);
                break;
            case 4:
                areaCode = areaCode.substring(0, 9);
                break;
            case 5:
                areaCode = areaCode.substring(0, areaCode.length());
                break;
            default:
                areaCode = "";
        }
        return areaCode;
    }

}
