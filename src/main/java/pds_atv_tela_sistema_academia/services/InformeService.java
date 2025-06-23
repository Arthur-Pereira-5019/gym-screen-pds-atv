package pds_atv_tela_sistema_academia.services;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.swing.JOptionPane;

public class InformeService {

	File pastaInformes = new File("data/informes");
	public static Dictionary<Integer, File> informes = new Hashtable<>();


	public InformeService() {
		for (int i = 1; i <= 3; i++) {
			informes.put(i, new File(pastaInformes + "/" + i + ".txt"));
		}

	}

	public void cadastrarInforme(int prioridade, String texto) {
		
		try {
			if (!existemInformes()) {
				mensagemDeErro();
				return;
			}

			if (prioridade > 1) {
				for (int i = 1; i < prioridade; i++) {
						Escritor.escreverComFile(informes.get(i), Leitor.ler(informes.get(i + 1).getPath(), true));
				}
			}
				Escritor.escreverComFile(informes.get(prioridade), texto);
				JOptionPane.showMessageDialog(null, "Informe cadastrado com sucesso!", "Sucesso!", 1);

			
				
		} catch (HeadlessException e) {
			mensagemDeErro();
		} catch (IOException e) {
			mensagemDeErro();
		}
	}

	private boolean existemInformes() {
		ArrayList<File> arquivosACriar = new ArrayList<>();
		for (int i = 1; i <= informes.size(); i++) {
			try {
				if (!informes.get(i).exists()) {
					arquivosACriar.add(informes.get(i));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (arquivosACriar.size() > 0) {
			return criarInformes(arquivosACriar);
		}
		return true;
	}

	private boolean criarInformes(ArrayList<File> arquivosACriar) {
		try {
			for (File file : arquivosACriar) {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	private void mensagemDeErro() {
		JOptionPane.showMessageDialog(null, "Algo deu errado ao criar os arquivos dos informes", "Erro!", 2);
	}

}
