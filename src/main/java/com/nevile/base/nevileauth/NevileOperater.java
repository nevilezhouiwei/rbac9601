package com.nevile.base.nevileauth;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(METHOD)
/**
 *  Class Name: NevileOperation.java
 *  Description: 控制器方法审计，对类的url读写权限控制
 *  @author zw  DateTime 2019年8月3日 下午2:54:53 
 *  @company zw 
 *  @email 1102739617@qq.com
 *  @version 1.0
 */
public @interface NevileOperater {
	String operater() default "";
	String desc() default "";
}
