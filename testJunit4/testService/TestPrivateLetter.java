package testService;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import entity.PageParam;
import service.PrivateLetterService;

public class TestPrivateLetter {
	PrivateLetterService pls = new PrivateLetterService();
	
	@Test
	public void testDeleteFriendsLetter(){
		assertTrue(pls.deleteFriendsLetter("16", "[31,32]"));
	}
	@Test 
	public void testStringToList(){
		String array = "[31,32]";
		System.out.println(pls.StringToList(array));
	}
	@Test 
	public void testInsertOne(){
		assertTrue(pls.batchAdd("16", "32",1, "你好"));
		assertTrue(pls.batchAdd("31", "16",1, "我是程序员"));
		assertFalse(pls.batchAdd("30", "30",1, "you too"));
	}
	@Test
	public void queryUnreadCount(){
		assertTrue(pls.queryUnreadCount(16)>0);
		System.out.println(pls.queryUnreadCount(16));
	}
	
	@Test 
	public void testFindAll(){
		System.out.println(pls.findAll());
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
