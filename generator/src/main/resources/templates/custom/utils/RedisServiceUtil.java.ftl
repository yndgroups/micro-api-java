package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * description redis缓存
 * @param
 * @return
 * @author: yangdaqiong
 * @date 2019-06-22 0:52
 */
@Service
public class RedisServiceUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * description 把数据写入缓存中
     * @param key
     * @param value
     * @return
     * @author: yangdaqiong
     * @date 2019-06-22 0:52
     */
    public void setString(String key ,String value){
            redisTemplate.opsForValue().set(key,value);
    }

    /**
     * description 把数据写入缓存中
     * @param key
     * @param value
     * @param outTime  缓存过期时间
     * @return
     * @author: yangdaqiong
     * @date 2019-06-22 0:52
     */
    public void setString(String key ,String value,Long outTime){
        redisTemplate.opsForValue().set(key,value,outTime,TimeUnit.SECONDS);
    }

    /**
     * description key 根据key值获取缓存数据
     * @param key
     * @return
     * @author: yangdaqiong
     * @date 2019-06-22 0:52
     */
    public String getString(String key){
         return redisTemplate.opsForValue().get(key);
    }

    /**
     * description 根据key值删除缓存数据
     * @param  key
     * @return
     * @author: yangdaqiong
     * @date 2019-06-22 0:54
     */
    public void delete(String key){
        redisTemplate.delete(key);
    }

    /**
     * description 获取缓存时间
     * @param
     * @return
     * @author: yangdaqiong
     * @date 2019-06-22 0:55
     */
    public Long getExpire(String key){
       Long timeLong =  redisTemplate.getExpire(key, TimeUnit.SECONDS);
       return timeLong;
    }

    /**
     * description 根据key值更新缓存时间 单位是 秒
     * @param key
     * @return void
     * @author: yangDaiong
     * @date 2019-06-22 0:55
     */
    public void updateTime(String key, Long outTime){
        /** 设置过期时间 */
        redisTemplate.expire(key, outTime , TimeUnit.SECONDS);
    }

}