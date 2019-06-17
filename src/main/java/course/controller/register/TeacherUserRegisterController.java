package course.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@RequestMapping(value="/TeacherUserRegister",method = RequestMethod.POST)
	@ResponseBody
	public int register(@Validated TeacherUser user,BindingResult result)
	{
		return super.register(user, result);
	}
	
	/**
	 *  返回注册表单页面
	 */
	@RequestMapping(path = "/TeacherUserRegister", method = RequestMethod.GET)
	public ModelAndView registerForm(User user)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("TeacherUserRegister");
		return mav;
	}
	
	
	@Override
	protected int registerUser(Object user)
	{
		return tus.register((TeacherUser)user);
	}


}
