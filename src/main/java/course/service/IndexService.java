package course.service;

import java.util.List;

import course.bean.Video;
import course.dao.VideoDao;
import util.UserFactory;


public class IndexService
{
	VideoDao vd=UserFactory.VideoDaoFactory();
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
