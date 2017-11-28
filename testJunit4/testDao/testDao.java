package testDao;

import static org.junit.Assert.*;

import org.junit.Test;

import service.PrivateLetterService;

public class testDao {
	PrivateLetterService pls = new PrivateLetterService();
	@Test
	public void testSelect(){
		System.out.println(pls.findAll());
	}
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
}
