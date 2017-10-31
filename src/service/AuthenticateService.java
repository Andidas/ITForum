package service;

import java.security.GeneralSecurityException;

import utils.SendEmail;

/**
 * @author 刘伟艺
 * 验证服务
 */
public class AuthenticateService {
	
	/**
	 * 验证邮箱服务，邮件发送成功就返回：验证码字符串。
	 * 否则返回： null
	 * @param email 收件人邮箱
	 * @return 验证码或null
	 * @throws GeneralSecurityException
	 */
	public String emailCaptcha(String email) {
		String captcha = SendEmail.generateCAPTCHA();//生成验证码
		String to = email;
		String head = "ITForum 注 册 验 证";
		String content = "您好！ 验证码为:" + captcha;
		boolean result = false;
		try {
			result = SendEmail.sendEmail(to, head, content);
			
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		if(result){
			return captcha;
		}else{
			return null;
		}
	}
}
