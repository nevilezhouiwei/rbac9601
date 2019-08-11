package com.nevile.rbac01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nevile.rbac01.dao.AppResourceDao;
import com.nevile.rbac01.pojo.AppResource;
import com.nevile.rbac01.service.ResourceService;

/**
 *  Class Name: ResourceServiceImplll.java
 *  Description: 
 *  @author zw  DateTime 2019年8月10日 下午4:21:31 
 *  @company zw 
 *  @email 1102739617@qq.com
 *  @version 1.0
 */
@Service
public class ResourceServiceImplll implements ResourceService{
	@Autowired
	private AppResourceDao appResourceDao;

	
	/**
	 *  Description:
	 *  @author zw DateTime 2019年8月10日 下午4:21:55
	 *  @return
	 */
	@Override
	public List<AppResource> listAppResource() {
		return appResourceDao.listAppResource();
	}

	
	/**
	 *  Description:
	 *  @author zw DateTime 2019年8月10日 下午4:21:55
	 *  @param appResource
	 *  @return
	 */
	@Override
	public boolean hasAppResource(AppResource appResource) {
		// TODO Auto-generated method stub
		return false;
	}


	
	/**
	 *  Description:
	 *  @author zw DateTime 2019年8月10日 下午5:24:38
	 *  @param id
	 *  @return
	 */
	@Override
	public List<AppResource> listAppResourceByParentId(String parentId) {
		AppResource appResource = new AppResource();
		appResource.setParentId(parentId);
		
		return appResourceDao.listByAppResource(appResource);
	}

}
