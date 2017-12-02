package testService;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entity.PageParam;
import service.PrivateLetterService;

public class TestPrivateLetter {
	PrivateLetterService pls = new PrivateLetterService();
	
	@Test 
	public void testInsertOne(){
		assertTrue(pls.batchAdd("16", "32",1, "你是？"));
		assertTrue(pls.batchAdd("31", "16",1, "我是程序员"));
		assertFalse(pls.batchAdd("30", "30",1, "you too"));
	}
	
	@Test 
	public void testFindAll(){
		System.out.println(pls.findAll());
	}
	@Test 
	public void testBatchDelete(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(36);
		ids.add(37);
		assertTrue(pls.batchDelete(ids));
	}
	@Test
	public void testQueryMyPrivateLetterList(){
		PageParam pp = new PageParam(1,10,16);
		System.out.println(pls.queryMyPrivateLetterList(pp));
	}
	@Test
	public void testQueryMyPrivateLetterList_detail(){
		PageParam pp = new PageParam(1,10,16,31);
		System.out.println(pls.queryMyPrivateLetterList_detail(pp));
	}
	
}
