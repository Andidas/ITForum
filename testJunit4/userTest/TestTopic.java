package userTest;


import org.junit.Test;

import service.TopicServic;

public class TestTopic {

	@Test
	public void test() {
		TopicServic ts = new TopicServic();
		ts.addUser("JAVA", "刘伟艺", "我是谁？", "aha,我是大哥");
	}

}
