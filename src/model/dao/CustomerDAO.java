package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.dto.Customer;
import util.DBUtil;
import util.DBUtil2;

public class CustomerDAO {
	
	
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
}
