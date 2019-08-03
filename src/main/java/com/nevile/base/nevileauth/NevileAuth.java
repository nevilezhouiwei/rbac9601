package com.nevile.base.nevileauth;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(TYPE)
/**
 *  Class Name: NevileAuth.java
 *  Description: 控制器类层面审计
 *  @author zw  DateTime 2019年8月3日 下午2:53:56 
 *  @company zw 
 *  @email 1102739617@qq.com
 *  @version 1.0
 */
public @interface NevileAuth {
	String module() default "";
	String desc() default "";

}
