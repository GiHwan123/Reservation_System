package model.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.dto.Customer;
import model.dto.Reservation;
import util.DBUtil;

public class ResrvationDAO {

	@Test
	public static boolean addReservation(Customer customer,String date) {// throws SQLException {
		
		EntityManager em = null;
		EntityTransaction tx = null;
		boolean result = false;
		try {
			em = DBUtil.getEntityManager();
			tx = em.getTransaction();
			
			tx.begin();
			Reservation reservation=new Reservation();
			reservation.setResDate(date);
			reservation.setCustomer(customer);
			em.persist(reservation);
			tx.commit();
			result = true;
			return result;
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		return result;
	}
}
