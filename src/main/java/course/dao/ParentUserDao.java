package course.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import course.bean.ParentUser;

@Mapper
public interface ParentUserDao
{

	@Select("select * from parentUser where userName=#{userName}")
	public ParentUser findByUserName(String userName);

	@Update("update parentUser set "
			+ "password=#{password}"
			+ "email=#{email}"
			+ "phone=#{phone}"
			+ "contact=#{contact}"
			+ "age=#{age}"
			+ "childSex=#{childSex}"
			+ "parentName=#{parentName}"
			+ "where userName=#{userName}")
	public int updateUser(ParentUser user);

	@Insert("insert into parentUser (userName,password,email,phone,contact,childName,age,childSex,parentName)"
			+ "values(#{userName},#{password},#{email},#{phone},#{contact},#{childName},#{age},#{childSex},#{parentName})")
	public int insert(ParentUser userInfo);
}
