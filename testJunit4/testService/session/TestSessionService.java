package testService.session;

import static org.junit.Assert.*;

import org.junit.Test;

import service.SessionService;
import service.SessionViewService;

public class TestSessionService {
	SessionViewService svs = new SessionViewService();
	SessionService ss = new SessionService();
	@Test
	public void querySessionView(){
		assertEquals(null,svs.querySessionView(""));
		System.out.println(svs.querySessionView("9"));
	}
	@Test
	public void isSearchSession(){
		assertTrue(ss.isSearchSession("[sdfsdfsdf]"));
		assertTrue(ss.isSearchSession("[1]"));
		assertFalse(ss.isSearchSession("sdfsdfsdf]"));
		assertFalse(ss.isSearchSession("]sdfsdfsdf"));
		assertFalse(ss.isSearchSession("]sdfsdfsdf]"));
		assertFalse(ss.isSearchSession("[sdfsdfsdf["));
		assertFalse(ss.isSearchSession(""));
		assertFalse(ss.isSearchSession("[]"));
	}
	@Test
	public void queryAllProfile(){
		System.out.println(ss.queryAllProfile());
	}
}
