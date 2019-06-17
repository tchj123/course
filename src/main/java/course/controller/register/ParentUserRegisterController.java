package course.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import course.bean.ParentUser;
import course.bean.User;
import course.service.ParentUserService;
import util.RegisterTemplate;

@Controller
class ParentUserRegisterController extends RegisterTemplate
{
	@Autowired
	ParentUserService pus;
	
	
	/**
	 * 处理注册请求
	 */
	@RequestMapping(value="/parentUserRegister",method = RequestMethod.POST)
	public int register(@Validated ParentUser user,BindingResult result)
	{
		return super.register(user, result);
	}
		
	/**
	 *  返回注册表单页面
	 */
	@RequestMapping(path = "/parentUserRegister", method = RequestMethod.GET)
	public ModelAndView registerForm(User user)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("parentUserRegister");
		return mav;
	}
	
	
	@Override
	protected int registerUser(Object user)
	{
		return pus.register((ParentUser)user);
	}
	
}