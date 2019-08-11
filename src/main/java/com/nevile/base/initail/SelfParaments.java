package com.nevile.base.initail;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Class Name: SelfParaments.java Description:
 * 
 * @author zw DateTime 2019年8月11日 下午12:36:05
 * @company zw
 * @email 1102739617@qq.com
 * @version 1.0
 */
@Component
@ConfigurationProperties(prefix = "self-paraments")
public class SelfParaments {
	public String app;
	public String id;

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



}
