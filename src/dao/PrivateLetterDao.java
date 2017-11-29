package dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import entity.PrivateLetter;

public interface PrivateLetterDao {
	@Select("select * from private_letter")
	List<PrivateLetter> findAll();

	@Insert("insert into private_letter(puid,ptouid,ptime,pcontent) values(#{puid},#{ptouid},#{ptime},#{pcontent})")
	int insertOne(PrivateLetter pletter);

	@Select("select * from private_letter where (puid = #{puid} and ptouid = #{ptouid}) or (puid = #{puid} and ptouid = #{ptouid})order by ptime")
	List<PrivateLetter> queryDialogList(PrivateLetter pletter);
}
