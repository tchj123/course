package course.controller.admin;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import course.controller.login.LoginTemplate;
import course.service.AdminService;
@Controller
@RequestMapping("/admin")
public class AdminController extends LoginTemplate
{
	@Autowired
	private AdminService as;
	
	@RequestMapping("/")
	public String index()
	{
		return "adminIndex";
	}
	
	/**
	 * 管理员登陆的接口
	 */
	@RequestMapping("/login")
	public int login(String adminName,String password,HttpSession session)
	{
		return super.login(adminName,password,session);
	}

	protected int loginUser(String userName, String password)
	{
		return as.login(userName,password);
	}
	
}
