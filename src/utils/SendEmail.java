package utils;

import java.security.GeneralSecurityException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
 * @author 刘伟艺
 * 邮箱工具
 */
public class SendEmail {
	/**
	 * 生成9位验证码
	 * @return
	 */
	public static String generateCAPTCHA() {
		Double random = Math.random();
		String str = random.toString().substring(2, 11);
		return str;
	}

	/**
	 * 发送邮箱
	 * 
	 * @param to 收件人
	 * @param head 邮箱主题
	 * @param content 邮箱内容
	 * @throws GeneralSecurityException
	 * @return 发送成功返回true，失败返回false；
	 */
	public static boolean sendEmail(String to, String head, String content)
			throws GeneralSecurityException {
		// 收件人电子邮箱
		// String to = "1275179864@qq.com";

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
			message.setText(content);

			// 发送消息
			Transport.send(message);
			System.out.println("Sent message successfully....from runoob.com");
			
		} catch (MessagingException mex) {
			return false;
//			mex.printStackTrace();
		}
		return true;
	}

}