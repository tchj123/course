package course.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import course.bean.TeacherUser;
import course.service.AdminService;
import util.PageHolder;

/**
 * 权限审核控制器
 * @author tchj
 *
 */
@Controller
@RequestMapping("/admin")
public class TeacherAuthController
{
	@Autowired
	private AdminService as;

	/**
	 * TODO 变成线程安全类
	 */
	private PageHolder<TeacherUser> ph;
	private List<TeacherUser> teacherUserList;

	@RequestMapping("/authList")
	@ResponseBody
	public Map<String, Object> authList(Integer onePageNumber)
	{
		Map<String, Object> ret = new HashMap<>();

		// 取得待授权的用户列表
		teacherUserList = as.getAuthList();

		// 初始化分页容器
		if(onePageNumber==null)
			onePageNumber=5;
		ph = new PageHolder<>(teacherUserList,onePageNumber);

		// 添加一页的数据数量(每个分页有多少个数据)
		ret.put("onePageNumber", ph.getOnePageNumber());

		// 添加当前页码
		ret.put("currentPage", ph.getCurrentPage());

		// 添加总页码
		ret.put("totalPage", ph.getTotalPage());

		// 添加第一页数据
		ret.put("teacherUserList", ph.currentPage());

		return ret;

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

	/**
	 * 用户通过权限审核
	 * @param userName
	 * @return
	 */
	@RequestMapping("/authPass")
	@ResponseBody()
	public Map<String, Object> authPass(@RequestParam(required=true)String userName)
	{
		if(as.authPass(userName))
			return authList(null);
		else 
			return null;
	}

	@RequestMapping("/authReject")
	@ResponseBody()
	public Map<String, Object> authReject(@RequestParam(required=true)String userName)
	{
		if(as.authReject(userName))
			return authList(null);
		else 
			return null;
	}
	
	/**
	 * 获取用户的详细信息
	 * @param userName
	 * @return
	 */
	@RequestMapping("/detailInfo")
	public TeacherUser detailInfo(@RequestParam(required = true) String userName)
	{
		for (TeacherUser it : teacherUserList)
			if (it.getUserName().equals(userName))
				return it;
		return null;
	}
}
