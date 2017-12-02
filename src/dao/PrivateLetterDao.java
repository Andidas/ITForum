package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import entity.PageParam;
import entity.PrivateLetter;

public interface PrivateLetterDao {
	@Select("select * from private_letter")
	List<PrivateLetter> findAll();

		
	/**
	 * 批量插入数据
	 * @param letters
	 */
	void batchAdd(List<PrivateLetter> letters);
	
	/**
	 * 批量删除
	 * @param ids
	 */
	void batchDelete(List<Integer> ids);
	
	/**
	 * 分页查询我的信息列表 
	 * @param pageParam
	 * @return
	 */
	List<Map<String,Object>> queryMyPrivateLetterList(PageParam pageParam);
	
	/**
	 * 信息列表数据的条数
	 * @param id 用户id
	 * @return
	 */
	int queryMyPrivateLetterList_count(int id);
	
	/**
	 * 分页查询我的私信列表详情
	 * @param param 
	 * @return
	 */
	List<Map<String,Object>> queryMyPrivateLetterList_detail(PageParam pageParam);
}
