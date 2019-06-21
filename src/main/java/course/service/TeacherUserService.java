

package course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import course.bean.TeacherAuthResult;
import course.bean.TeacherUser;
import course.bean.User;
import course.dao.TeacherAuthResultDao;
import course.dao.TeacherUserDao;
import util.UserFactory;
@Service
public class TeacherUserService
{
	@Autowired
	TeacherUserDao tud;
	
	@Autowired
	TeacherAuthResultDao tard;
	
	/**
	 * TODO 去掉注释 @Transactional
	 */
	public int register(TeacherUser userInfo)
	{
		// 查找用户名是否存在
		User user = tud.findByUserName(userInfo.getUserName());
		if(user!=null)
			return 0;
		//注册用户，并且放入待审核列表
		if(tud.insert(userInfo)==1)
		{
			TeacherAuthResult tas=new TeacherAuthResult(userInfo.getUserName(),"authing");
			tard.insert(tas);
		}
		return 1;
	}

	/**
	 * @return 返回0代表“用户名不存在”，1代表“登陆成功”，2代表“密码不正确”,3表示正在审核，4表示审核失败
	 */
	public int login(String userName, String password)
	{
		// 查找用户名是否存在
		User user = tud.findByUserName(userName);
		if(user==null)
			return 0;
		
		//检验密码是否正确
		if (!password.equals(user.getPassword()))
			return 2;
		
		//查询用户是否通过审核
		String result=tard.findResultByUserName(userName); 
		if(result==null||result.isEmpty())
			return 1;
		if(result=="authing")
			return 3;
		if(result=="reject")
			return 4;
		
		return 1;
		
	}

	public int changeSelfInfo(TeacherUser userInfo)
	{
		TeacherUser user=tud.findByUserName(userInfo.getUserName());
		
		//找不到用户
		if(user==null)
			return 0;
		
		/**
		 * TODO 设置user的各项，注意不可更改项。
		 */
	
		user.setInfo(userInfo.getInfo());
		
		return tud.updateUser(user)>1?1:0;
		
	}

	
	public TeacherUser getSelfInfo(String userName)
	{
		return tud.findByUserName(userName);
	}
}
