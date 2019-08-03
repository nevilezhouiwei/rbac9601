/**   
 * @Package: com.nevile.rbac01.securityconfig 
 * @author: zhouwei   
 * @date: 2019年4月9日 下午10:43:04 
 */
package com.nevile.rbac01.securityconfig;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
/**
 * 密码编码规则，暂时定义相等
 */
@Component
public class PasswordEncoderImp implements PasswordEncoder {


	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}


	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encodedPassword.equals(rawPassword.toString());
	}

}
