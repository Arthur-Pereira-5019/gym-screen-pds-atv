package pds_atv_tela_sistema_academia.treinos;

public class Exercicio {
	String nomeTreino;
	String grupo;

	
	public String getNomeTreino() {
		return nomeTreino;
	}
	public void setNomeTreino(String nomeTreino) {
		this.nomeTreino = nomeTreino;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public Exercicio(String nomeTreino, String grupo) {
		super();
		this.nomeTreino = nomeTreino;
		this.grupo = grupo;
	}
	
	public Exercicio() {
		
	}

}
