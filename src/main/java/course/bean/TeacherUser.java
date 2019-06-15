package course.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

public class TeacherUser extends User
{
	@NotNull
	private String name;
	@Pattern(regexp="[男女]$",message="性别只能为男、女")
	private String sex;
	@Range(min=1,max=100,message="超出年龄范围")
	private String age;
	@NotNull
	private String realm;
	@Range(min=0,max=60,message="超出年数范围")
	private String time;//从教年限
	@Range(min=0,max=100,message="超出年龄范围")
	private String agg;//教育合适年龄
	@Pattern(regexp="^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$",message="身份证号码为标准18位")
	private String id;//身份证号码
	@NotNull
	private String info;//简介
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getAge()
	{
		return age;
	}
	public void setAge(String age)
	{
		this.age = age;
	}
	public String getRealm()
	{
		return realm;
	}
	public void setRealm(String realm)
	{
		this.realm = realm;
	}
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	public String getAgg()
	{
		return agg;
	}
	public void setAgg(String agg)
	{
		this.agg = agg;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getInfo()
	{
		return info;
	}
	public void setInfo(String info)
	{
		this.info = info;
	}
}
