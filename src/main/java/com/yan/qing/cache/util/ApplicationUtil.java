package com.yan.qing.cache.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author YanQin
 * @version v1.0.0
 * @Description : TODO
 * @Create on : 2020/10/9 18:50
 **/
@Component
public class ApplicationUtil implements ApplicationContextAware {
    //保留下来的工厂
    private static ApplicationContext applicationContext;

    //创建好的工厂
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    //提供在工厂中获取对象的方法
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
}
