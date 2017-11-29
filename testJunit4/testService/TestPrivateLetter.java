package testService;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;

import service.PrivateLetterService;

public class TestPrivateLetter {
	PrivateLetterService pls = new PrivateLetterService();
	
	@Test 
	public void testInsertOne(){
		assertTrue(pls.insertOne("16", "30", "NIHAO"));
		assertTrue(pls.insertOne("30", "16", "you too"));
		assertFalse(pls.insertOne("30", "30", "you too"));
	}
	@Test
	public void queryDialogList(){
		System.out.println(pls.queryDialogList("16","30"));
	}
	@Test 
	public void findAll(){
		System.out.println(pls.findAll());
	}
	
}
