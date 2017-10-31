package service;

import java.security.GeneralSecurityException;

import service.iService.IAuthenticateService;
import utils.SendEmail;

/**
 * @author ��ΰ��
 * ��֤����
 */
public class AuthenticateService implements IAuthenticateService{
	
	public String emailCaptcha(String email) {
		String captcha = SendEmail.generateCAPTCHA();//������֤��
		String to = email;
		String head = "ITForum ע �� �� ֤";
		String content = "���ã� ��֤��Ϊ:" + captcha;
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
