package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import entity.PageParam;
import entity.PrivateLetter;

public interface PrivateLetterDao {
	@Select("select * from private_letter")
	List<PrivateLetter> findAll();

	@Select("select * from private_letter where puid = #{puid} and ptouid = #{ptouid} order by ptime")
	List<PrivateLetter> queryDialogList(PrivateLetter pletter);
	
	/**
	 * ������������
	 * @param letters
	 */
	void batchAdd(List<PrivateLetter> letters);
	
	/**
	 * ����ɾ��
	 * @param ids
	 */
	void batchDelete(List<Integer> ids);
	
	List<Map<String,Object>> queryMyPrivateLetterList(PageParam pageParam);
	
	int queryMyPrivateLetterList_count(int id);
}
