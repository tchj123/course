package course.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

import course.service.AdminService;
import util.LoginTemplate;

public class AdminController extends LoginTemplate
{

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
