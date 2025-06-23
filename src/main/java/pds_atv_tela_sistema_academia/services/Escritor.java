package pds_atv_tela_sistema_academia.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Escritor {
	
	public static void escreverComString(String path, String texto) {
		escreverComFile(new File(path), texto);
	}
	
	public static void escreverComFile(File path, String texto) {
		FileWriter escritor = null;
		try {
			escritor = new FileWriter(path);
			escritor.write(texto);
			escritor.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao gerar arquivos", "Erro!",3);
		} finally {
			try {
				escritor.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
