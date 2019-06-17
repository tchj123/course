

package course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import course.bean.AuthResult;
import course.bean.TeacherUser;
import course.bean.User;
import course.dao.TeacherUserDao;
@Service
public class TeacherUserService
{
	/**
	 * TODO 目前手动注入了依赖，日后应该改成Autowired
	 */
	TeacherUserDao pud=new TeacherUserDao();
	AuthingUserDao aud=new AuthingUserDao();
	public int register(TeacherUser userInfo)
	{
		// 查找用户名是否存在
		User user = pud.findByUserName(userInfo.getUserName());
		if(user!=null)
			return 0;
		
		return pud.register(userInfo);
	}

	/**
	 * @return 返回0代表“用户名不存在”，1代表“密码不正确”，2代表“登陆成功”,3表示正在审核，4表示审核失败
	 */
	public int login(String userName, String password)
	{
		// 查找用户名是否存在
		User user = pud.findByUserName(userName);
		if(user==null)
			return 0;
		
		//检验密码是否正确
		if (!password.equals(user.getPassword()))
			return 1;
		
		//查询用户是否通过审核
		String result=aud.findResultByUserName(); 
		if(result==null||result.isEmpty())
			return 2;
		if(result=="authing")
			return 3;
		if(result=="reject")
			return 4;
		return 2;
		
	}

	public boolean changeSelfInfo(TeacherUser userInfo)
	{
		TeacherUser user=pud.findByUserName(userInfo.getUserName());
		
		//找不到用户
		if(user==null)
			return false;
		
		/**
		 * TODO 设置user的各项，注意不可更改项。
		 */
	
		user.setInfo(userInfo.getInfo());
		
		return pud.updateUser(user);
		
	}

	
	public TeacherUser getSelfInfo(String userName)
	{
		return pud.findByUserName(userName);
	}
}
