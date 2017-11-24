package testService;

import org.junit.Test;

import service.FollowService;

public class testFollow {
	@Test 
	public void queryFollowList(){
		System.out.println(new FollowService().queryFollowList("30"));
	}
}
