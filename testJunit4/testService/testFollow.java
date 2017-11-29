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
		assertTrue("�������ݳɹ�",fs.addFollow("30", "10"));
		assertTrue("�Ƿ񱻹�ע",fs.isBeFollow("30", "10"));
	}
	@Test
	public void deleteFollow(){
		assertTrue("ɾ�����ݳɹ�",fs.deleteFollow("30", "10"));
	}
	@Test 
	public void queryFollowCount(){
		assertEquals("��ע����",fs.queryFollowCount(10),2);
	}
}
