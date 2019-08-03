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
 * @Description: TODO
 * @author: Administrator
 * @date: 2019年1月24日 下午11:15:58  
 */
@RestController
@RequestMapping("/1")
@NevileAuth(module = "HelloSpringBoot",desc="HSB des")
public class HelloSpringBoot {

	@Autowired
	public UserDetailsService UserDetailsService;
	
	@Autowired
	public ResourceService resourceService;

	 @RequestMapping("/decsion")
	 @NevileOperater(operater = Operater.READ,desc="HelloSpringBoot decsion")
	 public String decsion() {
		 
		return "decsion";
		 
	 }
	 
	 @RequestMapping("/setting")
	 @NevileOperater(operater = "setting",desc="HelloSpringBoot setting")
	 public String setting() {
		 
		return "setting";
		 
	 }
	 


}
