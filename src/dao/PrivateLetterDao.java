package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import entity.PageParam;
import entity.PrivateLetter;

public interface PrivateLetterDao {
	
	/**
	 * 批量删除朋友私信
	 * @param ids
	 * @return
	 */
	void deleteFriendsLetter(Map<String,Object> ids);
	
	@Select("select * from private_letter")
	List<PrivateLetter> findAll();

	/**
	 * 私信状态设置为已读
	 * @param id
	 * @return
	 */
	@Update("update  private_letter set pstatus=2  where user_id = #{user_id} and friend_id = #{friend_id};")
	int evenReaded(Map<String,Object> id);
	
	/**
	 * 标记所有私信为已读
	 * @param uid
	 * @return
	 */
	@Update("update  private_letter set pstatus=2  where user_id = #{_parameter}")
	int updateAllReaded(int uid);
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

	
	@Select("select count(*) as num from private_letter where user_id =#{_parameter} and pstatus = 1")
	int queryUnreadCount(int uid);
}