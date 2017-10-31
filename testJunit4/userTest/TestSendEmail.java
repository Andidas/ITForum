package userTest;

import java.security.GeneralSecurityException;

import org.junit.Test;

import service.AuthenticateService;

public class TestSendEmail {

	@Test
	public void test() throws GeneralSecurityException {
		AuthenticateService as = new AuthenticateService();
		String result = as.emailCaptcha("1275179864@qq.com");
		if(result!=null){
		System.out.println(result);
		}else System.out.print("—È÷§ ß∞‹£¨” œ‰¥ÌŒÛ");
		
	}

}
