package testService;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.LzlReply;
import service.LzlReplyService;

public class TestLzlReplyService {
	LzlReplyService lrs = new LzlReplyService();
	@Test
	public void testDeleteLzlReply() {
		assertTrue(lrs.deleteLzlReply("13"));
	}

	@Test
	public void testQueryAllLzlReply() {
		System.out.println(lrs.queryAllLzlReply());
	}

	@Test
	public void testInsertLzlReply() {
		LzlReply ls = lrs.insertLzlReply("3","16","还不错");
		System.out.println(ls);
	}

	@Test
	public void testQueryLzlReplyByLrid() {
		System.out.println(lrs.queryLzlReplyByLrid("1"));
		
		System.out.println(lrs.queryLzlReplyByLid("14"));
	}

}
