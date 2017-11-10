package service.iService;

import entity.PageMode;
import entity.ReplyView;
import entity.TopicView;

public interface ITopicViewService {
	/**
	 * 查询该帖子的reply分页参数，包含所有回帖的视图
	 */
	PageMode<ReplyView> queryReplyViewPageMode(int pageno, int pagesize,int rtid);
	/**
	 * 得到单个topic view
	 */
	TopicView getTopicViewOne(String tid,String sid);
	/**
	 * 得到topic的分页视图
	 */
	PageMode<TopicView> TopicSplitPage(int pageno,int pagesize,int tsid);
	/**
	 * 对上传过来的新帖子内容重新排版，将显示在session的内容之中
	 * 把内容重新排版：
	 * <p>文字内容</p>
	 * <img/><img/><img/>(ps : 最多显示三张图片)
	 * 
	 * @param uname 作者
	 * @param ttopic 帖子题目
	 * @param tcontents 帖子内容
	 * @return 新的排版
	 */
	 String neatenSessionContent(String uname,String ttopic,String tcontents);
	String neatenSessionContentInit(String tcontents);
}
