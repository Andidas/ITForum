package dao;

import java.util.List;

import entity.PrivateLetter;

public interface PrivateLetterDao {
	
	List<PrivateLetter> findAll();
	int insertOne(PrivateLetter pletter);
	List<PrivateLetter> queryDialogList(PrivateLetter pletter);
}	
