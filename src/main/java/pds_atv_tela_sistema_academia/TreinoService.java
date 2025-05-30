package pds_atv_tela_sistema_academia;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class TreinoService {
	
	DefaultComboBoxModel<String> fichas = new DefaultComboBoxModel<String>();
	DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>();
	File pastaTreinos = new File("data/treinos");
	File pastaFichas = new File("data/fichas");
	File fichaAlvo;

	
	TreinoService() {
		fichas.addElement("A");
		fichas.addElement("B");
		fichas.addElement("C");
		fichas.addElement("D");
		fichas.addElement("E");
		
		modelo.addElement("Abdominal");
		modelo.addElement("Biceps");
		modelo.addElement("Triceps");
		modelo.addElement("Coxa");
		modelo.addElement("Antebraço");
		modelo.addElement("Glúteos");
		modelo.addElement("Panturrilha");
		modelo.addElement("Peito");
		modelo.addElement("Costas");
		modelo.addElement("Cardio");
	}
	
	
	public void criarTreino(String nomeTreino, String grupo) {
		
		
		File novoTreino = new File(pastaTreinos+"/"+ nomeTreino.toLowerCase().replace(" ", "_")+".txt");
		try {
			novoTreino.createNewFile();
			String textoFinal = "NOM:"+nomeTreino+";\nGRU:"+grupo+";";
			Escritor.escreverComFile(novoTreino, textoFinal);
			JOptionPane.showMessageDialog(null, "Sucesso ao criar o treino!","Sucesso!",3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao criar treino","Erro!",2);
		}
	}
	
	public void criarFichaTreino() {
		fichaAlvo = new File(pastaFichas+TelaLogin.loggedUser);
		try {
			fichaAlvo.createNewFile();
			String textoFicha = "A:[_];B:[_];C:[_];D:[_];E:[_]";
			Escritor.escreverComFile(fichaAlvo, textoFicha);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removerTreinoDaFicha(String remover) {
		fichaAlvo = new File(pastaFichas+TelaLogin.loggedUser);
		Escritor.escreverComFile(fichaAlvo, remover);
	}
	
	public void adicionarTreino(char tipoTreino, String ficha) {
		try {
			String novoTextoFicha = Leitor.ler(ficha);
			tipoTreino++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public DefaultComboBoxModel<String> buscaTreinos(String categoria) {
		DefaultComboBoxModel<String> treinos = new DefaultComboBoxModel<String>();
		File pastaTreino = new File("data/treinos");
		ArrayList<File> treinoAnalisado = new ArrayList<File>();
		treinoAnalisado.addAll(Arrays.asList(pastaTreino.listFiles()));
		for (File treino : treinoAnalisado) {
			if(Leitor.getGrupoTreino(treino.getPath()).equals(categoria)) {
				treinos.addElement(Leitor.getNomeTreino(treino.getPath()));
				System.out.println("Adicionado o "+Leitor.getNomeTreino(treino.getPath()));
			}
		}
		return treinos;
	}
	

	
	
	

}
