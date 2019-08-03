/**   
 * @Package: com.nevile.rbac01.service 
 * @date: 2019年4月7日 上午11:48:36 
 */
package com.nevile.rbac01.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nevile.rbac01.dao.UserDao;
import com.nevile.rbac01.pojo.Role;
import com.nevile.rbac01.pojo.User;
import com.nevile.rbac01.securityconfig.UserDetailsImp;

@Service
public class UserDetailsServiceImp implements UserDetailsService{
	@Autowired
	private UserDao userDao;
	
	public User getUserByUserName(String userName) {
		return userDao.findByUserName(userName);
		
	}

	/* 
	 * 实现Spring Security加载用户行为
	 */
	@SuppressWarnings("unused")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.err.println("查找用户："+username);
		User user = this.getUserByUserName(username);
		if(StringUtils.isEmpty(user)) {
			throw new UsernameNotFoundException("无此用户！");
		}
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			System.out.println(role.getCreateUser());
		}

		return new UserDetailsImp(user);
	}

}
