package util;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DBUtil {
	
	private static EntityManagerFactory emf;  
	
	static { 
		emf = Persistence.createEntityManagerFactory("step09_webJPA");
	}
	
	public static EntityManager getEntityManager() throws SQLException {
		return emf.createEntityManager();
	}
	
	public static void close() {
		emf.close();
		emf = null;
	}
	
}
