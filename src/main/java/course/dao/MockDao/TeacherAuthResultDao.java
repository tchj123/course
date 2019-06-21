package course.dao.MockDao;

import java.util.LinkedList;
import java.util.List;

import course.bean.TeacherAuthResult;
import course.bean.TeacherUser;

public class TeacherAuthResultDao
{
	List<TeacherAuthResult> list = new LinkedList<>();

	public List<TeacherAuthResult> getAllAuthResult()
	{
		return list;
	}

	// 返回所有正在审核中的用户的用户名
	public List<String> getAllAuthingUserName()
	{
		List<String> ret = new LinkedList<>();
		for (TeacherAuthResult it : list)
			if (it.getResult().equals("Authing"))
				ret.add(it.getUserName());
		return ret;
	}

	public String findResultByUserName(String userName)
	{
		for (TeacherAuthResult it : list)
			if (it.getUserName().equals(userName))
				return it.getResult();
		return null;
	}

	public boolean addTeacherAuthResult(TeacherAuthResult tas)
	{
		list.add(tas);
		return true;
	}

	public boolean deleteAuthResultByUserName(String userName)
	{
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getUserName().equals(userName))
			{
				list.remove(i);
				return true;
			}
		return false;
	}

	public boolean updateAuthResultByUserName(String userName)
	{
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getUserName().equals(userName))
			{
				list.get(i).setResult("reject");
				return true;
			}
		return false;
	}

}
