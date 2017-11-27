package testService;

import org.junit.Test;

import dao.impl.TopicDaoImpl;
import entity.PageParam;
import service.TopicService;

public class TestTopicService {

	@Test
	public void test() {
		System.out.println(new TopicDaoImpl().splitPage(new PageParam(1,5)));
	}
	@Test
	public void queryUserAllTopic(){
		System.out.println(new TopicService().queryUserAllTopic(new PageParam(1, 5,16)));
	}
}
