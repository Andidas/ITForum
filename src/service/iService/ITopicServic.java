package service.iService;
/**
 * @author ��ΰ��
 * ���ӽӿ�
 */
public interface ITopicServic {
	/**
	 * �������
	 * @param sname session����
	 * @param uname �û�����
	 * @param ttopic ��Ŀ
	 * @param tcontents ����
	 * @return ��ӳɹ�����true
	 */
	public boolean addUser(String sname,String uname,String ttopic,String tcontents);
}
