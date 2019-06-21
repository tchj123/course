package course.dao.MockDao;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import course.bean.Video;

public class VideoDao
{
	List<Video> list;

	public VideoDao()
	{
		list = new LinkedList<>();
	}

	public List<Video> getALLVideoByAsc()
	{
		return list;
	}

	public List<Video> getALLVideoByDesc()
	{
		List<Video> ret = new LinkedList<>();
		ret.addAll(list);
		Collections.reverse(list);
		return list;
	}

	public int deleteByVideoId(String videoId)
	{
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getVideoId().equals(videoId))
			{
				list.remove(i);
				return 1;
			}
		}
		return 0;
	}

}
