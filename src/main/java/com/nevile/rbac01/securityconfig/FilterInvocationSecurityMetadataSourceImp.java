/**   
 * @Package: com.nevile.rbac01.securityconfig 
 * @author: zhouwei   
 * @date: 2019年4月6日 下午7:48:42 
 */
package com.nevile.rbac01.securityconfig;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.nevile.rbac01.service.ResourceService;

/**
 * 权限资源管理器 根据用户请求的地址，获取访问该地址需要的所需权限
 * 过滤器调用安全元数据资源的一个实现
 * 
 */
@Component
public class FilterInvocationSecurityMetadataSourceImp implements FilterInvocationSecurityMetadataSource {

	@Autowired
	private ResourceService resourceService;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	/*
	 * 1.若是userDetail中角色信息查到对于资源，通过拦截的url在用户拥有的资源中查找角色，最后封装角色。
	 * 2.通过拦截的url查找它对于的角色名称，封装角色。
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		// 得到用户的请求地址,控制台输出一下
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		logger.info("用户请求的地址是：" + requestUrl);
		// 如果登录页面就不需要权限
//		if ("/login".equals(requestUrl)) {
//			return null;
//		}
		// 根据资源找到那些角色可以访问
		List<String> rolesByURL = resourceService.getRolesByURL(requestUrl);
		

		// 如果没有匹配的url则说明大家都可以访问
		// 或则都不可访问,这里定义
		if (StringUtils.isEmpty(rolesByURL)) {
			return null;
		}
		logger.info("资源对应的角色：" + rolesByURL.toString());
		// 检索出url对应的角色，并把角色存放在Collection<ConfigAttribute>
		int size = rolesByURL.size();
		String[] values = new String[size];
		for (int i = 0; i < size; i++) {
			values[i] = rolesByURL.get(i);
		}
		return SecurityConfig.createList(values);

	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
