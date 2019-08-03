/**   
 * @Package: com.nevile.rbac01.securityconfig 
 * @author: zhouwei   
 * @date: 2019年5月26日 下午10:54:05 
 */
package com.nevile.rbac01.securityconfig;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

/**
 * 访问鉴权过滤器 该过滤器的作用就是，用户请求时，提供权限资源管理器和权限判断器工作的场所，实现鉴权操作.
 * 过滤器过滤所有的请求
 * 
 */
@Component
@ServletComponentScan  
@WebFilter(filterName="FilterSecurityInterceptorImp",urlPatterns="/*")  
public class FilterSecurityInterceptorImp extends AbstractSecurityInterceptor implements Filter {

	@Autowired
	private FilterInvocationSecurityMetadataSourceImp filterInvocationSecurityMetadataSourceImp;
	@Autowired
	public void setAccessDecisionManager(AccessDecisionManagerImp accessDecisionManagerImp) {
		// 重写父类 注入AccessDecisionManager
		super.setAccessDecisionManager(accessDecisionManagerImp);
	}

	@Override
	public Class<?> getSecureObjectClass() {
		// 
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		// 注入FilterInvocationSecurityMetadataSourceImp
		 return this.filterInvocationSecurityMetadataSourceImp;
	}

    @Override  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  
            throws IOException, ServletException {
    	//spirng security特有的一个过滤器
        FilterInvocation filterInvocation = new FilterInvocation(request, response, chain);  
        invoke(filterInvocation);  
    }

    public void invoke(FilterInvocation filterInvocation) throws IOException, ServletException {  
        // filterInvocation里面有一个被拦截的url  
        // 里面调用VFilterInvocationSecurityMetadataSource的getAttributes(Object object)这个方法获取filterInvocation对应的所有权限  
        // 再调用VAccessDecisionManager的decide方法来校验用户的权限是否足够  
        InterceptorStatusToken interceptorStatusToken = super.beforeInvocation(filterInvocation);  
        try {  
            // 执行下一个拦截器  
            filterInvocation.getChain().doFilter(filterInvocation.getRequest(), filterInvocation.getResponse());  
        } finally {  
            super.afterInvocation(interceptorStatusToken, null);  
        }  
    }  
}
