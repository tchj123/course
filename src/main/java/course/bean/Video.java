package course.bean;

import java.util.Date;

public class Video
{
	private String videoId;
	private String url;
	private Date date;
	public Video()
	{
	}

	public Video(String videoId, String url,Date date)
	{
		this.videoId = videoId;
		this.url = url;
		this.date=date;
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

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}
}
