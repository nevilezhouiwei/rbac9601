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
 * @Description: 抽取重用的字段
 * @author: Administrator
 * @date: 2019年2月13日 下午10:57:24  
 */
@MappedSuperclass  
public class BasePojo {
	
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

}
