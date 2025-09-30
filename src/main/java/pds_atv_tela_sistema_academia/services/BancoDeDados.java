package pds_atv_tela_sistema_academia.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

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
					migrate();
				} catch (SQLException e) {
					System.err.print("Could not create the database!");
				}
			}
		} catch (SQLException e) {
			System.err.print("Could not create the database!");
		}
		return con;
	}
	
	public static void migrate() {
		//create table usuarios(nome varchar(70), genero char(1), endereco varchar(70), xp int(1), senha varchar(16), matricula varchar(6))
		//create table exercicios(nomeTreino varchar(80), grupo varchar(50))
		ArrayList<String> instructions = new ArrayList<>();
		instructions.add("create table usuarios(nome varchar(70), genero char(1), endereco varchar(70), xp int(1), senha varchar(16), matricula varchar(6))");
		instructions.add("create table exercicios(nomeTreino varchar(80), grupo varchar(50))");
		instructions.add("create table fichaTreino (id_treino int, nomeFicha )");
		
		ArrayList<PreparedStatement> statements = new ArrayList<>();
		instructions.forEach(i -> {
			try {
				statements.add(con.prepareStatement(i));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			}
		});
		statements.forEach(i -> {
			try {
				i.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

}
