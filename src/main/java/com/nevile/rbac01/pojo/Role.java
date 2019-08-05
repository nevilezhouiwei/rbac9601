/**   
 * @Package: com.nevile.rbac01.pojo 
 * @author: zhouwei   
 * @date: 2019年4月4日 下午9:26:25 
 */
package com.nevile.rbac01.pojo;

import java.util.HashSet;
import java.util.Set;

import com.nevile.base.pojo.BasePojo;

/** 
 * @ClassName: Role 
 * @Description: 角色POJO
 * @author: Administrator
 * @date: 2019年4月4日 下午9:26:25  
 */

public class Role extends BasePojo{
	
	private String roleID;

	private Set<User> users = new HashSet<User>();


	private Set<AppResource> permissions = new HashSet<AppResource>();

	
	private String roleName;
	
	private String roleDes;
	
	
	
	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDes() {
		return roleDes;
	}

	public void setRoleDes(String roleDes) {
		this.roleDes = roleDes;
	}
	
	

	public Set<AppResource> getAppResource() {
		return permissions;
	}

	public void setPermissions(Set<AppResource> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", permissions=" + permissions + ", roleName=" + roleName + ", roleDes="
				+ roleDes + ", toString()=" + super.toString() + "]";
	}

	
	

	

	

	
	



}
