package course.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import course.bean.OrganizationUser;
import course.bean.User;
import course.service.OrganizationUserService;
import util.RegisterTemplate;

@Controller
public class OrganizationUserRegisterController extends RegisterTemplate
{
	@Autowired
	OrganizationUserService ous;
	
	
	/**
	 * 处理注册请求
	 */
	@RequestMapping(value="/registerOrganizationUser",method = RequestMethod.POST)
	public ModelAndView registerPOST(@Validated OrganizationUser user,BindingResult result)
	{
		return template(user, result);
	}
	
	/**
	 *  返回注册表单页面
	 */
	@RequestMapping(path = "/registerOrganizationUser", method = RequestMethod.GET)
	public ModelAndView registerGet(User user)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("registerOrganizationUser");
		return mav;
	}
	
	
	@Override
	protected boolean registerUser(Object user)
	{
		return ous.register((OrganizationUser)user);
	}
}
