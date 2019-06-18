package course.controller.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import course.bean.ParentUser;
import course.bean.TeacherUser;

@Controller
public class TestController
{
	@RequestMapping("/upFile")
	public String showView()
	{
		return "upFile";
	}

	@RequestMapping("/upload") 
	@ResponseBody()
	public String upload(@RequestParam(required=true)MultipartFile file)
	{
		if (file == null)
			{
				System.out.println("null");
				return "fail";
			}
		File f = new File("D:\\" + file.getOriginalFilename());
		try
		{
			file.transferTo(f);
		} catch (IllegalStateException | IOException e)
		{
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}

	@RequestMapping("/test")
	public String test()
	{
		return "test";
	}
}
