
package course.dao.MockDao;

import java.util.LinkedList;
import java.util.List;

import course.bean.ParentUser;
import course.bean.TeacherUser;
import course.bean.User;

public class TeacherUserDao
{
	private List<TeacherUser> userList;

	// 手动注入数据
	public TeacherUserDao()
	{
		userList=new LinkedList<TeacherUser>();
		userList.add(new TeacherUser("tchj", "123456"));
	}

	public TeacherUser findByUserName(String userName)
	{
		for (TeacherUser user : userList)
			if (user.getUserName().equals(userName))
				return user;
		return null;
	}

	public boolean updateUser(TeacherUser user)
	{
		TeacherUser pu = null;
		for (int i=0;i<userList.size();i++)
			userList.get(i).getUserName().equals(user.getUserName());
		return false;

	}

	public int addTeacherUser(TeacherUser userInfo)
	{
		userList.add(userInfo);
		return 1;
	}

}
