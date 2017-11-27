package testService;

import org.junit.Test;

import service.TopicService;
import dao.impl.TopicDaoImpl;
import entity.PageMode;
import entity.PageParam;
import entity.Topic;

public class TestTopicService {

	@Test
	public void test() {
		System.out.println(new TopicDaoImpl().splitPage(new PageParam(1,5)));
	}
	@Test
	public void queryUserAllTopic(){
		PageMode<Topic> ps = new TopicService().queryUserAllTopic(3,10,"16");
		System.out.println(ps.getData().size());
	}
}
