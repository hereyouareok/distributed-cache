package com.yan.qing.cache.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author YanQin
 * @version v1.0.0
 * @Description : TODO
 * @Create on : 2020/10/9 16:50
 **/
@Data
public class User implements Serializable {
    private  String id;
    private  String name;
    private  Date birthday;

    public User() {
    }

    public User(String id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }
}
