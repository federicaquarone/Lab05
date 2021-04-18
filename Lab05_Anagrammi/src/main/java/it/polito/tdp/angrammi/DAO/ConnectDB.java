package it.polito.tdp.angrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=Federica";

	public static Connection getConnection() {
		try {
			Connection conn= DriverManager.getConnection(jdbcUrl);
			return conn;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection"+jdbcUrl,e);
		}
		
	}

}
