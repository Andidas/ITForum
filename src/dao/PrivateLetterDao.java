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
	 * ������������
	 * @param letters
	 */
	void batchAdd(List<PrivateLetter> letters);
	
	/**
	 * ����ɾ��
	 * @param ids
	 */
	void batchDelete(List<Integer> ids);
	
	/**
	 * ��ҳ��ѯ�ҵ���Ϣ�б� 
	 * @param pageParam
	 * @return
	 */
	List<Map<String,Object>> queryMyPrivateLetterList(PageParam pageParam);
	
	/**
	 * ��Ϣ�б����ݵ�����
	 * @param id �û�id
	 * @return
	 */
	int queryMyPrivateLetterList_count(int id);
	
	/**
	 * ��ҳ��ѯ�ҵ�˽���б�����
	 * @param param 
	 * @return
	 */
	List<Map<String,Object>> queryMyPrivateLetterList_detail(PageParam pageParam);
}
