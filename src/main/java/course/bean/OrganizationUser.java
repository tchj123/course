package course.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class OrganizationUser extends User
{
	@NotNull
	private String realm;//教育领域
	@NotNull
	private String id;//标识码
	@NotNull
	private String address;//店面地址
	@Range(min=1,max=100,message="超出合理年龄")
	private String age;//教育合适年龄
	public String getRealm()
	{
		return realm;
	}
	public void setRealm(String realm)
	{
		this.realm = realm;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getAge()
	{
		return age;
	}
	public void setAge(String age)
	{
		this.age = age;
	}
	public String getInfo()
	{
		return info;
	}
	public void setInfo(String info)
	{
		this.info = info;
	}
	private String info;//简介
}
