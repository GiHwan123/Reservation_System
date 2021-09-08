package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
 * Connection은 client가 정해진 개수만큼 요청할 경우 반환
 * DataSource는 하나의 객체만 존재하면서 요청이 유입될 경우 Connection 객체 반환
 * 
 * DataSource객체 생성 시점/ DataSource 객체 사용 시점
 * 
 */
public class DBUtil2 {
	private static DataSource ds;

	static {
		try {
			// web server의 설정 정보를 활용 가능하게 해주는 API
			// lookup("java:/comp/env") : java environment 상에 component(재사용 가능한 객체)
			// 자바 실행 환경 내부에 내장된 자원을 검색해서 사용하겠다는 설정
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");

			// jdbc/myoracle 이름으로 되어 있는 자원 사용하겠다는 설정
			// jdbc/myoracle 이름의 자원은 DataSource
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	/*
	 * Statement & ResultSet 객체는 자원 반환시 삭제 Connection 객체는 cp 기능 따라서 반환시 pool 영역으로 재
	 * 반환
	 */
	public static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection con, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
