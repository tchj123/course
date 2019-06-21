
package course.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import course.bean.TeacherUser;

@Mapper
public interface TeacherUserDao
{
	@Select("select * from teacherUser where userName=#{userName}")
	public TeacherUser findByUserName(String userName);

	@Update("update teacherUser set "
			+ "password=#{password}"
			+ "email=#{email}"
			+ "phone=#{phone}"
			+ "contact=#{contact}"
			+ "name=#{name}"
			+ "sex=#{sex}"
			+ "age=#{age}"
			+ "realm=#{realm}"
			+ "time=#{time}"
			+ "id=#{id}"
			+ "info=#{info}"
			+ "where userName=#{userName}")
	public int updateUser(TeacherUser user);

	@Insert("insert into teacherUser(userId,userName,password,email,phone,contact,name,sex,age,realm,time,id,info)"
			+ " values (#{userId},#{userName},#{password},#{email},#{phone},#{contact},#{name},#{sex},#{age},#{realm},#{time},#{id},#{info})")
	public int insert(TeacherUser user);

}
