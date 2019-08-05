package com.nevile.base.initail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.nevile.base.utils.NevileUtils;
import com.nevile.rbac01.dao.AppResourceDao;
import com.nevile.rbac01.pojo.AppResource;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	public AppResourceDao appResourceDao;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		String str = null;
		// 比较器
		HashSet<String> set = new HashSet<>();
		// 更新容器
		List<AppResource> addListAppResource = new ArrayList<AppResource>();
		// 存量数据
		List<AppResource> listAppResourceOld = appResourceDao.listAppResource();
		for (AppResource appResource : listAppResourceOld) {
			if (null == appResource.getOperation()) {
				str = appResource.getResourceName() + "," + appResource.getResourceDes();
			} else {
				str = appResource.getResourceName() + "," + appResource.getOperation() + ","
						+ appResource.getResourceDes();
			}
			set.add(str);
		}
		List<AppResource> listAppResourceNew = ClassScaner.getAppResource();
		for (AppResource appResource : listAppResourceNew) {
			if (null == appResource.getOperation()) {
				str = appResource.getResourceName() + "," + appResource.getResourceDes();
			} else {
				str = appResource.getResourceName() + "," + appResource.getOperation() + ","
						+ appResource.getResourceDes();
			}
			// DB中不存在着新增
			if (!set.contains(str)) {
				addListAppResource.add(appResource);
			}

		}
		System.err.println("=====待更新======");
		for (AppResource updateResource : addListAppResource) {
			updateResource.setResourceId(NevileUtils.getUUID());
			updateResource.setApp("securtiy");
			System.out.println(updateResource.toString());
		}
		// 更新DB
		if (!addListAppResource.isEmpty())
			appResourceDao.addListAppResource(addListAppResource);
	}

}