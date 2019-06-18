package course.bean;

public class TeacherAuthResult
{

	private String userName;
	private String result;

	public TeacherAuthResult()
	{
	}

	public TeacherAuthResult(String userName, String result)
	{
		this.userName = userName;
		this.result = result;
	}
	
	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}

}
