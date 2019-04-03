/**   
 * @Package: com.example.demo.helloworld 
 * @author: Administrator   
 * @date: 2019年1月27日 上午11:45:18 
 */
package com.nevile.rbac01.controller;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

/** 
 * @ClassName: User 
 * @Description: 用户POJO
 * @author: Administrator
 * @date: 2019年1月27日 上午11:45:18  
 */
@Entity
@Table(name="t_user")
public class User implements Serializable{
	@Id
	@Column(name="user_id")
	@GeneratedValue(generator="system_id")
	@GenericGenerator(name ="system_id", strategy = "uuid")
	private String userID;
	
	@Column(name="user_name")
	@NotNull
	private String userName;
	
	@Column(name="user_password")
	@NotNull
	private String userPassword;
	
	@Column(name="user_salt")
	@NotNull
	private String userSalt;
	
	@Column(name="create_time")
	private Date createTime;
	
	@Column(name="create_user")
	private String createUser;
	
	@Column(name="modify_time")
	private Date modifyTime;
	
	@Column(name="modify_by")
	private String modifyBy;
	public String getUserID() {
		return userID;
	}
	private void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserSalt() {
		return userSalt;
	}
	public void setUserSalt(String userSalt) {
		this.userSalt = userSalt;
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
		return "User [userID=" + userID + ", userName=" + userName + ", userPassword=" + userPassword + ", userSalt="
				+ userSalt + ", createTime=" + createTime + ", createUser=" + createUser + ", modifyTime=" + modifyTime
				+ ", modifyBy=" + modifyBy + "]";
	}
	
	

}
