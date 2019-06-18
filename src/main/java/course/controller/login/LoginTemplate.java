package course.controller.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
/**
 * 用户登陆通用模板类。
 * @author tchj
 *
 */
public abstract class LoginTemplate
{
	public int login(String userName, String password, HttpSession session)
	{
		int ret = loginUser(userName, password);

		// 登陆成功
		if (ret == 2)
		{

			// 将用户名和用户类型放入session中
			session.setAttribute("userName", userName);
			session.setAttribute("userType", "ParentUser");
		}
		return ret;
	}

	/**
	 * 实现用户登陆的逻辑。子类必须实现。
	 * 
	 * @return 返回值代表处理结果。返回0代表“用户名不存在”，1代表“登陆成功”，2代表“密码不正确”
	 */
	protected abstract int loginUser(String userName, String password);

}
