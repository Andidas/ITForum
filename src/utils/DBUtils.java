package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ���ݿ����ӹ�����
 * @author 
 */
public class DBUtils {

	public static final String URL = "jdbc:mysql://localhost:3306/itforum";//URL
	public static final String USER = "root";//�������ݿ��û���
	public static final String PASSWORD = "123456";//�������ݿ��û�����
	public static final String DRIVER = "com.mysql.jdbc.Driver";//����
	
	/**
	 * ��ȡ���ݿ�����
	 * @return  ����һ�����õ����ݿ�����
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("��������ʧ�ܣ�");
		}
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			System.out.println("��ȡ����ʧ�ܣ�");
		}
		return conn;
	}
	
	/**
	 * ִ�����ݿ��ѯ
	 * @param sql  ����sql���
	 * @param params  ��������б�
	 * @return  ���ؽ����ResultSet�����Ϊnull���ʾʧ��
	 */
	public static ResultSet doQuery(String sql,Object ...params){
		PreparedStatement psm = null;
		ResultSet rs = null;
		Connection conn = getConnection();
		if(conn == null){
			return null;
		}
		try {
			psm = conn.prepareStatement(sql);
			if(params!=null){
				int index=1;
				for(Object param : params){
					psm.setObject(index++, param);
				}
			}
			rs = psm.executeQuery();
		} catch (SQLException e) {
			System.out.println("ִ�в�ѯ�쳣��");
		}
		return rs;
	}
	
	//alt+shift+J
	/**
	 * ִ�и������
	 * @param sql  ����sql���
	 * @param params  ��������б�
	 * @return  ���ر����µ����������������0���ʾʧ�ܡ�
	 */
	public static int doUpdate(String sql,Object...params){
		PreparedStatement psm = null;
		int rows = 0;		
		Connection conn = getConnection();
		if(conn == null){
			return 0;
		}
		try {
			psm = conn.prepareStatement(sql);
			if(params!=null){
				int index=1;
				for(Object param : params){
					psm.setObject(index++, param);
				}
			}
			rows = psm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ִ�и����쳣��");
		}finally{
			close(conn,psm,null);
		}
		return rows;
	}
	
	/**
	 * ִ�йر����Ӳ���
	 * @param conn  ���ݿ����Ӷ���
	 * @param sm   ���ݿ�ִ��������
	 * @param rs   ���ݿ���������
	 */
	public static void close(Connection conn,Statement sm,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
			if(sm!=null){
				sm.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("�ر�����ʧ�ܣ�");
		}
	}

}
