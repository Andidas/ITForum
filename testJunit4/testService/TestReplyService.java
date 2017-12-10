package testService;

import static org.junit.Assert.*;

import org.junit.Test;

import service.ReplyService;
import dao.impl.ReplyDaoImpl;

public class TestReplyService {
	ReplyService rs = new ReplyService();
	@Test
	public void testDeleteReply(){
		assertTrue(rs.deleteReply("16"));
	}
	@Test
	public void testQueryUserAllReply() {
	}

	@Test
	public void testDeleteReplyOne() {
	}

	@Test
	public void testUpdateReplyCountAdd() {
	}

	@Test
	public void testAddReplyOne() {
	}
	@Test public void rownum(){
		System.out.println(new ReplyDaoImpl().UserReplyrowNum(16));
	}

}
