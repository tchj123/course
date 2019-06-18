package test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.catalina.tribes.membership.cloud.KubernetesMembershipProvider;
import org.apache.taglibs.standard.tei.DeclareTEI;
import org.junit.BeforeClass;
import org.junit.Test;

import course.bean.TeacherUser;
import util.PageHolder;

public class PageTest
{

	private static PageHolder<Integer> ph;
	private static List<Integer> list;

	@BeforeClass
	public static void init()
	{
		list = new LinkedList<>();
		for (int i = 0; i < 30; i++)
			list.add(i);
	}

	/**
	 * TODO 测试集有待完善
	 */
	@Test
	public void test()
	{
		Map<String, Object> map = authList();

		assertEquals(5, map.get("onePageNumber"));
		assertEquals(1, map.get("currentPage"));
		assertEquals(6, map.get("totalPage"));

		List<Integer> list = (List<Integer>) map.get("list");
		assertEquals(5, list.size());
		for (int i = 0, j = 0; i < 5; i++, j++)
			assertEquals(new Integer(j), list.get(i));

		// 测试页的跳转

		list = nextPage();
		assertEquals(5, list.size());
		for (int i = 0, j = 5; i < 5; i++, j++)
			assertEquals(new Integer(j), list.get(i));

		list = jumpToPage(3);
		assertEquals(5, list.size());
		for (int i = 0, j = 10; i < 5; i++, j++)
			assertEquals(new Integer(j), list.get(i));

		list = firstPage();
		assertEquals(5, list.size());
		for (int i = 0, j = 0; i < 5; i++, j++)
			assertEquals(new Integer(j), list.get(i));

		list = lastPage();
		assertEquals(5, list.size());
		for (int i = 0, j = 25; i < 5; i++, j++)
			assertEquals(new Integer(j), list.get(i));

		// 测试删除页中元素

		map = deleteI(3);
		assertEquals(5, map.get("onePageNumber"));
		assertEquals(1, map.get("currentPage"));
		assertEquals(5, map.get("totalPage"));

		list = (List<Integer>) map.get("list");
		assertEquals(5, list.size());
		assertEquals(new Integer(0), list.get(0));
		assertEquals(new Integer(1), list.get(1));
		assertEquals(new Integer(2), list.get(2));
		assertEquals(new Integer(4), list.get(3));
		assertEquals(new Integer(5), list.get(4));

	}

	public Map<String, Object> authList()
	{
		Map<String, Object> ret = new HashMap<>();

		// 初始化分页容器
		ph = new PageHolder<>(list);

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

	public List<Integer> previousPage()
	{
		return ph.previousPage();
	}

	public List<Integer> nextPage()
	{
		return ph.nextPage();
	}

	public List<Integer> firstPage()
	{
		return ph.firstPage();
	}

	public List<Integer> lastPage()
	{
		return ph.lastPage();
	}

	public List<Integer> jumpToPage(int toPage)
	{
		return ph.jumpToPage(toPage);
	}

	public Map<String, Object> deleteI(int i)
	{
		list.remove(i);
		return authList();
	}

	public Map<String, Object> addI(int i)
	{
		list.add(i);
		return authList();
	}
}
