
package course.controller.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import course.service.OrganizationUserService;

@Controller
class OrganizationUserLoginController extends LoginTemplate
{
	@Autowired
	OrganizationUserService ous;
	
	/**
	 * 处理登陆请求
	 */
	@RequestMapping(value="/organizationUserLogin")
	@ResponseBody
	@Override
	public int login(String userName,String password,HttpSession session)
	{
		return super.login(userName, password, session);
	}
		
	@Override
	protected int loginUser(String userName, String password)
	{
		return ous.login(userName, password);
	}
}