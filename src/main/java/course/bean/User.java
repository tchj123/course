package course.bean;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


public class User
{
	String userId;
	@NotNull(message="用户名不能为空")
	protected String userName;
	@NotNull(message="密码不能为空")
	protected String password;
	@Email(message="邮箱格式不正确")
	protected String email;
	@NotNull
	protected String phone;
	@NotNull
	protected String contact;// 联系方式

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getContact()
	{
		return contact;
	}

	public void setContact(String contact)
	{
		this.contact = contact;
	}
}

