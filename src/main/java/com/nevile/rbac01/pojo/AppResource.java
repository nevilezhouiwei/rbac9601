/**   
 * @Package: com.nevile.rbac01.pojo 
 * @author: zhouwei   
 * @date: 2019年4月5日 下午3:28:12 
 */
package com.nevile.rbac01.pojo;

import java.io.Serializable;
import java.util.Date;

public class AppResource implements Serializable {

	private static final long serialVersionUID = 9128086272534082336L;
	
	private String resourceId;// 资源ID
	private String parentId;// 父ID
	private String resourceName;// 资源名称
	private String operation;// 操作
	private String des;// 资源描述
	private String app;// 资源归类
	private Date createTime;
	private String createUser;
	private Date modifyTime;
	private String modifyBy;
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
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
		return "AppResource [resourceId=" + resourceId + ", parentId=" + parentId + ", resourceName=" + resourceName
				+ ", operation=" + operation + ", des=" + des + ", app=" + app + ", createTime=" + createTime
				+ ", createUser=" + createUser + ", modifyTime=" + modifyTime + ", modifyBy=" + modifyBy + "]";
	}
	
	

}
