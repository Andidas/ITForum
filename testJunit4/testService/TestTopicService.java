package testService;

import org.junit.Test;

import dao.impl.TopicDaoImpl;
import entity.PageParam;

public class TestTopicService {

	@Test
	public void test() {
		System.out.println(new TopicDaoImpl().splitPage(new PageParam(1,5)));
	}

}
