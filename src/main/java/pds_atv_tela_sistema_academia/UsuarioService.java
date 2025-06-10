package pds_atv_tela_sistema_academia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class UsuarioService {
	
	private PopupsService popups = new PopupsService();
	
	public void criarUsuario(String nome, int exp, String endereco, char genero, String senha) {
		U
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
		
	}
	


