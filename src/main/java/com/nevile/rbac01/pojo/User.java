/**   
 * @Package: com.example.demo.helloworld 
 * @author: Administrator   
 * @date: 2019年1月27日 上午11:45:18 
 */
package com.nevile.rbac01.pojo;

import java.util.HashSet;
import java.util.Set;

import com.nevile.base.pojo.BasePojo;

/**
 * @ClassName: User
 * @Description: 用户POJO
 * @author: Administrator
 * @date: 2019年1月27日 上午11:45:18
 */
public class User extends BasePojo{
	private String userID;

	private Set<Role> roles = new HashSet<Role>();
	private String userName;

	private String userPassword;
	private String userSalt;

	

	public String getUserID() {
		return userID;
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

	

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "User [userID=" + userID + ", roles=" + roles + ", userName=" + userName + ", userPassword="
				+ userPassword + ", userSalt=" + userSalt + ", toString()=" + super.toString() + "]";
	}







	


	

}
