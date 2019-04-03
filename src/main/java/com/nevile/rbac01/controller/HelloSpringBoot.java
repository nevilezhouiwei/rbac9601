/**   
 * @Package: com.example.demo 
 * @author: Administrator   
 * @date: 2019年1月24日 下午11:15:58 
 */
package com.nevile.rbac01.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nevile.rbac01.dao.UserDao;
import com.nevile.rbac01.pojo.User;

/** 
 * @ClassName: HelloSpringBoot 
 * @Description: TODO
 * @author: Administrator
 * @date: 2019年1月24日 下午11:15:58  
 */
@RestController
public class HelloSpringBoot {
	
	 @Autowired
		public UserDao userDao;

	 @RequestMapping("/")
		public User findById() {
			Optional<User> optional = userDao.findById("1");
			User user = optional.get();
			user.setModifyBy("SYS");
			userDao.save(user);
			return user;
		}
}
