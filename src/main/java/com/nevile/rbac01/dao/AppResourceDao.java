/**   
 * @Package: com.nevile.rbac01.dao 
 * @author: zhouwei   
 * @date: 2019年4月7日 上午11:59:53 
 */
package com.nevile.rbac01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nevile.rbac01.pojo.AppResource;
@Mapper
public interface AppResourceDao  {
	
	public List<AppResource> listAppResource();
	
	public List<AppResource> getResourcebyId();
	
	public void addListAppResource(List<AppResource> list);
	
	public void addResource(@Param("appResource") AppResource appResource);

}
