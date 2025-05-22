package pds_atv_tela_sistema_academia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class UsuarioController {
	
	
	public static void criarUsuario(String nome, int exp, String endereco, char genero, String senha) {
		if(nome.length() > 4 && endereco.length() > 4 && senha.length() > 4) {
			File novoUsuario = new File("data/users/"+Tela.cadastrados+".txt");
			FileWriter escritor;
			
			try {
				novoUsuario.createNewFile();
				escritor = new FileWriter(novoUsuario);
				escritor.write("NOM:"+nome+";\nEND:"+endereco+";\nGEN:"+genero+";\nEXP:"+exp+";\nSEN:"+senha+";\n");
				escritor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Os campos estão demasiadamente pequenos!", "Erro!", 2);
			
		}
	}
	


}
