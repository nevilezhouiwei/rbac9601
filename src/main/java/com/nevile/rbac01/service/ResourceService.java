/**   
 * @Package: com.nevile.rbac01.service 
 * @author: zhouwei   
 * @date: 2019年4月7日 上午11:37:50 
 */
package com.nevile.rbac01.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nevile.rbac01.dao.ResourceDao;
import com.nevile.rbac01.pojo.Resource;
import com.nevile.rbac01.pojo.Role;
import com.nevile.rbac01.pojo.User;

@Service
public class ResourceService {
//	@Autowired(required=false)
//	private ResourceDao permissionDao;

	/*
	 * 根据用户查找用户被赋予的角色
	 */
	public List<String> getRolesByUser(User user) {
		List<String> rolesList = new ArrayList<String>();
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			rolesList.add(role.getRoleName());
		}
		return rolesList;

	}

	/**
	 * 获取当前url对应的角色名称。 后续要改成角色名称对于的角色ID
	 */
	public List<String> getRolesByURL(String url) {
		
//		Resource permission = getResourcebyId.(url);
//		if (StringUtils.isEmpty(permission)) {
//			return null;
//		} else {
//			Set<Role> roles = permission.getRoles();
//			List<String> rolesList = new ArrayList<String>();
//			if (roles == null)
//				return null;
//			for (Role role : roles) {
//				rolesList.add(role.getRoleName());
//			}
//			return rolesList;
//		}
		return null;
	}

}
