/**   
 * @Package: com.example.demo.helloworld 
 * @author: Administrator   
 * @date: 2019年1月27日 下午12:49:02 
 */
package com.nevile.rbac01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nevile.rbac01.pojo.User;

/** 
 * @ClassName: BasicRepository 
 * @Description: TODO
 * @author: Administrator
 * @date: 2019年1月27日 下午12:49:02  
 */
public  interface UserDao extends JpaRepository<User, String> {

}
