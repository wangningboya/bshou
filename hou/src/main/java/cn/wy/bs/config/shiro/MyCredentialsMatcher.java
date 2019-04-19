package cn.wy.bs.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

/**
 * 自定义密码验证规则
 * @Author WY
 * @Date 2019/4/12
 **/
public class MyCredentialsMatcher extends HashedCredentialsMatcher {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

//		UsernamePasswordToken userToken = (UsernamePasswordToken) token;
//		String password = String.valueOf(userToken.getPassword());
//		Object tokenCredentials = password;
//		//Object tokenCredentials = BaseUtil.md5(password);
//		Object accountCredentials =getCredentials(info);
//		return equals(tokenCredentials,accountCredentials);

		Object tokenHashedCredentials = hashProvidedCredentials(token, info);
		Object accountCredentials = getCredentials(info);
		boolean e = equals(tokenHashedCredentials, accountCredentials);
        return e;
	}
}
