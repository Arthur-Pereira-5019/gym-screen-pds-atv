package pds_atv_tela_sistema_academia;

import java.io.IOException;

public class ValidarUsuario {
	
	public static boolean validar(String validar, String senha) {
		if(senha == Leitor.getSenha("users/"+validar)) {
			return true;
		}
		return false;
	}

}
