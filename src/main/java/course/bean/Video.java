package course.bean;

import java.util.Date;

public class Video
{
	private String videoId;
	private String url;
	public Video()
	{
	}

	public Video(String videoId, String url)
	{
		this.videoId = videoId;
		this.url = url;
	}

	public String getVideoId()
	{
		return videoId;
	}

	public void setVideoId(String videoId)
	{
		this.videoId = videoId;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}


}
