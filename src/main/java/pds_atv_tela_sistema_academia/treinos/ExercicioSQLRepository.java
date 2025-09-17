package pds_atv_tela_sistema_academia.treinos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pds_atv_tela_sistema_academia.exceptions.ResourceNotFoundException;
import pds_atv_tela_sistema_academia.services.BancoDeDados;

public class ExercicioSQLRepository {
	Connection c = BancoDeDados.getConnection();
	
	/*
	public void criarTreino(String nomeTreino, String grupo) {
		Exercicio e = new Exercicio(nomeTreino, grupo);
	}
	*/
	
	public Exercicio salvarExercicio(Exercicio e) {
		String sql = "insert into gym.exercicios (nomeTreino, grupo) values (?, ?)";
		try {
			PreparedStatement s = c.prepareStatement(sql);
			s.setString(0, e.getNomeTreino());
			s.setString(1, e.getGrupo());
			s.execute();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}
	
	public void deletarExercicio(String nomeTreino) {
		String sql = "delete from gym.exercicios where nomeTreino = ?";
		try {
			PreparedStatement s = c.prepareStatement(sql);
			s.setString(0, nomeTreino);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Exercicio encontrarExercicio(String nomeExercicio) throws ResourceNotFoundException {
		String sql = "select from gym.exercicios where nomeTreino = ?";
		ResultSet resultSet = null;
		try {
			resultSet = c.prepareStatement(sql).executeQuery();
		} catch(Exception e) {
			e.printStackTrace();
		}
		Exercicio ex = null;
		try {
			resultSet.next();
			ex = new Exercicio();
			ex.setGrupo(resultSet.getString("grupo"));
			ex.setGrupo(resultSet.getString("nomeTreino"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ex == null || ex.nomeTreino.isEmpty() || ex.nomeTreino == null) {
			throw new ResourceNotFoundException("Exercise not found");
		}
		return ex;
	}

}
