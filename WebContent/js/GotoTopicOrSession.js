$(function() {
	/* session的跳转 */
	$('.sessionName').click(sessionName);
	/* topic的跳转 */
	$('.TopicTName').click(TopicTName);
	
});
function sessionName() {
	location.href = "Session?op=toSession&SessionSid="
			+ $(this).siblings('.sessionSid').val();
}
function TopicTName() {
	location.href = "Topic?op=toTopic&topicTid="
			+ $(this).siblings('.topicTid').val() + "&sessionSid="
			+ $('#sessionSid').val();
}
/*跳到用户信息界面*/
function touserjump(uid){
	location.href ="UserInFo?op=toUserInfo&uid="+uid;	
	}
/*主页的topic跳转*/
function topicjumg(obj,tsid) {
			location.href = "Topic?op=toTopic&topicTid="
					+ $(obj).siblings('.topicTid').val() + "&sessionSid="
					+ tsid;
		}
function toTopicJump(tid,tsid){
	location.href = "Topic?op=toTopic&topicTid="
		+ tid + "&sessionSid="
		+ tsid;
}
/*主页的session跳转,用户左侧的导航条*/
function tosessionjump(tsid){
	location.href = "Session?op=toSession&SessionSid=" + tsid;
}

//跳到指定的位置,str='#',那么就是跳到顶部
function jumpEveryWhere(str){
	var myHref = location.href;
	var locate = myHref.indexOf(str);
	if(locate>0){
		myHref = myHref.substring(0,locate);
		location.href = myHref + str;
	}else{
		location.href = myHref + str;
	}
}
//跳转到信息中心
function toInfoCenterjump(uid){
	open("UserInFo?op=toInfoCenter&uid="+uid);
}