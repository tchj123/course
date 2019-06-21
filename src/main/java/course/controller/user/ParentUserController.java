package course.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import course.bean.ParentUser;
import course.service.ParentUserService;

public class ParentUserController
{	
	
	@Autowired
	ParentUserService pus;
	
	/**
	 * 课程信息查询
	 */
	@RequestMapping("/courseInfo")
	@ResponseBody()
	public Map<String,String> searchCourseInfo()
	{
		Map<String,String> ret=new HashMap<String,String>();
		
		return ret;
	}
	
	
	/**
	 * 处理修改信息的请求
	 */
	@RequestMapping(value="/changeParentUserSelfInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> changeSelfInfo(ParentUser user)
	{
		Map<String,String> result=new HashMap();
		
		if(pus.changeSelfInfo(user)==1)
			result.put("result", "succeed");
		else
			result.put("result", "fail");
		
		return result;
	}
	
	
	/**
	 * 展示个人信息页面
	 */
	@RequestMapping(value="/ParentUserSelfInfo",method=RequestMethod.GET)
	public ModelAndView showChangeInfoForm(HttpSession session)
	{
		String userName=(String)session.getAttribute("userName");
		ParentUser user=pus.getSelfInfo(userName);
		
		ModelAndView mav=new ModelAndView("ParentUserSelfInfo");
		mav.addObject("user",user);
		
		return mav;
	}

	
	/**
	 * 申请试听
	 */
	public Map<String,String> applyForCourse(String courseName,HttpSession session)
	{
		Map<String,String> ret=new HashMap();
		String name=(String)session.getAttribute("userName");
		
		return ret;
	}
}
