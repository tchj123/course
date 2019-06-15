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
	@RequestMapping(value="/registerParentUser",method = RequestMethod.POST)
	public ModelAndView registerPOST(@Validated ParentUser user,BindingResult result)
	{
		return template(user, result);
	}
		
	/**
	 *  返回注册表单页面
	 */
	@RequestMapping(path = "/registerParentUser", method = RequestMethod.GET)
	public ModelAndView registerGet(User user)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("registerParentUser");
		return mav;
	}
	
	
	@Override
	protected boolean registerUser(Object user)
	{
		return pus.register((ParentUser)user);
	}
	
}