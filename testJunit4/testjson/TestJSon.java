package testjson;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

import service.TopicViewService;
import entity.PageMode;
import entity.viewEntity.ReplyView;

public class TestJSon {

	private TopicViewService tvs = new TopicViewService();
	@Test
	  public void testBeadToJSON(){
		PageMode<ReplyView> pm = tvs.queryReplyViewPageMode(1, 5, 74);
		 JSONObject jsonObject = JSONObject.fromObject(pm);
	      System.out.println(jsonObject);
        System.out.println(jsonObject.toString() instanceof String);
    }
	@Test
	public void testJsontoObject() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		PageMode<ReplyView> pm = tvs.queryReplyViewPageMode(1, 5, 74);
		JSONObject jsonObject = JSONObject.fromObject(pm);
		Object bean = JSONObject.toBean(jsonObject);
		
		System.out.println(PropertyUtils.getProperty(bean, "data"));
        System.out.println(PropertyUtils.getProperty(bean, "pageParam"));
        System.out.println(PropertyUtils.getProperty(bean, "totalRecordCount"));
        System.out.println(PropertyUtils.getProperty(bean, "totalPageCount"));
	}
}
