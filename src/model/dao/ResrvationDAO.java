package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.jupiter.api.Test;

import model.dto.Customer;
import model.dto.Reservation;
import util.DBUtil;
import util.DBUtil2;

public class ResrvationDAO {

	@Test
	public static boolean addReservation(Long number,String date) {// throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			con=DBUtil2.getConnection();
			pstmt=con.prepareStatement("select * from reservation where res_date=?");
			pstmt.setString(1, date);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				return false;
			}else {
				em=DBUtil.getEntityManager();
				tx=em.getTransaction();
				tx.begin();
				Reservation reservation = new Reservation();
				Customer customer = em.find(Customer.class, number);
				reservation.setCustomer(customer);
				reservation.setResDate(date);
				em.persist(reservation);
				tx.commit();
				return true;
			}
		} catch (Exception e) {
			
		}finally {
			em.close();
			em=null;
			DBUtil2.close(con, pstmt,rset);
		}
		return false;
		}
	}
