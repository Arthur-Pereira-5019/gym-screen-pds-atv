package pds_atv_tela_sistema_academia.users;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;

import pds_atv_tela_sistema_academia.services.Escritor;
import pds_atv_tela_sistema_academia.services.Leitor;
import pds_atv_tela_sistema_academia.services.LoginException;
import pds_atv_tela_sistema_academia.services.PopupsService;

public class UsuarioRepository implements UsuarioRepositories{
	
	Usuario usuario;
	PopupsService popups = new PopupsService();
		
	
	@Override
	public boolean criarUsuario(Usuario usuario) {
		this.usuario = usuario;
		String nome = usuario.getNome();
		String endereco = usuario.getEndereco();
		String senha = usuario.getSenha();
		
		if(nome.length() > 4 && endereco.length() > 4 && senha.length() > 4) {
			arquivoUsuario();
			return true;
		}
		return false;
	}
	
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
		
		
		public File buscarUsuarioMatricula(String matricula) {
			ArrayList<File> listaDeUsuarios = new ArrayList<File>();
			listaDeUsuarios.addAll(Arrays.asList(new File("data/users").listFiles()));
			for (File usuario : listaDeUsuarios) {
				if(usuario.getName().replace(".txt", "").equals(matricula)) {
					return usuario;
				}
			}
			popups.mostrarErro("Usuário não encontraado!");
			return null;
		}
		
		public File buscarUsuarioNome(String nome) {
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
		
		public Dictionary<String,String> retornaUsuario(char estrategia,String busca) throws LoginException{
			File usuarioAchado = null;
			String ref = null;
			if(estrategia == 'N') {
				usuarioAchado = buscarUsuarioMatricula(busca);
				if(usuarioAchado  == null) {
					throw new LoginException("Usuário não encontrado!");
				};
				ref = usuarioAchado.getName().replace(".txt", "");
			}
			return desserializar(ref);
		}
		
		
		
		private Dictionary<String, String> desserializar(Object referencia) {
			Dictionary<String,String> dados = new Hashtable<>();

			String e = referencia.toString();

			dados.put("MAT",e);
			dados.put("NOM",Leitor.getNome(e));
			dados.put("END",Leitor.getEnd(e));
			dados.put("EXP",Leitor.getExp(e).toString());
			dados.put("GEN",Leitor.getGenero(e).toString());
			dados.put("SEN",Leitor.getNome(e));
			
			return dados;
			
		}
		
		public int contar() {
			try {
				return Leitor.lerNumeroFilhos("data/sources");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}

		

}
