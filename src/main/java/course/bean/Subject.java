package course.bean;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;


/**
 * 课程信息
 * @author tchj
 *
 */
public class Subject
{
	@NotNull
	private String type;    //课程类型
	@NotNull
	private String area;	//所在地区
	@Range(min=1,max=100,message="超出合理年龄")
	private String age;		//适合上课的孩子年龄
	@Pattern(regexp="[1-9][0-9]{0,}")
	private String price;	//上课费用
	@Valid
	private	List<Course> course;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
}
