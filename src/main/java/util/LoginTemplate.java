package util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public abstract class LoginTemplate
{
	public Map<String,String> template(String userName, String password, HttpSession session)
	{
		Map<String, String> ret = new HashMap<String, String>();
		
		Integer result = loginUser(userName, password);

		// 将登陆状态（是否成功）放进结果里
		ret.put("result", String.valueOf(result));

		// 登陆成功
		if (result == 2)
		{
			// 登陆成功后跳转到首页
			ret.put("url", "/");

			// 将用户名和用户类型放入session中
			session.setAttribute("userName", userName);
			session.setAttribute("userType", "ParentUser");
		}
		return ret;
	}

	/**
	 * 实现用户登陆的逻辑。子类必须实现。
	 * 
	 * @return 返回值代表处理结果。返回0代表“用户名不存在”，1代表“密码不正确”，2代表“登陆成功”
	 */
	protected abstract int loginUser(String userName, String password);

}
