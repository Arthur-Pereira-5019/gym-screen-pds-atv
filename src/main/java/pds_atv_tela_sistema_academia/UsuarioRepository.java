package pds_atv_tela_sistema_academia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class UsuarioRepository {
	
	Usuario usuario;
	PopupsService popups = new PopupsService();
		
		public void atualizarUsuario(Usuario usuario) {
			this.usuario = usuario;
			String nome = usuario.getNome();
			String endereco = usuario.getEndereco();
			String senha = usuario.getSenha();
			
			if(nome.length() > 4 && endereco.length() > 4 && senha.length() > 4) {
				arquivoUsuario();
			}else {
				popups.mostrarErro("Os campos estão demasiadamente pequenos!");
			}
		}
		 
		private void arquivoUsuario() {
			String nome = usuario.getNome();
			String endereco = usuario.getEndereco();
			char genero = usuario.getGenero();
			String senha = usuario.getSenha();
			int exp = usuario.getExp();
			
			String textoUsuario = "NOM:"+nome+";\nEND:"+endereco+";\nGEN:"+genero+";\nEXP:"+exp+";\nSEN:"+senha+";\n";
			escrever(textoUsuario);
		}
		
		private void escrever(String texto) {
			
			File arquivoUsuario = new File("data/users/"+usuario.getMatricula()+".txt");
			if(!arquivoUsuario.exists()) {
				try {
					arquivoUsuario.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
					popups.mostrarErro("Erro ao criar novo usuário!");
				}
			}
			
			Escritor.escreverComFile(arquivoUsuario, texto);
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
		
		public Usuario retornaUsuario(char estrategia,String busca) {
			File usuarioAchado;
			Usuario novoUsuario;
			if(estrategia == 'N') {
				usuarioAchado = buscarUsuario(busca);
			}
			novoUsuario = new Usuario();
			return novoUsuario;
		}

}
