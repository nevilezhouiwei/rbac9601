package com.nevile.base.initail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	@Autowired
	public SelfParaments selfParaments;

	/**
	 * Description:系统启动初始化
	 * 
	 * @author zw DateTime 2019年8月11日 下午3:08:11
	 * @param event
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initialResource();
	}

	/**
	 * Description:资源初始化
	 * 
	 * @author zw DateTime 2019年8月11日 下午4:41:01
	 */
	private void initialResource() {

		
	
		// 更新容器
		List<AppResource> addListAppResource = new ArrayList<AppResource>();
		// 存量数据
		List<AppResource> listAppResourceOld = appResourceDao.listAppResource();
		// 资源比较器
		HashMap<String, String>  mapAppResourceOldId = new HashMap<String, String>();
		Set<String> set = mapAppResourceOldId.keySet();
	
		
		//检查根节点，没有就插入
		AppResource root = new AppResource();
		root.setResourceId(selfParaments.id);
		List<AppResource> dbroot = appResourceDao.listByAppResource(root);
		if(dbroot.isEmpty()) {
			Date date = new Date();
			root.setResourceName(selfParaments.app);
			root.setDes(selfParaments.app);
			root.setCreateUser("system");
			root.setModifyBy("system");
			root.setCreateTime(date);
			root.setModifyTime(date);
			addListAppResource.add(root);
			log.debug("内存扫描新增根节点" + "\t" + addListAppResource.toString());
		
		}
		// 生成DB中资源数据
		for (AppResource appResource : listAppResourceOld) {
			String str = null;
			if (null == appResource.getOperation()) {
				str = appResource.getResourceName() + "," + appResource.getDes();
			} else {
				str = appResource.getResourceName() + "," + appResource.getOperation() + "," + appResource.getDes();
			}
			mapAppResourceOldId.put(str, appResource.getResourceId());
		}
		// 生成当前代码资源数据
		Map<AppResource, List<AppResource>> maptAppResourceNew = ClassScaner.getAppResource();

		// 校验新模块是否存在
		Set<AppResource> modulNew = maptAppResourceNew.keySet();
		for (AppResource modulResource : modulNew) {
			String strmodulResource = null;
			strmodulResource = modulResource.getResourceName() + "," + modulResource.getDes();
			if (!set.contains(strmodulResource)) {
				// 新增模块不存在
				String id = NevileUtils.getUUID();
				List<AppResource> listAppResources = maptAppResourceNew.get(modulResource);
				for (int i = 0; i < listAppResources.size(); i++) {
					AppResource appResource = listAppResources.get(i);
					appResource.setParentId(id);
					appResource.setResourceId(NevileUtils.getUUID());
					appResource.setResourceName(modulResource.getResourceName());
					appResource.setApp(selfParaments.app);

				}
				modulResource.setResourceId(id);
				modulResource.setParentId(selfParaments.id);

				addListAppResource.addAll(listAppResources);
				addListAppResource.add(modulResource);
				// 记录日志
				log.debug("内存扫描新增模块" + "\t" + addListAppResource.toString());
			} else {
				// 模块存在，检查是否有新增借口
				List<AppResource> listAppResources = maptAppResourceNew.get(modulResource);
				String strInterface = null;
				for (int i = 0; i < listAppResources.size(); i++) {
					strInterface = listAppResources.get(1).getResourceName() + "," + listAppResources.get(1).getOperation() + ","
							+ listAppResources.get(1).getDes();
					if (!set.contains(strInterface)) {
						String parentID = modulResource.getResourceId();
						listAppResources.get(i).setResourceId(NevileUtils.getUUID());
						listAppResources.get(i).setParentId(mapAppResourceOldId.get(strmodulResource));
						addListAppResource.add(listAppResources.get(i));
					}
				}

			}
			

		}
		log.debug("内存扫描新增模块下借口数据" + "\t" + addListAppResource.toString());
		// 更新DB
		if (!addListAppResource.isEmpty())
			appResourceDao.addListAppResource(addListAppResource);
		// 记录日志
		log.debug("资源更新结束！");
	}

}