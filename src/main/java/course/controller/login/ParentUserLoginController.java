package course.controller.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import course.bean.ParentUser;
import course.service.ParentUserService;
import util.LoginTemplate;

@Controller
class ParentUserLoginController extends LoginTemplate
{
	@Autowired
	ParentUserService pus;
	
	/**
	 * 处理登陆请求
	 */
	@RequestMapping(value="/ParentUserlogin")
	@ResponseBody
	@Override
	public int login(String userName,String password,HttpSession session)
	{
		return super.login(password, password, session);
	}
	
	
	@Override
	protected int loginUser(String userName, String password)
	{
		return pus.login(userName, password);
	}
}