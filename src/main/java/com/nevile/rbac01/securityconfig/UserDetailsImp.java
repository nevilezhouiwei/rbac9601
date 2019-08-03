/**   
 * @Package: com.nevile.security 
 * @author: zhouwei   
 * @date: 2019年4月4日 上午12:16:05 
 */
package com.nevile.rbac01.securityconfig;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.nevile.rbac01.pojo.Role;
import com.nevile.rbac01.pojo.User;

/**
 * @ClassName: UserDetailsImp
 * @Description: 实现UserDetail
 * @author: Administrator
 * @date: 2019年4月4日 上午12:16:05
 */
public class UserDetailsImp implements UserDetails {

	private static final long serialVersionUID = -6997145920326063511L;
	private User user;
	
	public UserDetailsImp(User user) {
        this.user = user;
    }

	/*
	 * 授权
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	       ArrayList<GrantedAuthority> authorities =  new ArrayList<GrantedAuthority>();
	       Set<Role> roles = user.getRoles();
	        for(Role role : roles) {
	        	//存储的是用户的角色信息，在代码中实例化的时候是直接使用的角色名称作为权限。
	            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
	        }
	        return authorities;

	
	}

	/*
	 * 密码
	 */
	@Override
	public String getPassword() {
		return user.getUserPassword();
	}

	/*
	 * 用户名
	 */
	@Override
	public String getUsername() {
		return user.getUserName();
	}

	/*
	 * 判断账号是否已经过期，默认没有过期
	 */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * 判断账号是否被锁定，默认没有锁定
	 */
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 *  判断信用凭证是否过期，默认没有过期
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * 判断账号是否可用，默认可用
	 */
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
