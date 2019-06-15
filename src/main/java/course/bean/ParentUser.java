package course.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

public class ParentUser extends User
{
	public ParentUser()
	{
	}

	public ParentUser(String userName, String password)
	{
		this.userName=userName;
		this.password=password;
	}

	@NotNull
	private String childName;
	@Range(min=1,max=100,message="超出合理年龄")
	private String age;
	@Pattern(regexp="[男女]$")
	private String childSex;
	@NotNull
	private String parentName;

	public String getChildName()
	{
		return childName;
	}

	public void setChildName(String childName)
	{
		this.childName = childName;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(String age)
	{
		this.age = age;
	}

	public String getChildSex()
	{
		return childSex;
	}

	public void setChildSex(String childSex)
	{
		this.childSex = childSex;
	}

	public String getParentName()
	{
		return parentName;
	}

	public void setParentName(String parentName)
	{
		this.parentName = parentName;
	}
}
