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
	
	public static void criarFichaTreino() {
		File pastaFichas = new File("data/fichas");
		File novaFicha = new File(pastaFichas+TelaLogin.loggedUser);
		try {
			novaFicha.createNewFile();
			String textoFicha = "A:[_];B:[_];C:[_];D:[_];E:[_]";
			Escritor.escreverComFile(novaFicha, textoFicha);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void adicionarTreino(char tipoTreino, String ficha) {
		try {
			String novoTextoFicha = Leitor.ler(ficha);
			tipoTreino++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
				
	}

}
