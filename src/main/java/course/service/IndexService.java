package course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import course.bean.Video;
import course.dao.VideoDao;
import util.UserFactory;

@Service
public class IndexService
{
	@Autowired
	VideoDao vd;
	public List<Video> getVideoList(String order)
	{
		if(order.equals("asc"))
			return vd.getALLVideoByAsc();
		else if (order.equals("desc"))
			return vd.getALLVideoByDesc();		
		return null;
	}

	public int deleteVideo(String videoId)
	{
		return vd.deleteByVideoId(videoId);
	}

}
