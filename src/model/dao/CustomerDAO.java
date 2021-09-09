package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.jupiter.api.Test;

import model.dto.Customer;
import util.DBUtil;
import util.DBUtil2;

public class CustomerDAO {
	
	/**
	 * login
	 * @param id
	 * @param pw
	 * @return
	 */
	public static String isMember(String id, String pw){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = DBUtil2.getConnection();
			pstmt = con.prepareStatement("select customer_id from customer where customer_id=? and customer_password=?");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				return rset.getString("customer_id");
			}else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil2.close(con, pstmt, rset);
		}
		return null;
	}
	/**
	 * create customer
	 * @throws SQLException
	 */
//	@Test
	public static boolean addCustomer(Customer customer) throws SQLException{
		
		EntityManager em= DBUtil.getEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		boolean result = false;
		try {
				
				em.persist(customer);
				
				tx.commit();
				System.out.println(customer);
				result = true;
				return result;
		}finally {
			em.close();
			em=null;
		}
	}
	
	/**
	 * select Customernumber
	 * @param id
	 * @return
	 */
//	@Test
	public static long select(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = DBUtil2.getConnection();
			pstmt = con.prepareStatement("select * from customer where customer_id=?");
			pstmt.setString(1, id);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				return rset.getLong("customer_number");
			}else {
				return -1l;
			}
		} catch (Exception e) {
			
		} finally {
			DBUtil2.close(con, pstmt,rset);
		}
		return -1l;
	}
}
