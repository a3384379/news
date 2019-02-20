package cn.mycase.controller;


import java.io.IOException;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.mycase.entity.OrdinaryUser;
import cn.mycase.entity.User;
import cn.mycase.service.UserService;
import cn.mycase.utils.MD5Utils;
import cn.mycase.utils.ValidateCode;

@Controller
public class UserController {
	@Autowired
	private UserService service;

	public void setService(UserService service) {
		this.service = service;
	}

	// 管理员登陆
	@RequestMapping(value = "login.action")
	public String login(HttpServletRequest request, HttpServletResponse response, User user) {
		try {
		
		String md5 = null;
		if (user.getPassword() != null && user.getPassword() != "") {
			// md5加密密码
			md5 = MD5Utils.md5(user.getPassword());
			User userList = service.queryUser(user.getUsername());
			// id==1为的管理员，其它用户不能登陆
			if (md5.equals(userList.getPassword())) {//从数据库获取密码比较
				Cookie rootname = new Cookie("rootname", userList.getUsername());
				Cookie rootPassword = new Cookie("rootPassword", userList.getPassword());
				response.addCookie(rootname);
				response.addCookie(rootPassword);
				return "/admin/home.jsp";
			}
		}
		
		String rootname=null;
		String rootPassword=null;
		
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
		for (Cookie cookie : cookies) {
			if("rootname".equals(cookie.getName()) ) {
				rootname=cookie.getValue();
			}
			if("rootPassword".equals(cookie.getName()) ) {
				rootPassword=cookie.getValue();
			}
		}
		}
		if(rootname!=null&&rootPassword!=null) {
			return "/admin/home.jsp";
		}
		else {
			return "/admin/index.jsp";
		}
		} catch (Exception e) {
			return "/admin/index.jsp";
		}
		

	}

	// 管理员退出帐号清除cookie
	@RequestMapping(value = "userclose.action")
	public void close(HttpServletRequest request, HttpServletResponse response) {
		Cookie username = new Cookie("rootname", null);
		username.setMaxAge(0);
		response.addCookie(username);
		Cookie password = new Cookie("rootPassword", null);
		password.setMaxAge(0);
		response.addCookie(password);
	}

	// 管理员修改密码
	@RequestMapping(value = "repassword.action")
	public String repassword(String oldpassword, String newpassword) {
		// root管理者用户
		User root = service.queryUserByid(1);
		String password = root.getPassword();
		String oldmd5 = null;
		if (oldpassword != null) {
			oldmd5 = MD5Utils.md5(oldpassword);
		}
		if (password.equals(oldmd5)) {
			if (newpassword != null) {
				service.update(MD5Utils.md5(newpassword));
				return "admin/success.jsp";

			}
		}
		return "admin/error.jsp";

	}

	// 用户退出帐号清除cookie
	@RequestMapping(value = "ordinaryUserClose.action")
	public void rdinaryUserClose(HttpServletRequest request, HttpServletResponse response) {
		Cookie username = new Cookie("username", null);
		username.setMaxAge(0);
		response.addCookie(username);
		Cookie password = new Cookie("password", null);
		password.setMaxAge(0);
		response.addCookie(password);
	}
	
	//----------------------------------------------------------------

	// 普通用户登陆
	@RequestMapping(value = "ordinaryUserLogin.action")
	public String ordinaryUserLogin(OrdinaryUser user, HttpServletRequest request, HttpServletResponse response,Map<String,Object> map) {
		String code = request.getParameter("code");
		HttpSession session = request.getSession();
		String sessionCode = (String) session.getAttribute("code");
		if (!StringUtils.equalsIgnoreCase(code, sessionCode)) {  //忽略验证码大小写
			map.put("use", user.getUsername());
			map.put("pas", user.getPassword());
			System.out.println(sessionCode);
			return "/login.jsp";
		}
		// md5加密密码
		try {
		String md5 = null;
		if (user.getPassword() != null && user.getPassword() != "") {
			md5 = MD5Utils.md5(user.getPassword());
			OrdinaryUser userList = service.queryOrdinaryUser(user.getUsername());
			
			if (md5.equals(userList.getPassword())) {
				Cookie username = new Cookie("username", userList.getUsername());
				Cookie password = new Cookie("password", userList.getPassword());
				response.addCookie(username);
				response.addCookie(password);
				return "redirect:/index.jsp";
			}
		}
		} catch (Exception e) {
			return "/login.jsp";
		}
		return "/login.jsp";

	}

	// 普通用户注册
	@RequestMapping(value = "register.action")
	public String ordinaryUserRegister(OrdinaryUser user) {
		String md5=MD5Utils.md5(user.getPassword());
		user.setPassword(md5);
		service.saveOrdinaryUser(user);
		return "/index.jsp";
	}
	
	//检测用户名是否重复
	@RequestMapping(value = "checkUsername.action")
	public void checkUsername(String username, HttpServletResponse response) {
		boolean isExist=false;
		OrdinaryUser queryOrdinaryUser = service.queryOrdinaryUser(username);
		if(queryOrdinaryUser!=null)
		{
			isExist=true;
		}
		try {
			response.getWriter().write("{\"isExist\":"+isExist+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 退出帐号清除cookie
	@RequestMapping(value = "ordinaryUserclose.action")
	public String ordinaryUserclose(HttpServletRequest request, HttpServletResponse response) {
		Cookie username = new Cookie("username", null);
		username.setMaxAge(0);
		response.addCookie(username);
		Cookie password = new Cookie("password", null);
		password.setMaxAge(0);
		response.addCookie(password);
		return "redirect:/index.jsp";
	}
	
	/**
	 * controller层输出验证码
	 * 响应验证码页面
	 * @return
	 */
	@RequestMapping(value="/validateCode.action")
	public String validateCode(HttpServletRequest request,HttpServletResponse response) throws Exception{
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		//禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
 
		HttpSession session = request.getSession();
 
		ValidateCode vCode = new ValidateCode(120,40,5,100);
		session.setAttribute("code", vCode.getCode());
		vCode.write(response.getOutputStream());
		return null;
	}

	

}
