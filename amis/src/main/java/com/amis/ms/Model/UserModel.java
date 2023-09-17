package com.amis.ms.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amis.ms.Bean.UserBean;
import com.amis.ms.Exception.ApplicationException;
import com.amis.ms.Exception.DuplicateRecordException;
import com.amis.ms.Utility.JDBCDataSource;

public class UserModel {

	public Integer nextpk() throws Exception {

		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM USER");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk + 1;
	}
	
	public UserBean findByPk(long pk) throws Exception {

		UserBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USER WHERE id=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setPhoneNo(rs.getString(6));
				bean.setCreatedby(rs.getString(7));
				bean.setModifiedby(rs.getString(8));
				bean.setCreatedatetime(rs.getTimestamp(9));
				bean.setModifieddatetime(rs.getTimestamp(10));
				bean.setRoleid(rs.getLong(11));
				bean.setRolename(rs.getString(12));
				bean.setDepartment(rs.getString(13));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public UserBean Authenticate(String Email, String Password) throws Exception {
		UserBean bean = null;
		Connection conn = null;

		conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM USER WHERE EMAIL =? AND PASSWORD =?");
		ps.setString(1, Email);
		ps.setString(2, Password);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setEmail(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setPhoneNo(rs.getString(6));
			bean.setCreatedby(rs.getString(7));
			bean.setModifiedby(rs.getString(8));
			bean.setCreatedatetime(rs.getTimestamp(9));
			bean.setModifieddatetime(rs.getTimestamp(10));
			bean.setRoleid(rs.getLong(11));
			bean.setRolename(rs.getString(12));
			bean.setDepartment(rs.getString(13));
		}
		return bean;
	}

	public UserBean findByLogin(String login) throws Exception {

		UserBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USER WHERE email=?");
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setPhoneNo(rs.getString(6));
				bean.setCreatedby(rs.getString(7));
				bean.setModifiedby(rs.getString(8));
				bean.setCreatedatetime(rs.getTimestamp(9));
				bean.setModifieddatetime(rs.getTimestamp(10));
				bean.setRoleid(rs.getLong(11));
				bean.setRolename(rs.getString(12));
				bean.setDepartment(rs.getString(13));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bean;
	}
	
	public long add(UserBean bean) throws Exception {
		System.out.println("in add method");
		Connection conn = null;
		int pk = 0;

		UserModel model = new UserModel();
		UserBean existbean = findByLogin(bean.getEmail());
		if (existbean != null) {
			throw new DuplicateRecordException("Login Id already exite");
		}

		try {

			conn = JDBCDataSource.getConnection();
			pk = nextpk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO USER VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setString(2, bean.getFirstName());
			ps.setString(3, bean.getLastName());
			ps.setString(4, bean.getEmail());
			ps.setString(5, bean.getPassword());
			ps.setString(6, bean.getPhoneNo());
			System.out.println("11111111111111111");
			ps.setString(7, bean.getCreatedby());
			ps.setString(8, bean.getModifiedby());
			ps.setTimestamp(9, bean.getCreatedatetime());
			ps.setTimestamp(10, bean.getModifieddatetime());
			System.out.println("222222222222222");
			ps.setLong(11, bean.getRoleid());
			ps.setString(12, bean.getRolename());
			ps.setString(13, bean.getDepartment());
			
			System.out.println("ookkkkk");
			ps.executeUpdate();
			System.out.println("nooooookkkk");
			conn.commit();
			ps.close();
		} catch (Exception e) {
e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e.printStackTrace();
				throw new ApplicationException("Exception : add rollback exception " + e.getMessage());
			}
		} finally {
			JDBCDataSource.closeconnection(conn);
		}
		return pk;
	}

	public List list(String theSearchName) throws Exception {
		System.out.println("in model list");
		ArrayList list = new ArrayList();
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		
			conn = JDBCDataSource.getConnection();
			
			 if (theSearchName != null && theSearchName.trim().length() > 0) {
				 pstmt = conn.prepareStatement("select * from user where lower(firstname) like ? or lower(lastname) like ?");
			 //set params
             String theSearchNameLike = "%" + theSearchName.toLowerCase() + "%";
             pstmt.setString(1, theSearchNameLike);
             pstmt.setString(2, theSearchNameLike);
			 
			 }else {
				 pstmt = conn.prepareStatement("SELECT * from user");
			 }
			 
			 //execute statement
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserBean bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setPhoneNo(rs.getString(6));
				bean.setRolename(rs.getString(12));
				bean.setDepartment(rs.getString(13));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static long delete(long id) {
		int i = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE from USER where id=?");
			stmt.setLong(1, id);
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public long Update(UserBean bean) {

		System.out.println("in model update method");
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"update user set firstName=?, lastName=?, email=?,password=?,phoneNo=?,department=? where id=?");
			ps.setString(1, bean.getFirstName());
			ps.setString(2, bean.getLastName());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getPassword());
			ps.setString(5, bean.getPhoneNo());
			ps.setString(6, bean.getDepartment());
			ps.setLong(7, bean.getId());
			 ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}


	
}
