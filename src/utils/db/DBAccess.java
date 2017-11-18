package utils.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBAccess {
	public SqlSession getSqlSession() throws IOException{
		//ͨ�������ļ�������ݿ�������Ϣ
		Reader reader = Resources.getResourceAsReader("config/Configuration.xml");
		//ͨ��������Ϣ����һ��SqlSessionFactory
		SqlSessionFactory sqlSessionFactory  =new SqlSessionFactoryBuilder().build(reader);
		//ͨ��SqlSessionFactory��һ�����ݿ�Ự
		SqlSession sqlSessino = sqlSessionFactory.openSession();
		return sqlSessino;
	}
}
