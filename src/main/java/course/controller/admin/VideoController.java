package course.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import course.bean.Video;
import course.service.IndexService;
import util.PageHolder;

@Controller
@RequestMapping("/video")
public class VideoController
{
	@Autowired
	IndexService is;
	PageHolder<Video> ph;
	
	
	@RequestMapping("/videoList")
	@ResponseBody
	public Map<String, Object> videoList(String order)
	{
		Map<String, Object> ret=new HashMap<>();
		List<Video>list = is.getVideoList(order);
		ph=new PageHolder<>(list,10);	
		
		// 添加一页的数据数量(每个分页有多少个数据)
		ret.put("onePageNumber", ph.getOnePageNumber());

		// 添加当前页码
		ret.put("currentPage", ph.getCurrentPage());

		// 添加总页码
		ret.put("totalPage", ph.getTotalPage());

		// 添加第一页数据
		ret.put("list", ph.currentPage());

		return ret;
	}
	
	@RequestMapping("/deleteVideo")
	@ResponseBody
	public int deleteVideo(@RequestParam(required=true)String videoId)
	{
		return is.deleteVideo(videoId);
	}
	@RequestMapping("/previousPage")
	@ResponseBody()
	public List<Video> previousPage()
	{
		return ph.previousPage();
	} 

	@RequestMapping("/nextPage")
	@ResponseBody()
	public List<Video> nextPage()
	{
		return ph.nextPage();
	}

	@RequestMapping("/firstPage")
	@ResponseBody()
	public List<Video> firstPage()
	{
		return ph.firstPage();
	}

	@RequestMapping("/lastPage")
	@ResponseBody()
	public List<Video> lastPage()
	{
		return ph.lastPage();
	}

	@RequestMapping("/jumpToPage")
	@ResponseBody()
	public List<Video> jumpToPage(int toPage)
	{
		return ph.jumpToPage(toPage);
	}

}
