package userTest;

import org.junit.Test;

import service.SessionService;

public class TestSession {

	@Test
	public void test() {
		SessionService ss = new SessionService();
		System.out.println(ss.searchSession("JAVA"));
	}

}
