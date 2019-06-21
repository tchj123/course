package course.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import course.bean.TeacherAuthResult;

@Mapper
public interface TeacherAuthResultDao
{
	@Select("select * from teacherAuthResult")
	public List<TeacherAuthResult> getAllAuthResult();

	// 返回所有正在审核中的用户的用户名
	@Select("select userName from teacherAuthResult")
	public List<String> getAllAuthingUserName();
	
	@Select("select result from teacherAuthResult where userName=#{userName}")
	public String findResultByUserName(String userName);

	@Insert("insert into teacherAuthResult(userName,result)"
			+ "values(#{userName},#{result})")
	public boolean insert(TeacherAuthResult tas);

	@Delete("delete from teacherAuthResult where userName=#{userName}")
	public boolean deleteAuthResultByUserName(String userName);

	@Update("update teacherAuthResult set result where userName=#{userName}")
	public boolean updateAuthResultByUserName(String userName);

}
