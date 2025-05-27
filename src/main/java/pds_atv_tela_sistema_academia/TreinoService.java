package pds_atv_tela_sistema_academia;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class TreinoService {
	
	public static void criarTreino(String nomeTreino, String texto) {
		File pastaTreinos = new File("data/treinos");
		File novoTreino = new File(pastaTreinos+"/"+ nomeTreino.toLowerCase().replace("", "_"));
		try {
			novoTreino.createNewFile();
			Escritor.escreverComFile(novoTreino, texto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao criar treino","Erro!",3);
		}
	}

}
