package course.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import course.bean.TeacherUser;
import course.bean.User;
import course.service.TeacherUserService;
import util.RegisterTemplate;

@Controller
public class TeacherUserRegisterController extends RegisterTemplate
{
	@Autowired
	TeacherUserService tus;
	
	
	/**
	 * 处理注册请求
	 */
	@RequestMapping(value="/registerTeacherUser",method = RequestMethod.POST)
	public ModelAndView registerPOST(@Validated TeacherUser user,BindingResult result)
	{
		return template(user, result);
	}
	
	/**
	 *  返回注册表单页面
	 */
	@RequestMapping(path = "/registerTeacherUser", method = RequestMethod.GET)
	public ModelAndView registerGet(User user)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("registerTeacherUser");
		return mav;
	}
	
	
	@Override
	protected boolean registerUser(Object user)
	{
		return tus.register((TeacherUser)user);
	}
}
