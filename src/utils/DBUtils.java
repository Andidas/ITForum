package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库连接工具类
 * @author 
 */
public class DBUtils {

	public static final String URL = "jdbc:mysql://localhost:3306/itforum";//URL
	public static final String USER = "root";//连接数据库用户名
	public static final String PASSWORD = "123456";//连接数据库用户密码
	public static final String DRIVER = "com.mysql.jdbc.Driver";//驱动
	
	/**
	 * 获取数据库连接
	 * @return  返回一个可用的数据库连接
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败！");
		}
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			System.out.println("获取连接失败！");
		}
		return conn;
	}
	
	/**
	 * 执行数据库查询
	 * @param sql  输入sql语句
	 * @param params  输入参数列表
	 * @return  返回结果集ResultSet，如果为null则表示失败
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
			System.out.println("执行查询异常！");
		}
		return rs;
	}
	
	//alt+shift+J
	/**
	 * 执行更新语句
	 * @param sql  输入sql语句
	 * @param params  输入参数列表
	 * @return  返回被更新的条数，如果不大于0则表示失败。
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
			System.out.println("执行更新异常！");
		}finally{
			close(conn,psm,null);
		}
		return rows;
	}
	
	/**
	 * 执行关闭连接操作
	 * @param conn  数据库连接对象
	 * @param sm   数据库执行器对象
	 * @param rs   数据库结果集对象
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
			System.out.println("关闭连接失败！");
		}
	}

}
