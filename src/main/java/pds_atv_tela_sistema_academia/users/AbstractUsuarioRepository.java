package pds_atv_tela_sistema_academia.users;

import java.util.Dictionary;

import pds_atv_tela_sistema_academia.services.LoginException;

public abstract class AbstractUsuarioRepository {
	
	Usuario usuario;
	
	AbstractUsuarioRepository(Usuario usuario) {
		this.usuario = usuario;
	}

	public abstract void atualizarUsuario();
	public abstract Dictionary<String,String> retornaUsuario(char estrategia, String busca) throws LoginException;
	public abstract boolean criarUsuario();
	public abstract int contar();
	public abstract String getSenha(String matricula);

}
