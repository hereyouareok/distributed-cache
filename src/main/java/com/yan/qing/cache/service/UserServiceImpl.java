package com.yan.qing.cache.service;

import com.yan.qing.cache.entity.User;
import com.yan.qing.cache.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YanQin
 * @version v1.0.0
 * @Description : TODO
 * @Create on : 2020/10/9 17:00
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<User> findUsers() {
        return userDao.findUsers();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findUserById(String id) {
        return userDao.findUserById(id);
    }

    @Override
    public void updateById(String name, String id) {
        userDao.updateById(name, id);
    }

    @Override
    public void deleteById(String id) {
        userDao.deleteById(id);
    }
}
