package testService;

import org.junit.Test;

import service.ReplyService;

public class TestReply {
	@Test
	public void queryUserAllReply(){
		System.out.println(new ReplyService().queryUserAllReply("16"));
	}
}
