package course.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import course.bean.Video;

@Mapper
public interface VideoDao
{
	@Select("select * from video")
	public List<Video> getALLVideoByAsc();
	
	@Select("select * from video order by videoId desc")
	public List<Video> getALLVideoByDesc();

	@Delete("delete from video where videoId=#{videoId}")
	public int deleteByVideoId(String videoId);

}
