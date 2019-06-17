package util;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

/**
 * 分页显示容器
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
		return list.subList(fromIndex, fromIndex + onePageNumber - 1);
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
		return list.subList(fromIndex, fromIndex + onePageNumber - 1);
	}

	/**
	 * 翻滚到下一页，并且返回相应页的内容
	 */
	public List<T> nextPage()
	{
		if (currentPage >= totalPage || currentPage < 0)
			return null;
		int fromIndex = currentPage * onePageNumber;
		int toIndex = fromIndex + onePageNumber - 1;
		currentPage++;
		return list.subList(fromIndex, toIndex >= listSize ? listSize - 1 : toIndex);

	}

	/**
	 * 翻滚到首页，并且返回相应页的内容
	 */
	public List<T> firstPage()
	{
		if (listSize == 0)
			return null;
		currentPage = 1;
		int toIndex = onePageNumber - 1;
		return list.subList(0, toIndex >= listSize ? listSize - 1 : toIndex);
	}

	/**
	 * 翻滚到尾页，并且返回相应页的内容
	 */
	public List<T> lastPage()
	{
		if (listSize == 0)
			return null;
		currentPage = totalPage;
		return list.subList(totalPage, listSize - 1);
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
		int fromIndex = toPage * onePageNumber;
		int toIndex = toPage * onePageNumber - 1;
		return list.subList(fromIndex, toIndex >= listSize ? listSize - 1 : toIndex);
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



}
