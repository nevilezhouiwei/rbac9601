/**   
 * @Package: com.nevile.rbac01.securityconfig 
 * @author: zhouwei   
 * @date: 2019年4月6日 下午8:47:12 
 */
package com.nevile.rbac01.securityconfig;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class AccessDecisionManagerImp implements AccessDecisionManager {

	/*
	 * Authentication： getAuthorities()方法返回UserDetails装配的当前用户的权限列表Collection<?
	 * extends GrantedAuthority>     Object： Collection<ConfigAttribute>：
	 * FilterInvocationSecurityMetadataSource返回的资源归属的权限列表List<ConfigAttribute>
	 * 
	 * decide的任何验证不通过都是使用异常机制来实现，如果验证正常，则返回空。
	 * 
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		// 遍历当前用户所具有的权限
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		// 迭代器遍历目标url的权限列表
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();
		while (iterator.hasNext()) {
			ConfigAttribute ca = iterator.next();
			String needRole = ca.getAttribute();
			if (authorities.contains(needRole))
				return;

		}
		// 执行到这里说明没有匹配到应有权限
		throw new AccessDeniedException("权限不足!");

	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}
