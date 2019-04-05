/**   
 * @Package: com.nevile.rbac01.pojo 
 * @author: zhouwei   
 * @date: 2019年4月4日 下午9:26:25 
 */
package com.nevile.rbac01.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import com.nevile.base.BasePojo;

/** 
 * @ClassName: Role 
 * @Description: 角色POJO
 * @author: Administrator
 * @date: 2019年4月4日 下午9:26:25  
 */
@Entity
@Table(name="t_role")
public class Role extends BasePojo{
	@Id
	@Column(name="role_id")
	@GeneratedValue(generator="system_id")
	@GenericGenerator(name ="system_id", strategy = "increment")
	private String roleID;
	
	@ManyToMany(targetEntity=User.class,mappedBy="roles") //让role维护外键表
	@Cascade(CascadeType.ALL)
	private Set<User> users = new HashSet<User>();

	
	@Column(name="role_name")
	@NotNull
	private String roleName;
	
	@Column(name="role_des")
	@NotNull
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

	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", users=" + users + ", roleName=" + roleName + ", roleDes=" + roleDes
				+ ", toString()=" + super.toString() + "]";
	}

	

	

	

	
	



}
