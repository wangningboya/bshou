package cn.wy.bs.config.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @Author WY
 * @Date 2019/4/10
 **/

@Configuration
public class ShiroConfig {

	@Autowired
	private RedisProperties redisProperties;

	@Bean(name = "shirFilter")
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {

		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

		//必须设置 SecurityManager,Shiro的核心安全接口
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		//自定义拦截器.
		// 配置访问权限 必须是LinkedHashMap，因为它必须保证有序
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 配置不会被拦截的链接 顺序判断
		//filterChainDefinitionMap.put("/static/**", "anon");
		//<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑，一不小心代码就不好使了;
		//<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/loginn", "anon");
		filterChainDefinitionMap.put("/home", "authc");
		//filterChainDefinitionMap.put("/templates/**", "authc");
		// 设置登录页面 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/loginn");
		// 登录成功后要跳转的链接
		//没用...
		//shiroFilterFactoryBean.setSuccessUrl("/home");
		//配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/logout", "logout");

		//其他资源都需要认证  authc 表示需要认证才能进行访问 user表示配置记住我或认证通过可以访问的地址
		//如果开启限制同一账号登录,改为 .put("/**", "kickout,user");
		//filterChainDefinitionMap.put("/**", "user");

		//未授权界面;
		shiroFilterFactoryBean.setUnauthorizedUrl("/base/error");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;

	}

	/**
	 * 凭证匹配器
	 *
	 * @return HashedCredentialsMatcher
	 */
	@Bean
	public MyCredentialsMatcher myCredentialsMatcher() {
		MyCredentialsMatcher myCredentialsMatcher = new MyCredentialsMatcher();
		// 使用 MD5 散列算法
		myCredentialsMatcher.setHashAlgorithmName("md5");
		// 散列次数 一次md5加密
		myCredentialsMatcher.setHashIterations(1);
		return myCredentialsMatcher;
	}

	@Bean
	public ShiroRealm myShiroRealm() {
		ShiroRealm myShiroRealm = new ShiroRealm();
		myShiroRealm.setCredentialsMatcher(myCredentialsMatcher());
		return myShiroRealm;
	}

	/**
	 * 配置核心安全事务管理器
	 */
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		//设置自定义Realm
		securityManager.setRealm(myShiroRealm());
		//配置记住我
		//securityManager.setRememberMeManager(rememberMeManager());
		// 自定义 session 管理，使用 Redis
		securityManager.setSessionManager(sessionManager());
		// 自定义缓存实现，使用 Redis
		//securityManager.setCacheManager(cacheManager());
		return securityManager;
	}

	/**
	 * 自定义 SessionManager
	 *
	 * @return sessionManager
	 */
	@Bean
	public SessionManager sessionManager() {
		MySessionManager sessionManager = new MySessionManager();
		//sessionManager.setSessionDAO(redisSessionDAO());

		//全局会话超时时间（单位毫秒），默认30分钟
		sessionManager.setGlobalSessionTimeout(1800000);
		//是否开启删除无效的session对象  默认为true
		sessionManager.setDeleteInvalidSessions(true);
		//是否开启定时调度器进行检测过期session 默认为true
		sessionManager.setSessionValidationSchedulerEnabled(true);
		return sessionManager;
	}


	/**
	 * 配置shiro redisManager，使用的是shiro-redis开源插件
	 */
//	public RedisManager redisManager() {
//		RedisManager redisManager = new RedisManager();
//		redisManager.setHost(redisProperties.getHost());
//		//redisManager.setPort(redisProperties.getPort());
//		redisManager.setPassword(redisProperties.getPassword());
//		redisManager.setDatabase(redisProperties.getDatabase());
//		redisManager.setTimeout(600000);
//		return redisManager;
//	}


//	/**
//	 * cacheManager 缓存 redis 实现
//	 */
//	@Bean
//	public RedisCacheManager cacheManager() {
//		RedisCacheManager redisCacheManager = new RedisCacheManager();
//		redisCacheManager.setRedisManager(redisManager());
//		return redisCacheManager;
//	}

	/**
	 * RedisSessionDAO shiro sessionDao层的实现 通过redis
	 */
//	@Bean
//	public RedisSessionDAO redisSessionDAO() {
//		RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
//		redisSessionDAO.setRedisManager(redisManager());
//		//session在redis中的保存时间,最好大于session会话超时时间
//		redisSessionDAO.setExpire(1900000);
//		//redisSessionDAO.setKeyPrefix("shiro:user:");
//		return redisSessionDAO;
//	}

	/**
	 * cookie管理对象;记住我功能,rememberMe管理器
	 * @return
	 */
//	@Bean
//	public CookieRememberMeManager rememberMeManager(){
//		CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//		cookieRememberMeManager.setCookie(rememberMeCookie());
//		//rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
//		cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
//		return cookieRememberMeManager;
//	}

	/**
	 * cookie对象;会话Cookie模板 ,默认为: JSESSIONID 问题: 与SERVLET容器名冲突,重新定义为sid或rememberMe，自定义
	 * @return
	 */
//	@Bean
//	public SimpleCookie rememberMeCookie(){
//		//这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
//		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
//		//setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：
//		//setcookie()的第七个参数
//		//设为true后，只能通过http访问，javascript无法访问
//		//防止xss读取cookie
//		simpleCookie.setHttpOnly(true);
//		simpleCookie.setPath("/");
//		//<!-- 记住我cookie生效时间30天 ,单位秒;-->
//		simpleCookie.setMaxAge(2592000);
//		return simpleCookie;
//	}

	/**
	 * 开启shiro aop注解支持.
	 * 使用代理方式;所以需要开启代码支持;
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

}
