package pds_atv_tela_sistema_academia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Leitor {

	
	public static String ler(String source) throws IOException {
			  return ler(source, false);
			}
	
	public static String ler(String source, boolean fullPath) throws IOException {
	    String texto = "";
	    InputStream inputStream;
	    if(fullPath == true) {
	    	inputStream = new FileInputStream(source);
	    }else {
	    	inputStream = new FileInputStream("data/"+source);
	    }
	    
	    try (BufferedReader br= new BufferedReader(new InputStreamReader(inputStream))) {
	        String linha;
	        while ((linha = br.readLine()) != null) {
	            texto = texto + linha + "\n";
	        }
	    }
	  return texto;
	}
	
	public static String getSenha(String source) {
		try {
			String temp = lerUsuario(source);
			int i = temp.indexOf("SEN:");
			return temp.substring(i+4,temp.indexOf(";", i));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getNome(String source) {
		try {
			String temp = lerUsuario(source);
			int i = temp.indexOf("NOM:");
			return temp.substring(i+4,temp.indexOf(";", i));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static int getExp(String source) {
		try {
			String temp = lerUsuario(source);
			int i = temp.indexOf("EXP:");
			return Integer.parseInt(temp.substring(i+4,temp.indexOf(";", i)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	public static String getEnd(String source) {
		try {
			String temp = lerUsuario(source);
			int i = temp.indexOf("END:");
			return temp.substring(i+4,temp.indexOf(";", i));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getNomeTreino(String source) {
		try {
			String temp = lerTreino(source);
			int i = temp.indexOf("NOM:");
			return temp.substring(i+4,temp.indexOf(";", i));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getGrupoTreino(String source) {
		try {
			String temp = lerTreino(source);
			int i = temp.indexOf("GRU:");
			return temp.substring(i+4,temp.indexOf(";", i));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static char getGenero(String source) {
		try {
			String temp = lerUsuario(source);
			int i = temp.indexOf("GEN:");
			return temp.substring(i+4,temp.indexOf(";", i)).charAt(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 'M';
	}
	
	public static String lerUsuario(String source) throws IOException {
		return ler("users/"+source+".txt");
	}
	
	public static String lerTreino(String source) throws IOException {
		return ler(source,true);
	}
	public static String lerFicha(String source) throws IOException {
		return ler("data/fichas/"+source+".txt",true);
	}
	
	public static int lerNumeroFilhos(String source) throws IOException {
		File temp = new File(source);
		File[] temp2;
		temp2 = temp.listFiles();
		return temp2.length;
	}
	
	public static int numeroUsuariosMatriculados() {
		try {
			return lerNumeroFilhos("data/users");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	

}
