package service.iService;

import java.util.List;
import java.util.Set;

import entity.PageMode;
import entity.PageParam;
import entity.SensitiveWord;

public interface ISensitiveWordService {
	Set<String> findAll();
	/**
	 * 批量插入数据
	 * @param words 敏感词集合
	 */
	boolean batchAdd(List<String> words);	
	/**
	 * 批量删除
	 * @param ids
	 */
	boolean batchDelete(List<Integer> ids);
	
	/**
	 * 分页查询敏感词列表 
	 * @param pageParam
	 * @return
	 */
	PageMode<SensitiveWord> querySensitiveWords(PageParam pageParam);
}
