package course.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import course.bean.TeacherAuthResult;
import course.bean.TeacherUser;
import course.dao.TeacherAuthResultDao;
import course.dao.TeacherUserDao;
import util.UserFactory;

@Service
public class AdminService
{
	TeacherAuthResultDao ad=UserFactory.teacherAuthResultDaoFactory();
	TeacherUserDao tud=UserFactory.teacherUserDaoFactory();
	
	public int login(String userName, String password)
	{
		return 0;
	}

	public List<TeacherUser> getAuthList()
	{
		List<TeacherAuthResult> authList=ad.getAllAuthResult();	
		List<TeacherUser> ret =new LinkedList<>();

		//查询出待审核个人教师
		for(TeacherAuthResult it:authList)
			ret.add(tud.findByUserName(it.getUserName()));
		
		return ret;
			
	}
	

	public boolean authPass(String userName)
	{
		return ad.deleteAuthResultByUserName(userName);
	}

	
	public boolean authReject(String userName)
	{
		return ad.updateAuthResultByUserName(userName);
	}

}
