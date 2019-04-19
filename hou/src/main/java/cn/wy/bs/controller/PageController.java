package cn.wy.bs.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author WY
 * @Date 2019/4/15
 **/
@Controller
public class PageController {

	@RequestMapping(value = "/loginn",method = RequestMethod.GET)
	public String login(){
		return "login";
	}

	@RequiresPermissions("65abfb7dd3984d59972c2289f1a0cde4")
	@RequestMapping("/home")
	public String home(){
		return "home";
	}

	@RequestMapping("/logout")
	public void logout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
	}

	@RequestMapping(value = "/login2", method = RequestMethod.POST)
	public String login2(
			//HttpServletRequest request,
			//@RequestParam HashMap<String, Object> map
	) {
		//String userName = map.get("userName").toString();
		//String password = map.get("password").toString();
		//UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
		UsernamePasswordToken token = new UsernamePasswordToken("admin","123456");
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
		System.out.println("-----1-----");
		return "home";
	}

}
