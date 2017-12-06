package testService;

import static org.junit.Assert.*;

import org.junit.Test;

import service.FollowService;

public class testFollow {
    FollowService fs =	new FollowService();
	@Test 
	public void queryFollowList(){
		System.out.println(fs.queryFollowList("16"));
	}
	@Test
	public void addFollow(){
		assertTrue("插入数据成功",fs.addFollow("30", "10"));
		assertTrue("是否被关注",fs.isBeFollow("30", "10"));
	}
	@Test
	public void deleteFollow(){
		assertTrue("删除数据成功",fs.deleteFollow("30", "10"));
	}
	@Test 
	public void queryFollowCount(){
		assertEquals("关注人数",fs.queryFollowCount(10),2);
	}
}