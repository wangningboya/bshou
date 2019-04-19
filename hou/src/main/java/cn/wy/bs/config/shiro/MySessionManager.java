package cn.wy.bs.config.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @Author WY
 * @Date 2019/4/16
 **/
public class MySessionManager extends DefaultWebSessionManager {

	static final Logger logger = LogManager.getLogger(ShiroRealm.class);


	@Override
	protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
		String id = WebUtils.toHttp(request).getHeader("authToken");
		if(StringUtils.isEmpty(id)){
			//如果没有携带id参数则按照父类的方式在cookie进行获取
			logger.info("没有携带id参数则按照父类的方式在cookie进行获取");
			System.out.println("super："+super.getSessionId(request, response));
			return super.getSessionId(request, response);
		}else{
			//如果请求头中有 authToken 则其值为sessionId
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,"Stateless request");
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID,id);
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID,Boolean.TRUE);
			return id;
		}
	}
}
