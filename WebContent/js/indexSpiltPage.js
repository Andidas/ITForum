
//得到图像数组'<img ...>,<img ...>,<img ...>'
function getImageSrc(content){
	var contentCopy = content;
	var totalImg;
	if(contentCopy.match(eval("/<img/ig"))){
		totalImg= contentCopy.match(eval("/<img/ig")).length;//一共有几张图
	}else{
		totalImg=0;
	}
	var myimg=new Array();//数组对象
	for(var i=0;i<totalImg;i++){
		var begin = contentCopy.indexOf('<img');
		var end = contentCopy.substring(begin).indexOf('>') + begin +1;
		myimg[i] = contentCopy.substring(begin,end);
		contentCopy = contentCopy.substring(end);
		//console.log(' '+i+":"+myimg[i]);
	}
	return myimg;
}
//得到内容，不包含图片
function getMainContents(imgs,content){
	var contentCopy = content;
	var len = imgs.length;
	for(var i =0;i<len;i++){
		contentCopy = contentCopy.replace(imgs[i],'');
	}
	contentCopy = contentCopy.replace('<br>','');
	//console.log('main contents:'+contentCopy);
	return contentCopy;
}
//把图片和文字整合在一起
function neatenContent(imgs,content){
	var lastContent = '<div style="max-height:60px;min-height:20px;">'+content+'</div><div>';
	var len = imgs.length;
	if(len>3)len=3;
	for(var i =0;i<len;i++){
		lastContent = lastContent+imgs[i].replace('style','styleOld').replace('<img','<img width="137" height="137"');
	}
	lastContent =lastContent+'</div>';
	//console.log(lastContent);
	return lastContent;
}
//初始化事件
function clickInit(){
	//下面方法在文件 GotoTopicOrSession.js中
	$('.TopicTName').unbind('click',TopicTName);
	$('.TopicTName').click(TopicTName);
	
	//图片放大器
	PostbirdImgGlass.init({
        domSelector:"#mainContent img",
        animation:true
    });
	//提示框初始化
	new $.Zebra_Tooltips($('.zebra_tips6'),{
		'position': 'right'
	});
	
	
}
