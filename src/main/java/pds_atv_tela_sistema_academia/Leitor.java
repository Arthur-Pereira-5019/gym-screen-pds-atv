package pds_atv_tela_sistema_academia;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Leitor {
	File file;
	
	public void read(String name) {
		file = new File("data/"+name);
	}
	
	public static String readFromInputStream(InputStream inputStream) throws IOException {
			    String texto = new String();
			    try (BufferedReader br= new BufferedReader(new InputStreamReader(inputStream))) {
			        String linha;
			        while ((linha = br.readLine()) != null) {
			            texto = texto + linha + "\n";
			        }
			    }
			  return texto;
			}
	

}
