package dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Select;

import entity.PageParam;
import entity.SensitiveWord;

public interface SensitiveWordDao {
	@Select("select word from sensitive_word")
	Set<String> findAll();
	/**
	 * 批量插入数据
	 * @param words 敏感词集合
	 */
	void batchAdd(List<String> words);
	
	/**
	 * 批量删除
	 * @param ids
	 */
	void batchDelete(List<Integer> ids);
	
	/**
	 * 分页查询敏感词列表 
	 * @param pageParam
	 * @return
	 */
	@Select("select wid,word from sensitive_word LIMIT #{pageno},#{pagesize}")
	List<SensitiveWord> querySensitiveWords(PageParam pageParam);
	
	/**
	 * 敏感词总条数
	 * @param 
	 * @return
	 */
	@Select("select COUNT(*) as num from sensitive_word")
	int querySensitiveWordCount();
}
