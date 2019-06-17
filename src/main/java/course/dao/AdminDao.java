package course.dao;

import java.util.LinkedList;
import java.util.List;

import course.bean.TeacherUser;

public class AdminDao
{

	private ThreadLocal<List<TeacherUser>> teacherAuthList;

	public void getTeacherAuthList()
	{
		if (teacherAuthList == null)
		{
			teacherAuthList=new ThreadLocal()
			{	

				protected List<TeacherUser> intialValue()
				{
					return new LinkedList<TeacherUser>();
				}
			};
		}
	}
}
