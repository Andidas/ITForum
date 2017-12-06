package testService;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import entity.PageParam;
import service.SensitiveWordService;

public class TestSensitiveWord {
	private static SensitiveWordService sw = null;
	
	@BeforeClass
	public static void init(){
		sw = new SensitiveWordService();
	}
	
	@Test
	public void testFindAll() {
		System.out.println(sw.findAll());
	}

	@Test
	public void testBatchAdd() {
		
		List<String> lists = new ArrayList<String>();
		lists.add("国名党");
		lists.add("董存润");
		assertFalse(sw.batchAdd(lists));
	}

	@Test
	public void testBatchDelete() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(7);
		ids.add(8);
		assertTrue(sw.batchDelete(ids));
	}

	@Test
	public void testQuerySensitiveWords() {
		PageParam param = new PageParam(1,10);
		System.out.println(sw.querySensitiveWords(param));
	}

}
