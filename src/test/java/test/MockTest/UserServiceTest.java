package test.MockTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.scheduling.support.TaskUtils;
import org.springframework.validation.ObjectError;

import course.bean.ParentUser;
import course.bean.TeacherUser;
import course.bean.User;
import course.dao.MockDao.*;
import course.service.ParentUserService;
import course.service.TeacherUserService;

public class UserServiceTest
{
	private static Validator validator;
	private static ParentUserService pus;
	private static TeacherUserDao tud;
	private static TeacherUserService tus;
	/**
	 * 进行一些初始化工作
	 */
	@BeforeClass
	public static void setUp()
	{
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		tud=new TeacherUserDao();
		pus=new ParentUserService();
		tus=new TeacherUserService();
	}

	/**
	 * 测试用户登陆
	 */
	@Test
	public void tsetLogin()
	{
		
		//测试登陆成功
		assertEquals(2,pus.login("tchj","123456"));
		
		//测试密码错误的登陆
		assertEquals(1,pus.login("tchj","111" ));
		
		//测试用户名不存在的登陆
		assertEquals(0,pus.login("sss", "123"));
		
	}
	
	/**
	 * 测试用户注册
	 */
	@Test
	public void testRegister()
	{
		
		//测试已注册过用户是否能注册
		assertEquals(false,pus.register(new ParentUser("tchj","123456")));
		
		//测试注册用户是否能注册
		assertEquals(true,pus.register(new ParentUser("ycb","123456")));		
		
	}
	
	/**
	 * 校验数据绑定功能
	 */
	@Test
	public void testValidation()
	{ 
		User user=new ParentUser();
		Set<ConstraintViolation<User>> vio=validator.validate(user);
		for(ConstraintViolation c:vio)
			System.out.println(c.getMessage());

	}
	
	/**
	 * 测试修改用户数据
	 */
	@Test
	public void testchangeInfO()
	{
		//测试用户名不存在的情况
		assertEquals(false,pus.changeSelfInfo(new ParentUser("tchj123","123456")));
		
		//测试能否改变密码
		assertEquals(true,pus.changeSelfInfo(new ParentUser("tchj","123")));
		
		/**
		 * TODO 测试能否修改不可变元素
		 */
		
	}
	
	@Test
	public void testTeacherUserDao()
	{
		assertEquals(1,tus.register(new TeacherUser("ycb","123")));
		assertEquals(2, tus.login("ycb","123"));
		
	}
	
	public void testPage()
	{
		
	}
}
