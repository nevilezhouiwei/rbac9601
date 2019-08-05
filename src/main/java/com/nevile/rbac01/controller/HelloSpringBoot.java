/**   
 * @Package: com.example.demo 
 * @author: Administrator   
 * @date: 2019年1月24日 下午11:15:58 
 */
package com.nevile.rbac01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nevile.base.nevileauth.NevileAuth;
import com.nevile.base.nevileauth.NevileOperater;
import com.nevile.base.nevileauth.Operater;
import com.nevile.rbac01.service.ResourceService;

/** 
 * @ClassName: HelloSpringBoot 
 * @Description: HelloSpringBoot 测试模块
 * @author: Administrator
 * @date: 2019年1月24日 下午11:15:58  
 */
@RestController
@RequestMapping("/hellospringboot")
@NevileAuth(module = "HelloSpringBoot",desc="HSB 测试模块")
public class HelloSpringBoot {

	@Autowired
	public UserDetailsService UserDetailsService;
	
	@Autowired
	public ResourceService resourceService;

	 
	/**
	 *  Description:HelloSpringBoot 测试模块 测试写接口
	 *  @author zw DateTime 2019年8月5日 下午4:57:23
	 *  @return
	 */
	@RequestMapping("/write")
	 @NevileOperater(operater = Operater.WRITE,desc="HSB 测试写接口")
	 public String write() {
		 
		return "write";
		 
	 }
	 
	 
	/**
	 *  Description:HelloSpringBoot 测试模块 测试读接口
	 *  @author zw DateTime 2019年8月5日 下午4:57:54
	 *  @return
	 */
	@RequestMapping("/read")
	 @NevileOperater(operater = Operater.READ,desc="HSB 测试读接口")
	 public String read() {
		 
		return "read";
		 
	 }
	 


}
