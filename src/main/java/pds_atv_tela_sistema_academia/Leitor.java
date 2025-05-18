package pds_atv_tela_sistema_academia;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Leitor {

	
	public static String ler(String source) throws IOException {
			    String texto = "";
			    InputStream inputStream = new FileInputStream("data/"+source);
			    
			    try (BufferedReader br= new BufferedReader(new InputStreamReader(inputStream))) {
			        String linha;
			        while ((linha = br.readLine()) != null) {
			            texto = texto + linha + "\n";
			        }
			    }
			  return texto;
			}
	

}
