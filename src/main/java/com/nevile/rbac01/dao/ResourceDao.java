/**   
 * @Package: com.nevile.rbac01.dao 
 * @author: zhouwei   
 * @date: 2019年4月7日 上午11:59:53 
 */
package com.nevile.rbac01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nevile.rbac01.pojo.Resource;
@Mapper
public interface ResourceDao  {
	public List<Resource> listResource();
	
	public List<Resource> getResourcebyId();

}
