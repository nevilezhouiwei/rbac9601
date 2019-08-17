package com.nevile.rbac01.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Role implements Serializable {

	private static final long serialVersionUID = -3437448321138785969L;

	private String roleId;

	private String roleName;

	private String roleDes;

	private List<AppResource> appResource;

	public List<AppResource> getAppResource() {
		return appResource;
	}

	public void setAppResource(List<AppResource> appResource) {
		this.appResource = appResource;
	}
	//否则MVC的转换器是不能把时间进行有效转换的
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;


	private String createUser;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//这种方式可以处理空字符串的问题
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifyTime;

	private String modifyBy;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleDes=" + roleDes + ", appResource="
				+ appResource + ", createTime=" + createTime + ", createUser=" + createUser + ", modifyTime="
				+ modifyTime + ", modifyBy=" + modifyBy + "]";
	}
}