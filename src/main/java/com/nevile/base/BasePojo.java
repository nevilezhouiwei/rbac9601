/**   
 * @Package: com.nevile.base 
 * @author: Administrator   
 * @date: 2019年2月13日 下午10:57:24 
 */
package com.nevile.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/** 
 * @ClassName: BasePojo 
 * @Description: 抽取重用的字段.任何面向数据库的pojo都必须继承此类
 * @author: Administrator
 * @date: 2019年2月13日 下午10:57:24  
 */
@MappedSuperclass  
public  class BasePojo {
	
    @Temporal(TemporalType.TIMESTAMP)  
    @Column(name="create_time",  nullable=false, updatable = false)  
    @Generated(GenerationTime.INSERT)
	private Date createTime;
	
	@Column(name="create_user")
	private String createUser;
	
	@Column(name="modify_time")
	private Date modifyTime;
	
	@Column(name="modify_by")
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

	@Override
	public String toString() {
		return "BasePojo [createTime=" + createTime + ", createUser=" + createUser + ", modifyTime=" + modifyTime
				+ ", modifyBy=" + modifyBy + "]";
	}


	
}
