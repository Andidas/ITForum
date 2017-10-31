package service.iService;

import java.security.GeneralSecurityException;

public interface IAuthenticateService {
	/**
	 * 验证邮箱服务，邮件发送成功就返回：验证码字符串。
	 * 否则返回： null
	 * @param email 收件人邮箱
	 * @return 验证码或null
	 * @throws GeneralSecurityException
	 */
	public String emailCaptcha(String email);
}
