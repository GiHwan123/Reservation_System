package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.dto.Customer;
import model.dto.Reservation;
import util.DBUtil;
import util.DBUtil2;

public class ReservationDAO {

	/**
	 * Make reservation
	 * @param number
	 * @param date
	 * @return
	 */
//	@Test
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
			em=DBUtil.getEntityManager();
			tx=em.getTransaction();
			tx.begin();
			if(rset.next()) {
				return false;
			}else {
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
	
	/**
	 * delete Reservation
	 * @param number
	 * @param date
	 * @return
	 */
	public static boolean deleteReservation(Long number,String date) {// throws SQLException {
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
			em=DBUtil.getEntityManager();
			tx=em.getTransaction();
			tx.begin();
			if(rset.next()) {
				em.remove(em.find(Reservation.class, number));
				tx.commit();
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			
		}finally {
			em.close();
			em=null;
			DBUtil2.close(con, pstmt,rset);
		}
		return false;
		}
	
	
	public static ArrayList<Reservation> selectAllReservation(Long number){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Reservation> all = new ArrayList<>();
		try {
			con=DBUtil2.getConnection();
			pstmt=con.prepareStatement("select * from reservation where customer_number=?");
			pstmt.setLong(1, number);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				all.add(new Reservation(rset.getLong("reservation_number"),rset.getString("res_date")));
			}
			return all;
		}catch (SQLException e){
			
		}finally {
			DBUtil2.close(con, pstmt,rset);
		}
		return null;
	}
	}
