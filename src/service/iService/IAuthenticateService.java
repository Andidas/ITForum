package service.iService;

import java.security.GeneralSecurityException;

public interface IAuthenticateService {
	/**
	 * ��֤��������ʼ����ͳɹ��ͷ��أ���֤���ַ�����
	 * ���򷵻أ� null
	 * @param email �ռ�������
	 * @return ��֤���null
	 * @throws GeneralSecurityException
	 */
	public String emailCaptcha(String email);
}
