package pds_atv_tela_sistema_academia.users;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;

import pds_atv_tela_sistema_academia.services.Leitor;
import pds_atv_tela_sistema_academia.services.LoginException;
import pds_atv_tela_sistema_academia.services.PopupsService;

public class Usuario {
	
	private PopupsService popups = new PopupsService();
	private UsuarioSQLRepository uP = new UsuarioSQLRepository();
	private String nome;
	private int exp;
	private String endereco;
	private char genero;
	private String senha;
	private int matricula;
	
	
	public Usuario(String nome, int exp, String endereco, char genero, String senha, int matricula) {
		super();
		this.nome = nome;
		this.exp = exp;
		this.endereco = endereco;
		this.genero = genero;
		this.senha = senha;
		this.matricula = matricula;
	}
	
	public Usuario(String nome, int exp, String endereco, char genero, String senha) {
		super();
		this.nome = nome;
		this.exp = exp;
		this.endereco = endereco;
		this.genero = genero;
		this.senha = senha;
		this.matricula = Leitor.numeroUsuariosMatriculados();
	}
	
	public Usuario() {
		
	}
	
	public void construirComDicionario(Dictionary<String,String> dados) {
		this.nome = dados.get("NOM");
		this.exp = Integer.parseInt(dados.get("EXP"));
		this.endereco = dados.get("END");
		this.genero = dados.get("GEN").charAt(0);
		this.senha = dados.get("SEN");
		this.matricula = Integer.parseInt(dados.get("MAT"));
		
	}


	
	public void atualizarUsuario() {
		uP.atualizarUsuario(this);
	}
	
	public void criarUsuario() {
		uP.criarUsuario(this);
	}
	
	public boolean validar(String validar, String senha) {
		if(senha.equals(Leitor.getSenha(validar))) {
			return true;
		}
		return false;
	}

		
		public File buscarUsuario(String nome) {
			ArrayList<File> listaDeUsuarios = new ArrayList<File>();
			listaDeUsuarios.addAll(Arrays.asList(new File("data/users").listFiles()));
			for (File usuario : listaDeUsuarios) {
				if(Leitor.getNome(usuario.getName().replace(".txt", "")).equals(nome)) {
					return usuario;
				}
			}
			popups.mostrarErro("Usuário não encontrado!");
			return null;
		}
		
		public void logar(String validar, String senha) throws LoginException{
			if (validar(validar,senha)) {
				construirComDicionario(uP.retornaUsuario('N', validar));
			}
		}
		

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getExp() {
			return exp;
		}

		public void setExp(int exp) {
			this.exp = exp;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		public char getGenero() {
			return genero;
		}

		public void setGenero(char genero) {
			this.genero = genero;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public int getMatricula() {
			return matricula;
		}

		public void setMatricula(int matricula) {
			this.matricula = matricula;
		}
		
		
	}
	


