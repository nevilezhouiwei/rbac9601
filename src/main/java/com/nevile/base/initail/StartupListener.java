package com.nevile.base.initail;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nevile.base.nevileauth.NevileAuth;

public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// 获取@JalorOperation注解的所有bean
		Map<String, Object> map = event.getApplicationContext().getBeansWithAnnotation(NevileAuth.class);
		System.out.println("----------bean----------");
		ObjectMapper mapper = new ObjectMapper();
		try {
			Set<String> keySet = map.keySet();
			Iterator<String> iterator = keySet.iterator();
			while (iterator.hasNext()) {
				String string = (String) iterator.next();
				System.out.println(string+"----"+mapper.writeValueAsString(map.get(string)));
				
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 循环判断是否存在，获取属性值
		
		
	}
}