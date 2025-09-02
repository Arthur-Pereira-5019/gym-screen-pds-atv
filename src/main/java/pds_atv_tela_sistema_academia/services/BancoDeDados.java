package pds_atv_tela_sistema_academia.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import pds_atv_tela_sistema_academia.users.Usuario;

public class BancoDeDados {
	private static Connection con;
	private static final String URL = "jdbc:mysql://localhost:3306/gym";
	private static final String USER = "root";
	private static final String PASSWORD = "Art.DB25";
	
	public static Connection getConnection() {
		try {
			if(con == null || con.isClosed() || !con.isValid(100)) {
				try {
					con = DriverManager.getConnection(URL, USER, PASSWORD);
				} catch (SQLException e) {
					System.err.print("Could not create the database!");
				}
			}
		} catch (SQLException e) {
			System.err.print("Could not create the database!");
		}
		return con;
	}

}
