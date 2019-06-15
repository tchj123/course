package course.bean;

import javax.validation.constraints.NotNull;

/**
 * 课程安排
 * 
 * @author tchj
 *
 */
public class Course
{
	@NotNull
	private String time;		//上课时间
	@NotNull
	private String location;	//上课地点
	@NotNull
	private String teacher;		//上课老师
	@NotNull
	private String content;		//课程内容
	private String work;		//课后作业
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
}
