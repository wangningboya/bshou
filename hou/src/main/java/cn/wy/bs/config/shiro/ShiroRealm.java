package cn.wy.bs.config.shiro;

import cn.wy.bs.entity.Auth;
import cn.wy.bs.entity.User;
import cn.wy.bs.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * @Author WY
 * @Date 2019/4/10
 **/
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	private static final Logger logger = LogManager.getLogger(ShiroRealm.class);


	/**
	 * 权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		String userName = (String) principals.getPrimaryPrincipal();
		HashMap<String, Object> map = new HashMap<>();
		map.put("userName", userName);
		User user = userService.getByUserName(map);
		simpleAuthorizationInfo.addRole(user.getRoleId());
		for (Auth auth : userService.getAuthByRoleId(user.getRoleId())) {
			simpleAuthorizationInfo.addStringPermission(auth.getID());
		}
		logger.info("info");
		logger.error("error");
		logger.warn("warn");
		logger.debug("debug");
		return simpleAuthorizationInfo;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String userName = usernamePasswordToken.getUsername();
		HashMap<String, Object> map = new HashMap<>();
		map.put("userName", userName);
		User user = userService.getByUserName(map);
		if (user == null) {
			logger.error("账号不存在！");
			throw new UnknownAccountException("账号不存在！");
		} else {
			// 封装 SimpleAuthenticationInfo 对象与 UsernamePasswordToken 对象进行密码对比
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());
			//SecurityUtils.getSubject().getSession().setAttribute("userInfo",user);
			//SecurityUtils.getSubject().getSession().getStartTimestamp()
			return authenticationInfo;
		}
	}
}
