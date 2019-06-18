package util;

import course.dao.TeacherAuthResultDao;
import course.dao.TeacherUserDao;
import course.dao.VideoDao;

public class UserFactory
{
	private static TeacherAuthResultDao tard = new TeacherAuthResultDao();
	private static TeacherUserDao tud = new TeacherUserDao();
	private static VideoDao vd=new VideoDao();

	public static TeacherAuthResultDao teacherAuthResultDaoFactory()
	{
		return tard;
	}

	public static TeacherUserDao teacherUserDaoFactory()
	{
		return tud;
	}

	public static VideoDao VideoDaoFactory()
	{
		return vd;
	}
}
