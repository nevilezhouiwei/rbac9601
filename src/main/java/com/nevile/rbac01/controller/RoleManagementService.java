/**   
 * @Package: com.example.demo 
 * @author: Administrator   
 * @date: 2019年1月24日 下午11:15:58 
 */
package com.nevile.rbac01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nevile.base.nevileauth.NevileAuth;
import com.nevile.base.nevileauth.NevileOperater;
import com.nevile.base.nevileauth.Operater;
import com.nevile.base.pojo.Changedate;
import com.nevile.base.pojo.Result;
import com.nevile.rbac01.pojo.AppResource;
import com.nevile.rbac01.pojo.Role;
import com.nevile.rbac01.service.ResourceService;
import com.nevile.rbac01.service.RoleService;

/**
 * @ClassName: RoleManagementService
 * @Description: 角色管理模块
 * @author: Administrator
 * @date: 2019年1月24日 下午11:15:58
 */
@RestController
@RequestMapping("/roleManagementService")
@NevileAuth(module = "RoleManagementService", desc = "角色管理模块")
public class RoleManagementService {


	@Autowired
	public ResourceService resourceService;
	
	@Autowired
	public RoleService roleService;

	/**
	 * Description:HelloSpringBoot 测试模块 测试写接口
	 * 
	 * @author zw DateTime 2019年8月5日 下午4:57:23
	 * @return
	 */
	@RequestMapping("/write")
	@NevileOperater(operater = Operater.WRITE, desc = "角色管理模块写权限")
	public String write() {

		return "write";

	}

	/**
	 * Description:按照父ID查找子节点，默认参数为空
	 * 
	 * @author zw DateTime 2019年8月5日 下午4:57:54
	 * @return
	 */
	@GetMapping(value = { "/read/{parentId}", "/read" })
	@NevileOperater(operater = Operater.READ, desc = "角色管理模块查权限")
	public List<AppResource> listAppResource(@PathVariable(value = "parentId", required = false) String parentId) {

		return resourceService.listAppResourceByParentId(parentId);

	}

	@PostMapping(value = { "/listRole" })
	@NevileOperater(operater = Operater.READ, desc = "角色管理模块查权限")
	public List<Role> listRole( Role role) {
		List<Role> findRoles = roleService.findRoles(role);
		for (int i = 0; i < findRoles.size(); i++) {
			System.out.println(findRoles.get(i).getAppResource().toString());
		}
		return findRoles;

	}
	
	@PostMapping(value = { "/saveRoles" })
	@NevileOperater(operater = Operater.READ, desc = "角色管理模块查权限")
	public Result saveRoles(List<Role> listrole) {
		
		return roleService.saveRoles(listrole);

	}
	
	
	@PostMapping(value = { "/updateRoles" })
	public Result updateRoles(@RequestBody Changedate<Role> changedate) {
		System.out.println("updateRoles");
		return roleService.updateRoles(changedate);

	}

}
