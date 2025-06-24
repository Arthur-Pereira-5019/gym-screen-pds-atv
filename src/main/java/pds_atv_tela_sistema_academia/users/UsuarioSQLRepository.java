package pds_atv_tela_sistema_academia.users;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Dictionary;
import java.util.Hashtable;

import pds_atv_tela_sistema_academia.services.Leitor;
import pds_atv_tela_sistema_academia.services.LoginException;

public class UsuarioSQLRepository implements UsuarioRepositories {
	Connection con;

	public UsuarioSQLRepository() {
		tryConnect();
	}
	
	@Override
	public void atualizarUsuario(Usuario usuario) {
		

	}

	@Override
	public Dictionary<String, String> retornaUsuario(char estrategia, String busca) throws LoginException {
		String query = null;
		ResultSet resultados = null;
		if(estrategia == 'N') {
			query = "select * from usuarios where matricula = \"" + busca +"\"";
		}
		try {
			Statement statement = con.createStatement();
			resultados = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return desserializar(resultados);
	}
	
	private Dictionary<String, String> desserializar(ResultSet resultados) throws LoginException{
		Dictionary<String,String> dados = new Hashtable<>();
		try {
			resultados.next();
			resultados.toString();
			
			String nomeEncontrado = resultados.getString("nome");
			if(nomeEncontrado == null) {
				nomeEncontrado = "???";
			}
			
			String generoEncontrado = resultados.getString("nome");
			if(generoEncontrado == null) {
				generoEncontrado = "M";
			}
			
			String enderecoEncontrado = resultados.getString("endereco");
			if(enderecoEncontrado == null) {
				enderecoEncontrado = "M";
			}
			
			
			String xpEncontrado = resultados.getString("xp");
			if(xpEncontrado == null) {
				xpEncontrado = "1";
			}
			
			
			String matriculaEncontrada = resultados.getString("matricula");
			if(matriculaEncontrada == null) {
				throw new LoginException();
			}else if (matriculaEncontrada.equals("root")){
				matriculaEncontrada = "-1";
			}
			
			
			String senhaEncontrada = resultados.getString("senha");
			if(senhaEncontrada == null) {
				senhaEncontrada = matriculaEncontrada;
			}
	
			
			dados.put("MAT",matriculaEncontrada);
			dados.put("NOM",nomeEncontrado);
			dados.put("GEN",generoEncontrado);
			dados.put("END",enderecoEncontrado);
			dados.put("EXP",xpEncontrado);
			dados.put("SEN",senhaEncontrada);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dados;
		
	}

	@Override
	public boolean criarUsuario(Usuario usuario) {
		String sql = "INSERT INTO gym.usuarios (nome, genero, endereco, xp, senha, matricula) VALUES (?, ?, ?, ?, ?, ?)";
		//create table usuarios(nome varchar(70), genero char(1), endereco varchar(70), xp int(1), senha varchar(16), matricula varchar(6))
		//insert into usuarios (matricula, senha) values ("root", "root")
		
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, usuario.getEndereco());
			statement.setString(2, Character.toString(usuario.getGenero()));
			statement.setString(3, usuario.getEndereco());
			statement.setLong(4, usuario.getExp());
			statement.setString(5, usuario.getSenha());
			statement.setLong(6, usuario.getMatricula());
			return statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	private void connect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","aluno");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void tryConnect() {
		try {
			if(con == null || con.isClosed() || !con.isValid(100)) {
				connect();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int contar() {
		ResultSet busca;
		try {
			Statement statement = con.createStatement();
			busca = statement.executeQuery("select count(*) from usuarios");
			return busca.getInt("count(*)");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
	}
	
	

}
