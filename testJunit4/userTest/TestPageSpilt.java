package userTest;

import org.junit.Test;

import dao.impl.TopicDaoImpl;
import entity.PageMode;
import entity.PageParam;
import entity.Topic;

public class TestPageSpilt {

	@Test
	public void rowCount() {
		int num = new TopicDaoImpl().rowCount(9);
		System.out.println(num);
	}
	@Test
	public void splitPage(){
		PageParam pp = new PageParam(1,5,9);
		PageMode<Topic> pm =  new TopicDaoImpl().splitPage(pp);
		System.out.println(pm);
	}
}
