package userTest;


import org.junit.Test;

import service.TopicServic;

public class TestTopic {

	@Test
	public void test() {
		TopicServic ts = new TopicServic();
		ts.addUser("JAVA", "��ΰ��", "����˭��", "aha,���Ǵ��");
	}

}
