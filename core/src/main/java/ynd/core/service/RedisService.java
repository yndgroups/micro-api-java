package ynd.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * description redis缓存
 *
 * @author Yang Daqiong
 * @date 2019-06-22 0:52
 */
@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * description 把数据写入缓存中
     *
     * @param key
     * @param value
     * @return void
     * @author yangdaqiong
     * @date 2019-06-22 0:52
     */
    public void setString(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * description 把数据写入缓存中
     *
     * @param key
     * @param value
     * @param outTime 缓存过期时间
     * @return void
     * @author yangdaqiong
     * @date 2019-06-22 0:52
     */
    public void setString(String key, String value, Long outTime) {
        redisTemplate.opsForValue().set(key, value, outTime, TimeUnit.SECONDS);
    }

    /**
     * description key 根据key值获取缓存数据
     *
     * @param key
     * @return
     * @author yangdaqiong
     * @date 2019-06-22 0:52
     */
    public String getString(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * description 根据key值删除缓存数据
     *
     * @param key
     * @return void
     * @author yangdaqiong
     * @date 2019-06-22 0:54
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * description 获取缓存时间
     *
     * @param key
     * @return void
     * @author yangdaqiong
     * @date 2019-06-22 0:55
     */
    public <T> Long getExpire(String key) {
        Long timeLong = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        return timeLong;
    }

    /**
     * description 根据key值更新缓存时间 单位是 秒
     *
     * @param key
     * @return void
     * @author yangDaiong
     * @date 2019-06-22 0:55
     */
    public void updateTime(String key, Long outTime) {
        redisTemplate.expire(key, outTime, TimeUnit.SECONDS);
    }

    /**
     * description 缓存map以秒为单位 并设置过期时间
     *
     * @param key
     * @param map
     * @return void
     * @author yangdaqiong
     * @date 2019/11/21 11:50
     **/
    public void setMap(String key, Map<String, String> map, Long storeTime) {
        redisTemplate.opsForHash().putAll(key, map);
        redisTemplate.expire(key, storeTime, TimeUnit.SECONDS);
    }

    /**
     * description 根据存储的key值取出对应的Map数据
     *
     * @param key
     * @return Map
     * @author yangdaqiong
     * @date 2019/11/21 13:29
     **/
    public Map<Object, Object> getMap(String key) {
        Map<Object, Object> map = redisTemplate.opsForHash().entries(key);
        return map;
    }

    /**
     * description 创建唯一一主键id
     *
     * @return Long 主键id PRIMARY_KEY_ID
     * @author yangdaqiong
     * @date 2021-09-25 11:30:09
     **/
    public Long createKey(String primaryKey) {
        Long result = redisTemplate.opsForValue().increment(primaryKey);
        String orderId = renderOrderId(result);
        return Long.valueOf(orderId);
    }

    public <T> String currentDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String now = dateTimeFormatter.format(localDateTime);
        return now;
    }

    /**
     * 根据自增id生成唯一订单号
     *
     * @param incrKey 自增id
     * @return
     */
    public String renderOrderId(Long incrKey) {
        String orderId = currentDateTime() + String.format("%1$05d", incrKey);
        return orderId;
    }

    /**
     * description
     *
     * @return Long 主键id
     * @author yangdaqiong
     * @date 2021-09-25 11:30:09
     **/
    public void setHashOps(String key, String field, Object data) {
        redisTemplate.boundHashOps(key).put(field, data);
    }

    /**
     * description
     *
     * @return Long 主键id
     * @author yangdaqiong
     * @date 2021-09-25 11:30:09
     **/
    public List<Object> getHashOps(String key) {
        List<Object> values = redisTemplate.boundHashOps(key).values();
        return values;
    }

    /**
     * description 删除redisHash值
     *
     * @return key 存储key
     * @return target 删除的键值对
     * @author yangdaqiong
     * @date 2021-11-06 09:09:09
     **/
    public void deleteHashOps(String key, String target) {
        redisTemplate.boundHashOps(key).delete(target);
    }

}
