package util;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import course.bean.TeacherUser;

/**
 * 分页容器，对List<T>的包装，提供了以“分页”视角使用List的方法。默认每页5个数据
 * @author tchj
 *
 * @param <T>
 */
public class PageHolder<T>
{

	// 一页数据的数量
	private int onePageNumber;

	// 总页数
	private int totalPage;

	// 当前页数
	private int currentPage;

	private List<T> list;
	private int listSize;

	public PageHolder(List<T> list)
	{
		//默认一页数据量为5个
		this(list,5);
	}

	public PageHolder(List<T> list,int onePageNumber)
	{
		this.list = list;
		this.onePageNumber=onePageNumber;
		
		if (list != null &&list.size()!=0)
		{
			listSize = list.size();
			totalPage = listSize / onePageNumber;
			currentPage = 1;
		}
		else 
		{
			listSize=0;
			totalPage=0;
			currentPage=0;
		}
	}

	/**
	 * @return 当前页的内容
	 */
	public List<T> currentPage()
	{
		int fromIndex = (currentPage - 1) * onePageNumber;
		int toIndex=fromIndex + onePageNumber;
		
		return list.subList(fromIndex,toIndex );
	}

	/**
	 * 翻滚到上一页，并且返回相应的内容
	 */
	public List<T> previousPage()
	{
		if (currentPage <= 1)
			return null;
		
		currentPage--;
		
		int fromIndex = currentPage * onePageNumber;
		int toIndex=fromIndex + onePageNumber;
		
		return list.subList(fromIndex, toIndex);
	}

	/**
	 * 翻滚到下一页，并且返回相应页的内容
	 */
	public List<T> nextPage()
	{
		if (currentPage >= totalPage || currentPage < 0)
			return null;
		
		currentPage++;
		
		int fromIndex = (currentPage-1) * onePageNumber;
		int temp=fromIndex + onePageNumber;
		int toIndex =  temp>listSize?listSize:temp;
		
		return list.subList(fromIndex, toIndex);

	}

	/**
	 * 翻滚到首页，并且返回相应页的内容
	 */
	public List<T> firstPage()
	{
		if (listSize == 0)
			return null;
		
		currentPage = 1;
		
		int fromIndex=0;
		int toIndex = onePageNumber>listSize?listSize:onePageNumber ;
		
		return list.subList(fromIndex, toIndex >= listSize ? listSize : toIndex);
	}

	/**
	 * 翻滚到尾页，并且返回相应页的内容
	 */
	public List<T> lastPage()
	{
		if (listSize == 0)
			return null;
		
		currentPage = totalPage;
		
		int fromIndex=(currentPage-1)*onePageNumber;
		int toIndex=listSize;
		
		return list.subList(fromIndex, toIndex);
	}

	/**
	 * 翻滚到指定页，并且返回相应页的内容
	 * 
	 * @param toPage 翻滚到的指定页
	 * @return
	 */
	public List<T> jumpToPage(int toPage)
	{
		if (toPage >= totalPage || toPage <= 0)
			return null;
		
		currentPage = toPage;
		
		int fromIndex = (currentPage-1) * onePageNumber;
		int temp=fromIndex+onePageNumber;
		int toIndex = temp >= listSize ? listSize  : temp;
		
		return list.subList(fromIndex,toIndex );
	}

	public int getOnePageNumber()
	{
		return onePageNumber;
	}

	public int getCurrentPage()
	{
		return currentPage;
	}

	public int getTotalPage()
	{
		return totalPage;
	}
	
	/**
	 * @param teacherUserList 
	 * 
	 */
	public void resetList(List<TeacherUser> teacherUserList)
	{
		
	}


}
