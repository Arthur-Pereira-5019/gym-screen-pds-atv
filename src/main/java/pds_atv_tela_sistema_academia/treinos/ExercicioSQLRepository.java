package pds_atv_tela_sistema_academia.treinos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pds_atv_tela_sistema_academia.services.BancoDeDados;

public class ExercicioSQLRepository {
	Connection c = BancoDeDados.getConnection();
	
	/*
	public void criarTreino(String nomeTreino, String grupo) {
		Exercicio e = new Exercicio(nomeTreino, grupo);
	}
	*/
	
	public Exercicio salvarExercicio(Exercicio e) {
		String sql = "Insert into gym.exercicios (nomeTreino, grupo) values (?, ?)";
		try {
			PreparedStatement s = c.prepareStatement(sql);
			s.setString(0, sql);
			s.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

}
