package ynd.file.configuration;

import ynd.core.constant.BaseConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Constant extends BaseConstant {
    /** 应用基本配置 **/
    public static String version;
    public static String appId;
    public static int deleteType;
    public static String uploadPath;

    @Value("${application.version}")
    public void setVersion(String version) {
        Constant.version = version;
    }

    @Value("${application.appId}")
    public void setAppId(String appId){
        Constant.appId = appId;
    }

    /**  1是逻辑删除 2物理删除 */
    @Value("${application.deleteType}")
    public void setDeleteType(int deleteType){
        Constant.deleteType = deleteType;
    }

    @Value("${application.uploadPath}")
    public void setUploadPath(String uploadPath) {Constant.uploadPath = uploadPath; }

    /** jwt相关配置 **/
    public static String jwtPublicSecret;
    public static String jwtPrivateSecret;

    @Value("${{application.jwt.jwtPublicSecret}")
    public void setJwtPublicSecret(String jwtPublicSecret) { Constant.jwtPublicSecret = jwtPublicSecret; }

    @Value("${{application.jwt.jwtPrivateSecret}")
    public void setJwtPrivateSecret(String jwtPrivateSecret) { Constant.jwtPrivateSecret = jwtPrivateSecret; }

    /** Redis相关配置 **/
    public static Long redisStoreTime;
    @Value("${application.redis.redisStoreTime}")
    public void setRedisStoreTime(Long redisStoreTime) {
        Constant.redisStoreTime = redisStoreTime;
    }

    /** 阿里云相关配置 */
    public static String accessKeyId;
    public static String keySecret;
    public static String endpointName;
    public static String bucketName;
    public static Long ossSignStoreTime;

    @Value("${ali.oss.accessKeyId}")
    public void setAccessKeyId(String accessKeyId) {
        Constant.accessKeyId = accessKeyId;
    }

    @Value("${ali.oss.keySecret}")
    public void setKeySecret(String keySecret) {
        Constant.keySecret = keySecret;
    }

    @Value("${ali.oss.endpoint}")
    public void setEndpointConfig(String endpointName) {
        Constant.endpointName = endpointName;
    }

    @Value("${ali.oss.bucket}")
    public void setBucketConfig(String bucketName) {
        Constant.bucketName = bucketName;
    }

    @Value("${ali.oss.expiryTime}")
    public void setOssSignStoreTime(Long ossSignStoreTime) {
        Constant.ossSignStoreTime = ossSignStoreTime;
    }

}
