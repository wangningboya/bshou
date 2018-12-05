package cn.wy.bs.utils;

import com.auth0.jwt.JWT;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import sun.security.provider.MD5;

public class TokenTest {

	public static void main(String[] args) {
		UsernamePasswordToken token = new UsernamePasswordToken("admin","123456");

//		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();

		subject.login(token);


		System.out.println(token.getUsername());
	}

}
