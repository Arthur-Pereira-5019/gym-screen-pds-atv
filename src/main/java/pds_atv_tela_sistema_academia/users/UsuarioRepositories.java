package pds_atv_tela_sistema_academia.users;

import java.util.Dictionary;

import pds_atv_tela_sistema_academia.services.LoginException;

public interface UsuarioRepositories {
	
	public void atualizarUsuario(Usuario usuario);
	public Dictionary<String,String> retornaUsuario(char estrategia, String busca) throws LoginException;
	public void criarUsuario(Usuario usuario);
	

}
