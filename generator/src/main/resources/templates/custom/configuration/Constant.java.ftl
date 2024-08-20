package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

/**
 * description 基础变量
 *@return
 *@param
 *@author yangdaqiong
 *@date 2019-08-30 15:27
 **/
@Configuration
public class Constant {

    /** 应用基本配置 **/
    public static String version;
    public static String appId;
    public static int deleteType;
    @Value("${r"${application.version}"}")
    public void setVersion(String version) {Constant.version = version;}
    @Value("${r"${application.appId}"}")
    public void setAppId(String serverId){Constant.appId = appId;}
    /** 1是逻辑删除 2物理删除 */
    @Value("${r"${application.deleteType:1}"}")
    public void setDeleteType(int deleteType){Constant.deleteType = deleteType;}

    /** jwt相关配置 **/
    public static String jwtPublicSecret;
    public static String jwtPrivateSecret;
    public static SecretKey secretKey;
    @Value("${r"${jwt.jwtPublicSecret}"}")
    public void setJwtPublicSecret(String jwtPublicSecret) { Constant.jwtPublicSecret = jwtPublicSecret; }
    @Value("${r"${jwt.jwtPrivateSecret}"}")
    public void setJwtPrivateSecret(String jwtPrivateSecret) { Constant.jwtPrivateSecret = jwtPrivateSecret; }

    /** apijson相关配置 **/
    public static String dataBase;
    public static String account;
    public static String password;
    public static Boolean debug;
    public static String host;
    @Value("${r"${apijson.dataBase.host}"}")
    public void setHost(String host){ Constant.host = host; }
    @Value("${r"${apijson.dataBase.name}"}")
    public void setDataBase(String dataBase){ Constant.dataBase = dataBase; }
    @Value("${r"${apijson.dataBase.account}"}")
    public void setAccount(String account){ Constant.account = account; }
    @Value("${r"${apijson.dataBase.password}"}")
    public void setPassword(String password){ Constant.password = password; }
    @Value("${r"${apijson.debug}"}")
    public void setDebug (boolean debug) { Constant.debug = debug; }

    /** Redis相关配置 **/
    public static Long redisStoreTime;
    @Value("${r"${redis.redisStoreTime}"}")
    public void setRedisStoreTime(Long redisStoreTime) { Constant.redisStoreTime = redisStoreTime;}
}
