package course.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import course.bean.OrganizationUser;
import course.bean.ParentUser;
import course.bean.TeacherUser;
import course.bean.User;

@Controller
public class IndexController
{
	@RequestMapping(value = "/")
	public ModelAndView index(HttpSession session)
	{	
		ModelAndView mav=new ModelAndView();
		
		//从session取得用户类型和用户名称
		String userType=(String)session.getAttribute("userType");
		String userName=(String)session.getAttribute("userName");
		
		//用户未登陆，转到登陆页面
		if(userName==null)
		{
			mav.setViewName("redirect:/login");
			return mav;
		}
		
		mav.setViewName(userType);
		mav.addObject("userName",userName);
		
		return mav;
	}
	
	/**
	 * 展示登陆的界面
	 */
	@RequestMapping(value="/login")
	public ModelAndView login(HttpServletRequest request)
	{
		ModelAndView mav=new ModelAndView();
		HttpSession session=request.getSession();
		//判断用户是否登陆过，若已经登陆则重定向到首页，否则到登陆界面
		if(session.getAttribute("userName")!=null)
			mav.setViewName("redirect:/");
		else
			mav.setViewName("login");
		return mav;
	}
}