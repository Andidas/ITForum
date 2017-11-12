package sessionservice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import service.SessionViewService;

public class TestSessionService {
	SessionViewService svs = new SessionViewService();
	@Test
	public void querySessionView(){
		assertEquals(null,svs.querySessionView(""));
		System.out.println(svs.querySessionView("9"));
	}

}
