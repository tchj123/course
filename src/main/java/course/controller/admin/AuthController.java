package course.controller.admin;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import course.bean.TeacherUser;
import course.service.AdminService;
import util.PageHolder;

@Controller
@RequestMapping("/admin")
public class AuthController
{
	private AdminService as;

	private PageHolder<TeacherUser>ph;
	
	@RequestMapping("/authView")
	public ModelAndView getAuthView()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("auth");

		/**
		 * TODO 调用service的方法，取回整个authList
		 */
		List<TeacherUser>teacherUserList = new LinkedList<>();
		ph=new PageHolder<>(teacherUserList);

		//添加一页的数据数量(每个分页有多少个数据)
		mav.addObject("onePageNumber",ph.getOnePageNumber());
		
		// 添加当前页码
		mav.addObject("currentPage", ph.getCurrentPage());

		// 添加总页码
		mav.addObject("totalPage",ph.getTotalPage());

		// 添加第一页数据
		mav.addObject("teacherUserList",ph.currentPage());

		
		return mav;
	}

	@RequestMapping("/previousPage")
	@ResponseBody()
	public List<TeacherUser> previousPage()
	{
		return ph.previousPage();
	}

	@RequestMapping("/nextPage")
	@ResponseBody()
	public List<TeacherUser> nextPage()
	{
		return ph.nextPage();
	}

	@RequestMapping("/firstPage")
	@ResponseBody()
	public List<TeacherUser> firstPage()
	{
		return ph.firstPage();
	}

	@RequestMapping("/lastPage")
	@ResponseBody()
	public List<TeacherUser> lastPage()
	{
		return ph.lastPage();
	}

	@RequestMapping("/jumpToPage")
	@ResponseBody()
	public List<TeacherUser> jumpToPage(int toPage)
	{
		return ph.jumpToPage(toPage);
	}

	@RequestMapping("/authPass")
	@ResponseBody()
	public String authPass(String userName)
	{
		return "success";
	}
}
