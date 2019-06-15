package course.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class Comment
{
	@NotNull
	private String type;	//username
	@Range(min=0,max=100,message="超出0-100分数限制")
	private String grade;	//打分数
	private String image;	//图片
	private String description;	//文字描述
	@Range(min=1,max=5,message="星级只能选1-5星整数")
	private String star;	//星级评价
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
