package testService;

import org.junit.Test;

import dao.impl.ReplyDaoImpl;

public class TestReplyService {

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
