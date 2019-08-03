/**   
 * @Package: com.example.demo.helloworld 
 * @author: Administrator   
 * @date: 2019年1月27日 下午12:49:02 
 */
package com.nevile.rbac01.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.nevile.rbac01.pojo.User;

/** 
 * @ClassName: BasicRepository 
 * @Description: TODO
 * @author: Administrator
 * @date: 2019年1月27日 下午12:49:02  
 */
@Mapper
public  interface UserDao {
	public User findByUserName(String userName);

}
