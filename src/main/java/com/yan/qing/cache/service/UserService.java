package com.yan.qing.cache.service;

import com.yan.qing.cache.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YanQin
 * @version v1.0.0
 * @Description : TODO
 * @Create on : 2020/10/9 16:59
 **/
public interface UserService {
    List<User> findUsers();
    User findUserById(String id);
    void deleteById(String id);
    void updateById(String name, String id);
}
