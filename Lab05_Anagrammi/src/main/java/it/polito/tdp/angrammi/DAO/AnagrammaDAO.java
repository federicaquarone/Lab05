package it.polito.tdp.angrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {

	/**
	 * Verifico se una string è contenuta nel database
	 */
	
	public boolean isCorrect(String anagram) {
		String sql="SELECT nome FROM parole WHERE nome=?";
		
	   boolean result;
		try {
			Connection  conn= ConnectDB.getConnection();
			PreparedStatement st= conn.prepareStatement(sql);
			st.setString(1, anagram);
			
			ResultSet rs= st.executeQuery();
			
			if(rs.next()) {
				result= true;
			}else {
				result=false;
			}
			conn.close();
			return result;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
