package util;

import java.util.Iterator;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;


public abstract class RegisterTemplate
{
	
	public ModelAndView template(Object user,BindingResult result)
	{
		//校验数据绑定
		BindingCheck(result);
		
		ModelAndView mav = new ModelAndView();		
		
		//调用注册逻辑
		if (registerUser(user))
			succeed(mav);
		else
			fail(mav);
		
		return mav;
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
	abstract protected boolean registerUser(Object user);

	/**
	 * 注册成功时执行的逻辑
	 * @param mav 暴露给子类的ModelAndView
	 */
	protected void succeed(ModelAndView mav)
	{
		setModelAndView(mav,"succeed","注册成功","/login");
	}
	
	/**
	 * 注册失败时执行的逻辑
	 * @param mav 暴露给子类的ModelAndView
	 */
	protected void fail(ModelAndView mav)
	{
		setModelAndView(mav,"fail","注册失败","/register");
	}
	

	/**
	 * 辅助函数，用于设置成功和失败时候的ModelAndView
	 * @param msg 要在页面上显示的消息 
	 * @param url 辅助跳转链接(比如注册成功时可以显示"返回首页"的链接)
	 */
	protected void setModelAndView(ModelAndView mav,String viewName,String msg,String url)
	{
		mav.setViewName(viewName);
		mav.addObject("msg", msg);
		mav.addObject("url", url);
	}
	
}