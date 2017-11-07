$(function(){
		/*session的跳转*/
		$('.sessionName').click(function(){
			location.href="Session?op=toSession&sessionName="+$(this).html();
		});//end sessionName.click
		/*topic的跳转*/
		$('.TopicTName').click(function(){
			location.href="Topic?op=toTopic&TopicTName="+$(this).html();
		});
	});