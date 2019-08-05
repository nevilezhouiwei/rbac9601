/**   
 * @Package: com.nevile.rbac01.pojo 
 * @author: zhouwei   
 * @date: 2019年4月5日 下午3:28:12 
 */
package com.nevile.rbac01.pojo;

import org.springframework.stereotype.Component;

import com.nevile.base.pojo.BasePojo;
@Component
public class AppResource extends BasePojo {
	
	private String resourceId;//资源ID
	private String tpdid;
	private String resourceName;//资源名称
	private String operation;//操作
	private String resourceDes;//资源描述
	private String app;//资源归类
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
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
	public String getTpdid() {
		return tpdid;
	}
	public void setTpdid(String tpdid) {
		this.tpdid = tpdid;
	}
	@Override
	public String toString() {
		return "AppResource [resourceId=" + resourceId + ", tpdid=" + tpdid + ", resourceName=" + resourceName
				+ ", operation=" + operation + ", resourceDes=" + resourceDes + ", app=" + app + "]";
	}
	

}
