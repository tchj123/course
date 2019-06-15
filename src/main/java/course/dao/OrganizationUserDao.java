
package course.dao;

import java.util.LinkedList;
import java.util.List;

import course.bean.OrganizationUser;
import course.bean.User;

public class OrganizationUserDao
{
	private List<OrganizationUser> userList;

	// 手动注入数据
	public OrganizationUserDao()
	{
		userList=new LinkedList<OrganizationUser>();
		
	}

	public OrganizationUser findByUserName(String userName)
	{
		for (OrganizationUser user : userList)
			if (user.getUserName().equals(userName))
				return user;
		return null;
	}

	public boolean updateUser(OrganizationUser user)
	{
		OrganizationUser pu = null;
		for (int i=0;i<userList.size();i++)
			userList.get(i).getUserName().equals(user.getUserName());
		return false;

	}

	public boolean register(OrganizationUser userInfo)
	{
		userList.add(userInfo);
		return true;
	}

}
