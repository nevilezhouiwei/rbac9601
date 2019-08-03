/**   
 * @Package: com.nevile.rbac01.pojo 
 * @author: zhouwei   
 * @date: 2019年4月5日 下午3:28:12 
 */
package com.nevile.rbac01.pojo;

import org.springframework.stereotype.Component;

import com.nevile.base.pojo.BasePojo;
@Component
public class Resource extends BasePojo {
	
	private int resourceId;//资源ID
	private int t_p_resource_id;
	private String resourceName;//资源名称
	private String operation;//操作
	private String resourceDes;//资源描述
	private String app;//资源归类
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public int getT_p_resource_id() {
		return t_p_resource_id;
	}
	public void setT_p_resource_id(int t_p_resource_id) {
		this.t_p_resource_id = t_p_resource_id;
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
	public String getResourceDes() {
		return resourceDes;
	}
	public void setResourceDes(String resourceDes) {
		this.resourceDes = resourceDes;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	
	
	

}
