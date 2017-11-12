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
/*主页的topic跳转*/
function topicjumg(obj,tsid) {
			location.href = "Topic?op=toTopic&topicTid="
					+ $(obj).siblings('.topicTid').val() + "&sessionSid="
					+ tsid;
		}