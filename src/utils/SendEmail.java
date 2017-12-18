package utils;

import java.security.GeneralSecurityException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * @author lwy
 * 邮箱工具
 */
public class SendEmail {
	/**
	 * 生成6位验证码
	 * @return
	 */
	public static String generateCAPTCHA() {
		Double random = Math.random();
		String str = random.toString().substring(2, 8);
		return str;
	}

	/**
	 * 发送邮箱
	 * 
	 * @param to 收件人电子邮箱
	 * @param head 邮箱主题
	 * @param content 邮箱内容
	 * @throws GeneralSecurityException
	 * @return 发送成功返回true，失败返回false；
	 */
	public static boolean sendEmail(String to, String head, String content)
			throws GeneralSecurityException {

		// 发件人电子邮箱
		String from = "15880808647@163.com";

		// 指定发送邮件的主机为 smtp.qq.com，网易是：smtp.163.com
		String host = "smtp.163.com"; // 网易 邮件服务器

		// 获取系统属性
		Properties properties = System.getProperties();

		// 设置邮件服务器
		properties.setProperty("mail.smtp.host", host);

		// qq密码加密
		properties.put("mail.smtp.auth", "true");
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.ssl.socketFactory", sf);
		// 获取默认session对象
		Session session = Session.getDefaultInstance(properties,
				new Authenticator() {
					public PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"15880808647@163.com", "LWY163com"); // 发件人邮件用户名、密码
					}
				});

		try {
			// 创建默认的 MimeMessage 对象
			MimeMessage message = new MimeMessage(session);

			// Set From: 头部头字段
			message.setFrom(new InternetAddress(from));

			// Set To: 头部头字段
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(
					from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

			// Set Subject: 头部头字段
			message.setSubject(head);

			// 设置消息体
			message.setContent(content,"text/html;charset=UTF-8");

			// 发送消息
			Transport.send(message);
			System.out.println("Sent message successfully....from runoob.com");
			
		} catch (MessagingException mex) {
			mex.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 生成html内容
	 * 以下字符串拼接效率比StringBuilder来得快
	 * @param captcha 验证码
	 * @return 内容
	 */
	public static String getContent(String captcha){
		String content = "<!DOCTYPE html>"
			+"<html>"
			+"	<head>"
				+"	<meta charset='UTF-8'>"
					+"<title></title>"
				+"</head>"
					+"<style>"
						+".qmbox .contant {border: 1px solid #d0d2d1;box-shadow: 0px 0px 4px #D0D1D3;width: 850px;margin: 0 auto auto 10px;margin-bottom: 10px;background-color: #ffffff;padding-bottom: 20px;}"
						+".qmbox * {margin: 0;border: 0;padding: 0;}"
						+".qmbox .qy-tit {border-bottom: 1px solid #EDEFF1;margin-bottom: 20px;margin-left: 24px;	margin-right: 24px;	margin-top: 20px;}"
						+".qmbox .qy-tit h2 {	font-size: 18px;font-family: Microsoft YaHei;width: 670px;margin-top: 20px;}"
						+".qmbox .fl {float: left;}"
						+".qmbox a {text-decoration: none;}"
						+".qmbox img {background: #42474e;margin-top: 20px;margin-bottom: 20px;vertical-align: middle;}"
						+".qmbox .notice-bg {	background: url(http://r.photo.store.qq.com/psb?/V11EVcJ629kdss/8M8PctP.HJLYEMiJnqwfnzepvOqHdI*sXj5w3p2Nng8!/r/dPMAAAAAAAAA) repeat-y;	margin-left: 24px;}"
						+".qmbox .notice-did {margin-left: 345px;margin-top: 60px;padding-bottom:60px;}"
						+".qmbox style, .qmbox script, .qmbox head,	.qmbox link, .qmbox meta {display: none !important;}"
						+".qm_con_body_content {height: auto;min-height: 100px;_height: 100px;word-wrap: break-word;font-size: 14px;font-family: 'lucida Grande', Verdana, 'Microsoft YaHei';}"
						+".qmbox .qy-notice {font-size: 14px;}"
						+".qmbox .qy-notice {min-height: 316px;_height: 316px;background: url(http://r.photo.store.qq.com/psb?/V11EVcJ629kdss/JhqQlFDKYMevGdx1M1oKUXOJYvOmCCS2PZZPF0HjGbY!/r/dPMAAAAAAAAA) no-repeat;line-height: 25px;padding-top: 40px;padding-left: 35px;padding-right: 55px;}"
					+"</style>"
				+"<body>"
					+"<div class='qmbox '>"
						+"<div class='contant'>"
							+"<div class='notice-tran'>"
								+"<div class='qy-tit'><h2 class='fl'><span>ITForum 邮箱验证</span></h2><div class='clearfix'></div></div>"
								+"<div class='notice-bg'>"
									+"<div class='qy-notice'><p class='Tindent' id='Tindent'></p>"
										+"<div><div>"
											+"	<div>您好，</div>"
												+"<div>您当前在 ITFORUM 论坛进行注册。</div>"
												+"<div>如果不是您本人的操作，请勿把验证码给别人，以免泄露信息</div>"
												+"<div><br></div>"
												+"<div>您的验证码为：<span style='font-size: 24px; font-family: Calibri, sans-serif; color: rgb(31, 73, 125); background-color: rgb(255, 255, 0);'><a >"
												+captcha
												+"</a></span></div>"
												+"<div><br></div>"
												+"<div><br></div>"
												+"<div>开发人员：刘伟艺</div>"
										+"</div></div>"
									+"<p></p><div class='notice-did'></div></div>"
								+"</div></div></div></div>"
				+"</body></html>";
		
		return content;
		
	} 

}