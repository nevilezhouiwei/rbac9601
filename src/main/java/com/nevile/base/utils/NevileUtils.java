package com.nevile.base.utils;

import java.util.UUID;

/**
 *  Class Name: NevileUtils.java
 *  Description: 
 *  @author zw  DateTime 2019年8月4日 上午8:43:06 
 *  @company zw 
 *  @email 1102739617@qq.com
 *  @version 1.0
 */


public class NevileUtils {

    
    /**
     *  Description: 生成UUID工具
     *  @author zw DateTime 2019年8月4日 上午8:43:46
     *  @return
     */
    public static String getUUID() {   
        UUID uuid = UUID.randomUUID();   
        String str = uuid.toString();   
        // 去掉"-"符号   
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);   
        return temp;   
    } 
    
    public static void main(String[] args) {
		System.out.println(getUUID());
	}


}
