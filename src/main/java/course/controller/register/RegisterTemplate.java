package course.controller.register;

import java.util.Iterator;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户注册通用模板类。
 * @author tchj
 *
 */
public abstract class RegisterTemplate
{
	
	public int register(Object user,BindingResult result)
	{
		//校验数据绑定
		if(result!=null)
			BindingCheck(result);	
		return registerUser(user);

	}
	
	/**
	 * 对数据绑定结果进行处理
	 * @param result
	 */
	protected void BindingCheck(BindingResult result)
	{
		if (result.hasErrors())
		{
			Iterator<ObjectError> it = result.getAllErrors().iterator();
			while (it.hasNext())
				System.out.println(it.next().getDefaultMessage());
			throw new RuntimeException("数据绑定错误");
		}
	}
	
	/**
	 * 调用注册用户的功能，子类必须给出相应实现。 
	 */
	abstract protected int registerUser(Object user);


	
}