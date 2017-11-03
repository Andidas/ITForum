package service.iService;
/**
 * @author 刘伟艺
 * 帖子接口
 */
public interface ITopicServic {
	/**
	 * 添加帖子
	 * @param sname session的名
	 * @param uname 用户的名
	 * @param ttopic 题目
	 * @param tcontents 内容
	 * @return 添加成功返回true
	 */
	public boolean addUser(String sname,String uname,String ttopic,String tcontents);
}
