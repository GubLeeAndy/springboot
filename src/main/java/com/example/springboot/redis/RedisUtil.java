package com.example.springboot.redis;

import com.example.springboot.utils.CacheConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
@SuppressWarnings({"unchecked","rawtypes","unused"})
public class RedisUtil {

    private static Logger log= LoggerFactory.getLogger(RedisUtil.class);

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 批量删除对应的value
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    public <T> Object get(final String key,final Class<?> clas) {
        Object result = null;
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<String, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存
     * @param key
     * @param value
     * @param expireTime （单位:秒）
     * @return
     */
    public boolean set(final String key, Object value, int expireTime) {
        boolean result = false;
        try {
            ValueOperations<String, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @Title: clearPermis
     * @Description: TODO(清除用户权限)
     * @param userId
     * @param systemId
     * @author gangyu2
     * @date 2018年12月21日下午2:45:09
     */
    public void clearPermis(String userId,String systemId){
        String key=String.format(CacheConstants.KEY_ROLE_BY_USERID_AND_APPID,userId,systemId);
        remove(key);
        key=String.format(CacheConstants.KEY_USER_PERMIS_BY_USERID_APPID, userId,systemId);
        remove(key);
    }

    /**
     * @Title: clearUserInfo
     * @Description: TODO(清除用户信息)
     * @param userName
     * @author gangyu2
     * @date 2018年12月21日下午2:47:01
     */
    public void clearUserInfo(String userName){
        String key=String.format(CacheConstants.KEY_USER_INFO_BY_USERNAME,userName);
        remove(key);
    }

    /**
     * @Author WuRui
     * @Description // 写入缓存
     * @Date 18:18 2019/7/9
     * @Param [key, value, expireTime]
     * @return boolean
     **/
    public boolean set(final String key, Object value, long expireTime) {
        boolean result = false;
        try {
            ValueOperations<String, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @Title: setDataBase
     * @Description: TODO(切换数据库)
     * @param dbIndex 数据库索引
     * @author gangyu2
     * @date 2019年8月29日下午6:03:32
     */
    public void setDataBase(int dbIndex) {
        LettuceConnectionFactory connectionFactory = (LettuceConnectionFactory) redisTemplate.getConnectionFactory();
        if (connectionFactory != null && dbIndex != connectionFactory.getDatabase()) {
            connectionFactory.setDatabase(dbIndex);
            redisTemplate.setConnectionFactory(connectionFactory);
            connectionFactory.resetConnection();
        }
    }
}
