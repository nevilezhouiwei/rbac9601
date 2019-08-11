/**   
 * @Package: com.nevile.rbac01.service 
 * @author: zhouwei   
 * @date: 2019年4月7日 上午11:37:50 
 */
package com.nevile.rbac01.service;

import java.util.List;

import com.nevile.rbac01.pojo.AppResource;

public interface ResourceService {
	//查询全量资源
	List<AppResource> listAppResource();
	
	//查询全量资源
	List<AppResource> listAppResourceByParentId(String parentId);
	
	//查询是否有对应的资源
	boolean hasAppResource(AppResource appResource);
	
}
