package pds_atv_tela_sistema_academia.treinos;

import java.util.ArrayList;

public class FichaTreino {

	private ArrayList<Exercicio> exercicios = new ArrayList<>();
	
	private Character nome;
	
	private Long idTreino;
	
	private int matricula_usuario;
	
	
	public FichaTreino(ArrayList<Exercicio> exercicios, Character nome, Long idTreino, int matricula_usuario) {
		super();
		this.exercicios = exercicios;
		this.nome = nome;
		this.idTreino = idTreino;
		this.matricula_usuario = matricula_usuario;
	}

	public ArrayList<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(ArrayList<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

	public Character getNome() {
		return nome;
	}

	public void setNome(Character nome) {
		this.nome = nome;
	}

	public Long getIdTreino() {
		return idTreino;
	}

	public void setIdTreino(Long idTreino) {
		this.idTreino = idTreino;
	}

	public int getMatricula_usuario() {
		return matricula_usuario;
	}

	public void setMatricula_usuario(int matricula_usuario) {
		this.matricula_usuario = matricula_usuario;
	}
	
	
	
	
}
