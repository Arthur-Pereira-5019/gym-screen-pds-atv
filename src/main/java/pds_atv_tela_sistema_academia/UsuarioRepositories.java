package pds_atv_tela_sistema_academia;

import java.util.Dictionary;

public interface UsuarioRepositories {
	
	public void atualizarUsuario(Usuario usuario);
	public Dictionary<String,String> retornaUsuario(char estrategia, String busca) throws LoginException;
	public void criarUsuario(Usuario usuario);
	

}
