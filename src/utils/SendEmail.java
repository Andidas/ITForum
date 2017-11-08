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
 * @author ��ΰ��
 * ���乤��
 */
public class SendEmail {
	/**
	 * ����9λ��֤��
	 * @return
	 */
	public static String generateCAPTCHA() {
		Double random = Math.random();
		String str = random.toString().substring(2, 11);
		return str;
	}

	/**
	 * ��������
	 * 
	 * @param to �ռ���
	 * @param head ��������
	 * @param content ��������
	 * @throws GeneralSecurityException
	 * @return ���ͳɹ�����true��ʧ�ܷ���false��
	 */
	public static boolean sendEmail(String to, String head, String content)
			throws GeneralSecurityException {
		// �ռ��˵�������
		// String to = "1275179864@qq.com";

		// �����˵�������
		String from = "15880808647@163.com";

		// ָ�������ʼ�������Ϊ smtp.qq.com�������ǣ�smtp.163.com
		String host = "smtp.163.com"; // ���� �ʼ�������

		// ��ȡϵͳ����
		Properties properties = System.getProperties();

		// �����ʼ�������
		properties.setProperty("mail.smtp.host", host);

		// qq�������
		properties.put("mail.smtp.auth", "true");
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.ssl.socketFactory", sf);
		// ��ȡĬ��session����
		Session session = Session.getDefaultInstance(properties,
				new Authenticator() {
					public PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"15880808647@163.com", "LWY163com"); // �������ʼ��û���������
					}
				});

		try {
			// ����Ĭ�ϵ� MimeMessage ����
			MimeMessage message = new MimeMessage(session);

			// Set From: ͷ��ͷ�ֶ�
			message.setFrom(new InternetAddress(from));

			// Set To: ͷ��ͷ�ֶ�
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(
					from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

			// Set Subject: ͷ��ͷ�ֶ�
			message.setSubject(head);

			// ������Ϣ��
			message.setText(content);

			// ������Ϣ
			Transport.send(message);
			System.out.println("Sent message successfully....from runoob.com");
			
		} catch (MessagingException mex) {
			return false;
//			mex.printStackTrace();
		}
		return true;
	}

}