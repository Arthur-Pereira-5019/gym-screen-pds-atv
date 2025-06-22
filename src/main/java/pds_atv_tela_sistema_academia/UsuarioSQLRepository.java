package pds_atv_tela_sistema_academia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Dictionary;

public class UsuarioSQLRepository implements UsuarioRepositories {
	Connection con;

	@Override
	public void atualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public Dictionary<String, String> retornaUsuario(char estrategia, String busca) throws LoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void criarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
	
	private void connect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
