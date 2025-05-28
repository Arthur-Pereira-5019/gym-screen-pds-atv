package pds_atv_tela_sistema_academia;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class TreinoService {
	
	public static void criarTreino(String nomeTreino, String grupo) {
		File pastaTreinos = new File("data/treinos");
		File novoTreino = new File(pastaTreinos+"/"+ nomeTreino.toLowerCase().replace(" ", "_"));
		try {
			novoTreino.createNewFile();
			String textoFinal = "NOM:"+nomeTreino+";\nGRU:"+grupo+";";
			Escritor.escreverComFile(novoTreino, textoFinal);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao criar treino","Erro!",3);
		}
	}

}
