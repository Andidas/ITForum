package service;

import java.security.GeneralSecurityException;

import service.iService.IAuthenticateService;
import utils.SendEmail;

/**
 * @author 刘伟艺
 * 验证服务
 */
public class AuthenticateService implements IAuthenticateService{
	
	public String emailCaptcha(String email) {
		String captcha = SendEmail.generateCAPTCHA();//生成验证码
		String to = email;
		String head = "ITForum 注 册 验 证";
		String content =  SendEmail.getContent(captcha);
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