package userTest;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import service.TopicService;

public class TestTopic {

	@Test
	public void test() {
		TopicService ts = new TopicService();
		ts.addTopic("JAVA", "��ΰ��", "����˭��", "aha,���Ǵ��");
	}
	@Test
	public void testTransform(){
		String Testcontent = "<p>����<img style='width: 25%;' src='files/classic1.gif' data-filename='image name'></p><p>��˹��<img style='width: 25%;' src='files/text1.png' data-filename='image name'><img style='width: 30px;' src='files/iconx2-000000.png' data-filename='image name'>��˹��</p>";
		String reg = "<img.*'>";
		
		System.out.println(Testcontent.replaceAll(reg, ""));
		
//		String imgInit = Testcontent.substring(Testcontent.indexOf("<img src="));
//		
//		String img = imgInit.substring(0,imgInit.indexOf(">")+1);
//		System.out.println(img);
		
		
	}
	@Test
	public void getImageAndContent(){
		String input = "<p>�ƺ��ҵ�������<img src=\"files/ITForum.jpg\" data-filename=\"image name\" style=\"width: 180px;\"></p>";
	    List<String> src = new TopicService().getImageAndContent(input);
		System.out.println(src);
	}
	@Test
	public void RegexMatches()
	{
		
		String INPUT = "<p>�ƺ��ҵ�������<img src=\"files/ITForum.jpg\" data-filename=\"image name\" style=\"width: 180px;\"></p>";
	      String REGEX = "src=\"\\S*\"";
	 
	       Pattern p = Pattern.compile(REGEX);
	       Matcher m = p.matcher(INPUT); // ��ȡ matcher ����
	       int count = 0;
	 
	       while(m.find()) {
	         count++;
	         System.out.println("Match number "+count);
	         System.out.println("start(): "+m.start());
	         System.out.println("end(): "+m.end());
	         System.out.println(INPUT.substring(m.start(),m.end()+1));
	       }
	       
	       
	       //style='width: 50%; float: right;'
	       String newContentInit = INPUT.replaceAll("style=", "styleOld=");
	       String newContent = newContentInit.replaceAll("<img ", "<img style='display:none;' ");
	       System.out.println("_________________������___________________");
	       System.out.println(newContent);
	}
}
