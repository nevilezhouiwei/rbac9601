/**   
 * @Package: com.nevile.base 
 * @author: Administrator   
 * @date: 2019年2月13日 下午10:57:24 
 */
package com.nevile.base.pojo;

import java.util.Date;

/** 
 * @ClassName: BasePojo 
 * @Description: 抽取重用的字段.任何面向数据库的pojo都必须继承此类
 * @author: Administrator
 * @date: 2019年2月13日 下午10:57:24  
 */
public  class BasePojo {
	
	private Date createTime;
	
	private String createUser;
	
	private Date modifyTime;
	
	private String modifyBy;

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



	
}
