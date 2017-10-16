package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import utils.DBUtils;
import dao.UserDao;
import entity.User;

/**
 * @author lwy
 *
 */
public class UserDaoImpl implements UserDao {


	@Override
	public int addUser(User user) {
		String sql = "insert into user(uid,uname,upassword,uemail,uregdate) values(NULL,?,?,?,?)";
		return DBUtils.doUpdate(sql, user.getUname(),user.getUpassword(),user.getUemail(),user.getUregdate());
	}

	@Override
	public int delUser(String uemail) {
		String sql="delete from user where uemail = ?";
		return DBUtils.doUpdate(sql, uemail);
	}

	@Override
	public int modifyUser(User user) {
		String sql = "update user set uname=?,upassword=?,ubirthady=?,usex=?, uhead=?,usatement=?,ustate=?,upoint=?,uissectioner=? where uemail =?;";
		return DBUtils.doUpdate(sql, user.getUname(), user.getUpassword(),
				user.getUbirthady(), user.getUsex(), user.getUhead(),
				user.getUsatement(), user.getUstate(), user.getUpoint(),
				user.getUissectioner(), user.getUemail());
	}

	@Override
	public User searchUser(String uemail) {	
		String sql="select * from user where uemail =?";
		 ResultSet rs = DBUtils.doQuery(sql, uemail);
		 User user = null;
		 if(rs!=null){
			 try {
				rs.next();
				user = new User(rs.getInt("uid"),rs.getString("uname"),rs.getString("upassword"),rs.getString("uemail"),
						rs.getString("uregdate"),rs.getString("ubirthady"),rs.getInt("usex"),rs.getString("uhead"),
						rs.getString("usatement"),rs.getInt("ustate"),rs.getInt("upoint"),rs.getInt("uissectioner"));
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					DBUtils.close(rs.getStatement().getConnection(), rs.getStatement(), rs);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		 }else{
			 System.err.println("uemail无效，查找不到数据");
		 }
		return user;
	}

	@Override
	public Vector<Vector<Object>> getUserData() {
		return null;
	}

	@Override
	public Vector<String> getTitles() {
		return null;
	}

}
