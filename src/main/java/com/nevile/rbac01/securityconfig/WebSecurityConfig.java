/**   
 * @Package: com.nevile.rbac01.securityconfig 
 * @author: zhouwei   
 * @date: 2019年4月6日 下午8:42:55 
 */
package com.nevile.rbac01.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
// security 使能
/*
 * 重写父类WebSecurityConfigurerAdapter的方法来实现自定义的权限认证
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



	/**
	 * 定义不需要过滤的静态资源（等价于HttpSecurity的permitAll）
	 */
	@Override
	public void configure(WebSecurity webSecurity) throws Exception {
		webSecurity.ignoring().antMatchers("/**");
	}

	/**
	 * 安全策略配置
	 */


	/**
	 * 开启注解控制权限 见Controller 中 @PreAuthorize("hasAuthority('XXX')")
	 */
//    @Bean  
//    @Override  
//    public AuthenticationManager authenticationManagerBean() throws Exception {  
//    return super.authenticationManagerBean();  
//    }  
}
