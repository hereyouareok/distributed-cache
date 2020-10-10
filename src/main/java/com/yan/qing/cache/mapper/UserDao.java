package com.yan.qing.cache.mapper;

import com.yan.qing.cache.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YanQin
 * @version v1.0.0
 * @Description : TODO
 * @Create on : 2020/10/9 16:50
 **/
public interface UserDao {
    List<User> findUsers();

    User findUserById(String id);

    void deleteById(String id);

    void updateById(@Param("name") String name, @Param("id")String id);
}
