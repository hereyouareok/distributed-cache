package com.yan.qing.cache;

import com.yan.qing.cache.entity.User;
import com.yan.qing.cache.service.UserService;
import com.yan.qing.cache.util.ApplicationUtil;
import org.apache.ibatis.cache.Cache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author YanQin
 * @version v1.0.0
 * @Description : TODO
 * @Create on : 2020/10/9 17:02
 **/
@SpringBootTest(classes = DistributedCacheApplication.class)
@RunWith(SpringRunner.class)
public class TestUserService {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1() {
        List<User> users = userService.findUsers();
        users.forEach(user -> System.out.println(user.toString()));
        System.out.println("....................................................");
        List<User> users2 = userService.findUsers();
        users2.forEach(user -> System.out.println(user.toString()));
    }

    @Test
    public void testFindOne() {
        userService.findUserById("2");
        System.out.println("....................................................");
        System.out.println(userService.findUserById("2"));
    }

    @Test
    public void testMaster() {

        //stringRedisTemplate.opsForValue().set("teacher".toString(), "miao".toString());

        //System.out.println(stringRedisTemplate.opsForValue().get("teacher"));

        /*ArrayList<User> users = new ArrayList<>();
        users.add(new User("1", "zhangsan", new Date()));
        users.add(new User("2", "lisi", new Date()));
        users.add(new User("3", "老王", new Date()));
        getRedisTemplate().opsForList().leftPushAll("lists", users);*/

         System.out.println(getRedisTemplate().opsForList().range("lists",0,-1));
    }

    @Test
    public void testUpdateOne() {
        userService.updateById("haha", "2");
    }

    @Test
    public void testDeleteOne() {
        userService.deleteById("1");
    }

    private RedisTemplate getRedisTemplate() {
        RedisTemplate template = (RedisTemplate) ApplicationUtil.getBean("redisTemplate");

        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        return template;
    }
}
