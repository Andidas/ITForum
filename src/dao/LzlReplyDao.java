package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import entity.LzlReply;

public interface LzlReplyDao {
	
	@Delete("delete from lzl_reply where lid = #{_parameter}")
	public abstract int deleteCommentByLid(int lid);
	
	@Delete("delete from lzl_reply where lid= #{_parameter}")
	int deleteLzlReply(int lid);

	@Select("select * from lzl_reply")
	List<LzlReply> queryAllLzlReply();

	
	void insertLzlReply(LzlReply lzlReply);
	
	@Select("select l.*,uname from lzl_reply l INNER JOIN `user` on l.luid=uid where ${type} = #{id}")
	List<Map<String,Object>> queryLzlReplyByLrid(Map<String,Object> param);
}
