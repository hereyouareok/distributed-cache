package com.yan.qing.cache.cache;

import com.yan.qing.cache.util.ApplicationUtil;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.DigestUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author YanQin
 * @version v1.0.0
 * @Description : 自定义实现cache
 * @Create on : 2020/10/9 18:39
 **/

public class RedisCache implements Cache {

    private final String id;

    public RedisCache(String id) {
        System.out.println("id.................." + id);
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    //放值
    @Override
    public void putObject(Object key, Object value) {
        //hash 存储模型
        System.out.println("key...."+key);
        System.out.println("value...."+value);

        //getRedisTemplate().expire(key.toString(),"1", TimeUnit.HOURS);
        getRedisTemplate().opsForHash().put(id.toString(), getMd5(key.toString()), value);
    }

    //取值
    @Override
    public Object getObject(Object key) {
        System.out.println("key...."+key);
        return getRedisTemplate().opsForHash().get(id.toString(), getMd5(key.toString()));
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {
        System.out.println("清空缓存.......");
        getRedisTemplate().delete(id.toString());
    }

    //计算缓存击中率
    @Override
    public int getSize() {
        return getRedisTemplate().opsForHash().size(id.toString()).intValue();
    }

    private RedisTemplate getRedisTemplate() {
        RedisTemplate template = (RedisTemplate) ApplicationUtil.getBean("redisTemplate");

        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        return template;
    }
    private String getMd5(String key) {
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
