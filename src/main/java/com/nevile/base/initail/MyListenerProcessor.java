package com.nevile.base.initail;


import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.nevile.base.nevileauth.NevileAuth;
import com.nevile.base.nevileauth.NevileOperater;

@Component
public class MyListenerProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
        if (methods != null) {
        	StringBuffer sb = null;
            for (Method method : methods) {
                NevileOperater nevileAuth = AnnotationUtils.findAnnotation(method, NevileOperater.class);
                if (null != nevileAuth) {
                	sb=new StringBuffer();
                    //插入到数据中
                	System.out.println("----MyListenerProcessor-----");
                    System.out.println(nevileAuth.operater());
                    System.out.println(nevileAuth.desc());
                    sb.append(nevileAuth.operater()+":"+nevileAuth.desc());
                }
            }
            if(null!=sb) {
            	
            	System.out.println(sb.toString());
            }
        }
        return bean;
    }
}