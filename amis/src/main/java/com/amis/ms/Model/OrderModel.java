package com.amis.ms.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amis.ms.Bean.HolidayBean;
import com.amis.ms.Bean.OrderBean;
import com.amis.ms.Exception.ApplicationException;
import com.amis.ms.Utility.JDBCDataSource;

public class OrderModel {

	private static final long Hid = 0;

	public Integer nextpk() throws Exception {

		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM holiday");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public long add(OrderBean bean) throws Exception {
		System.out.println("in add method");
		Connection conn = null;
		int pk = 0;

		try {

			conn = JDBCDataSource.getConnection();
			pk = nextpk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO holiday VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setString(2, bean.getEmpName());
			ps.setString(3, bean.getEmpEmail());
			ps.setString(4, bean.getEmpContactNo());
			ps.setString(5, bean.getLeaveType());
			System.out.println("11111111111111111");
			ps.setDate(6, new java.sql.Date(bean.getLeaveTo().getTime()));
			// ps.setDate(6 ,new java.sql.Date(bean.getLeaveTo().getTime()));
			// ps.setDate(7 ,new java.sql.Date(bean.getLeaveFrom().getTime()));
			System.out.println("nooooookkkk");
			ps.setString(7, bean.getLeavedescription());
			ps.setLong(8, bean.getOrder());
			ps.setLong(9, bean.getItem());
			ps.setLong(10, bean.getQty());
			ps.setString(11, bean.getUom());
			ps.setLong(12, bean.getCode());
			ps.setLong(13, bean.getPrice());
			ps.setLong(14, bean.getAmount());
			ps.setLong(15, bean.getUserid());
			ps.setString(16, bean.getStatus());
			ps.setString(17, bean.getDepartment());
			ps.executeUpdate();

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

	public List list() throws Exception {
		System.out.println("in model Adminlist");
		ArrayList list = new ArrayList();
		try {
			Connection conn = null;
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT * from holiday");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderBean bean = new OrderBean();
				System.out.println("111111in model list");
				bean.setId(rs.getLong(1));
				bean.setEmpName(rs.getString(2));
				bean.setEmpEmail(rs.getString(3));
				bean.setEmpContactNo(rs.getString(4));
				bean.setLeaveType(rs.getString(5));
				System.out.println("222in model list");
				bean.setLeaveTo(rs.getDate(6));
				bean.setLeavedescription(rs.getString(7));
				bean.setOrder(rs.getLong(8));
				bean.setItem(rs.getLong(9));
				bean.setQty(rs.getLong(10));
				bean.setUom(rs.getString(11));
				bean.setCode(rs.getLong(12));
				bean.setPrice(rs.getLong(13));
				bean.setAmount(rs.getLong(14));
				bean.setUserid(rs.getLong(15));
				bean.setStatus(rs.getString(16));
				System.out.println("23333in model list");
				bean.setDepartment(rs.getString(17));
				System.out.println("44444in model list");
				list.add(bean);
				System.out.println("end list");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List Showlist(long userid) throws Exception {
		System.out.println("in model Showlist");
		ArrayList list = new ArrayList();
		try {
			Connection conn = null;
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT * from holiday where userid=?");
			pstmt.setLong(1, userid);
			System.out.println("000000000000000in model list");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderBean bean = new OrderBean();
				System.out.println("111111in model list");
				bean.setId(rs.getLong(1));
				bean.setEmpName(rs.getString(2));
				bean.setEmpEmail(rs.getString(3));
				bean.setEmpContactNo(rs.getString(4));
				bean.setLeaveType(rs.getString(5));
				System.out.println("222in model list");
				bean.setLeaveTo(rs.getDate(6));
				bean.setLeavedescription(rs.getString(7));
				bean.setOrder(rs.getLong(8));
				bean.setItem(rs.getLong(9));
				bean.setQty(rs.getLong(10));
				bean.setUom(rs.getString(11));
				bean.setCode(rs.getLong(12));
				bean.setPrice(rs.getLong(13));
				bean.setAmount(rs.getLong(14));
				bean.setUserid(rs.getLong(15));
				bean.setStatus(rs.getString(16));
				System.out.println("23333in model list");
				bean.setDepartment(rs.getString(17));
				System.out.println("44444in model list");
				list.add(bean);
				System.out.println("end list");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List Managerlist(String department) throws Exception {
		System.out.println("in model Managerlist");
		ArrayList list = new ArrayList();
		try {
			Connection conn = null;
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT * from holiday where department=?");
			pstmt.setString(1, department);
			System.out.println("55555in model list");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				HolidayBean bean = new HolidayBean();
				System.out.println("111111in model list");
				bean.setId(rs.getLong(1));
				bean.setEmpName(rs.getString(2));
				bean.setEmpEmail(rs.getString(3));
				bean.setEmpContactNo(rs.getString(4));
				bean.setLeaveType(rs.getString(5));
				System.out.println("222in model list");
				bean.setLeaveTo(rs.getDate(6));
				bean.setLeaveFrom(rs.getDate(7));
				bean.setLeavedescription(rs.getString(8));
				bean.setUserid(rs.getLong(9));
				bean.setStatus(rs.getString(10));
				System.out.println("23333in model list");
				bean.setDepartment(rs.getString(11));
				System.out.println("44444in model list");
				list.add(bean);
				System.out.println("end list");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	
	public long ApproveUpdate(HolidayBean bean) {
		System.out.println("in model 11111 update method");
		int pk = 0;
		
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update holiday set empName=?,empEmail=?,empContactNo=?,leavetype=?,leaveto=?,leavefrom=?,leaveDescription=?,userid=?, status=?,department=?  where Hid=?");
			ps.setString(1, bean.getEmpName());
			ps.setString(2, bean.getEmpEmail());
			ps.setString(3, bean.getEmpContactNo());
			ps.setString(4, bean.getLeaveType());
			System.out.println("11111111111111111");
			ps.setDate(5, new java.sql.Date(bean.getLeaveTo().getTime()));
			ps.setDate(6, new java.sql.Date(bean.getLeaveFrom().getTime()));
			System.out.println("nooooookkkk");
			ps.setString(7, bean.getLeavedescription());
			ps.setLong(8, bean.getUserid());
			ps.setString(9, bean.getStatus());
			ps.setString(10, bean.getDepartment());
			ps.setLong(11, Hid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}
	
	
	
	
	public long Update(String status, long Hid) {
		System.out.println("in model 11111 update method");
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update holiday set status='" + status + "' where id=?");
			//ps.setString(1, bean.getStatus());
			ps.setLong(1, Hid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}

	public long reject(String status, long Rid) {
		//bean.setStatus("Rejected");
		System.out.println("in model 22222 update method");
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update holiday set status='" + status + "' where id=?");
		//	ps.setString(1, bean.getStatus());
			ps.setLong(1, Rid);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}

	public static long delete(long id) {
		int i = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE from holiday where id=?");
			stmt.setLong(1, id);
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
