package model.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.dto.Customer;
import model.dto.Reservation;
import util.DBUtil;

public class ResrvationDAO {
	
	public static void addReservation(String date,Customer customer) throws SQLException{
		
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			Reservation reservation = new Reservation();
			reservation.setDate(date);
			reservation.setCustomer(customer);
			
			em.persist(reservation);
			tx.commit();
		} finally {
			em.close();
			em=null;
		}
	}
}
