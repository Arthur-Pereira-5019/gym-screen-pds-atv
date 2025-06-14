package pds_atv_tela_sistema_academia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Usuario {
	
	private PopupsService popups = new PopupsService();
	private UsuarioRepository uP = new UsuarioRepository();
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


	
	public void atualizarUsuario() {
		uP.atualizarUsuario(this);
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
		
		public void logar() {
			
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
	


