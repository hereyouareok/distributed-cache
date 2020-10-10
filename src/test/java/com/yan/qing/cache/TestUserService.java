package com.yan.qing.cache;

import com.yan.qing.cache.entity.User;
import com.yan.qing.cache.service.UserService;
import org.apache.ibatis.cache.Cache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void testUpdateOne() {
        userService.updateById("haha","2");
    }
    @Test
    public void testDeleteOne() {
       userService.deleteById("1");
    }
}
