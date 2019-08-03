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

/** 
 * @ClassName: HelloSpringBoot 
 * @Description: TODO
 * @author: Administrator
 * @date: 2019年1月24日 下午11:15:58  
 */
@RestController
public class HelloSpringBoot {

	@Autowired
	public UserDetailsService UserDetailsService;

//	 @RequestMapping("/login")
//	 public String login() {
//		 
//		return "登录成功";
//		 
//	 }
	 
	 @RequestMapping("/decsion")
	 public String decsion() {
		 
		return "decsion";
		 
	 }
	 
	 @RequestMapping("/setting")
	 public String setting() {
		 
		return "setting";
		 
	 }
	 


}
