package course.dao;

import java.util.LinkedList;
import java.util.List;

import course.bean.ParentUser;
import course.bean.User;

public class ParentUserDao
{
	private List<ParentUser> userList;

	// 手动注入数据
	public ParentUserDao()
	{
		userList=new LinkedList<ParentUser>();
		userList.add(new ParentUser("tchj", "123456"));
		userList.add(new ParentUser("wzl", "123456"));
		userList.add(new ParentUser("hhh", "123456"));
	}

	public ParentUser findByUserName(String userName)
	{
		for (ParentUser user : userList)
			if (user.getUserName().equals(userName))
				return user;
		return null;
	}

	public boolean updateUser(ParentUser user)
	{
		ParentUser pu = null;
		for (int i=0;i<userList.size();i++)
			userList.get(i).getUserName().equals(user.getUserName());
		return false;

	}

	public boolean register(ParentUser userInfo)
	{
		userList.add(userInfo);
		return true;
	}

}
