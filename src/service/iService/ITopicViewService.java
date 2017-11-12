package service.iService;

import java.util.List;

import entity.PageMode;
import entity.viewEntity.ReplyView;
import entity.viewEntity.TopicView;

public interface ITopicViewService {
	
	/**
	 * 获得图像的src 
	 * @param tcontents
	 * @return
	 */
	List<String> getImageAndContent(String tcontents);
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
	 * @param pageno 第几页
	 * @param pagesize 一页需要几条数据
	 * @param tsid 
	 * @return
	 */
	PageMode<TopicView> TopicSplitPage(int pageno,int pagesize,int tsid);
	/**
	 * 对上传过来的新帖子内容重新排版，将显示在session的内容之中
	 * 把内容重新排版：
	 * <p>文字内容</p>
	 * <img/><img/><img/>(ps : 最多显示三张图片)
	 * 
	 * 重新设置<p></p>里面的内容，把图片隐藏起来
	 *
	 * @param tcontents 帖子内容
	 * @return 新的排版
	 */
	String neatenSessionContentInit(String tcontents);
}
