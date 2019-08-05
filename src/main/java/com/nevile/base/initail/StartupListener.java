package com.nevile.base.initail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.nevile.base.utils.NevileUtils;
import com.nevile.rbac01.dao.AppResourceDao;
import com.nevile.rbac01.pojo.AppResource;

/**
 * Class Name: StartupListener.java Description: ApplicationListener初始化权限数据
 * 
 * @author zw DateTime 2019年8月5日 下午5:28:23
 * @company zw
 * @email 1102739617@qq.com
 * @version 1.0
 */
@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger log = LoggerFactory.getLogger(StartupListener.class);

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
		for (AppResource updateResource : addListAppResource) {
			updateResource.setResourceId(NevileUtils.getUUID());
			updateResource.setApp("securtiy");
		}
		// 更新DB
		if (!addListAppResource.isEmpty())
			appResourceDao.addListAppResource(addListAppResource);
		// 记录日志
		log.debug(addListAppResource.toString());
	}

}