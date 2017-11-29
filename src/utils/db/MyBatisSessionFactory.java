package utils.db;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//ʵ�ֻ�ȡ���ͷ�mybatis���ݿ����ӵĹ�����
public class MyBatisSessionFactory {
	//���峣��
	private static String CONFIG_FILE_LOCATION="config/Configuration.xml";
	
	//���ǵ��ù������������߳�ִ�С���˷�װ1���̳߳أ���ÿ���̴߳��̳߳��л�ȡ1�����ӡ�
	//1���̶߳�Ӧ1�����ݿ�����,��������ȫ
	//ThreadLocal�����ã���"�߳�"��"��Դ",�����Ͳ�����ֶ���߳�ͬ����Դ�����������ȫ�������ڴ棬��ȡ����ȫ��
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	
	private static InputStream is; //���ڶ�ȡ�����ļ���������
	
	private static SqlSessionFactory fac;//���ڹ��������ӵĹ�����һ��������Ӧ1�����ݿ⡣
	
	//�ڸ���ľ�̬���м��������ļ�����������ȷ��ִֻ��1�Ρ�
	static
	{
		try {
			is = Resources.getResourceAsStream(CONFIG_FILE_LOCATION);//��ȡ�����ļ�
			fac = new SqlSessionFactoryBuilder().build(is);//ͨ�������ļ�����1�����ӹ���
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	//��ȡ1������
	public static SqlSession getSession()
	{
		SqlSession s  = threadLocal.get(); //���̳߳�Ҫ1������
		if(s==null) //��1��ʱ���ò��������ɹ�����ȡ1�����Ӳ������̳߳�
		{
			s = fac.openSession();//�ɹ�����ȡ1�����Ӳ������̳߳�
			threadLocal.set(s);//�����̳߳�
		}
		return s;
	}
	
	//�ر�����
	public static void closeSession()
	{
		SqlSession s  = threadLocal.get();//���̳߳�Ҫ���̶߳�Ӧ������
		threadLocal.set(null);//�������Ӵ��̳߳������
		if(s!=null)
			s.close();//����ر�����
	}
}
