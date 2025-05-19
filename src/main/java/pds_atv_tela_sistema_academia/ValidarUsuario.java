package pds_atv_tela_sistema_academia;

import java.io.IOException;

public class ValidarUsuario {
	
	public static boolean validar(String validar, String senha) {
		System.out.println(Leitor.getSenha("users/"+validar));
		System.out.println(senha);
		if(senha.equals(Leitor.getSenha("users/"+validar))) {
			return true;
		}
		return false;
	}

}
