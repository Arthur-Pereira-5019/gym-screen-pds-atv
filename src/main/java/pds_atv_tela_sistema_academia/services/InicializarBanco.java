package pds_atv_tela_sistema_academia.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class InicializarBanco {
	
	static Connection c = BancoDeDados.getConnection(); 

	public static void inicializarBanco() {
		try {
			ArrayList<PreparedStatement> statements = new ArrayList<>();
			statements.add(c.prepareStatement("drop database gym"));
			statements.add(c.prepareStatement("create database gym"));
			statements.add(c.prepareStatement("create table exercicio (nome varchar(70), grupo varchar(60))"));
			statements.add(c.prepareStatement("create table usuario (nome varchar(120), xp int(1), endereco varchar(120), genero char(1), senha varchar(20), matricula int(12))"));
			
			
			statements.forEach(s -> {
				try {
					s.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
