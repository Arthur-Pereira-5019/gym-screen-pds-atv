package pds_atv_tela_sistema_academia.treinos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;

import pds_atv_tela_sistema_academia.exceptions.ResourceNotFoundException;
import pds_atv_tela_sistema_academia.services.Escritor;
import pds_atv_tela_sistema_academia.services.Leitor;
import pds_atv_tela_sistema_academia.services.PopupsService;

public class TreinoService {
	
	public DefaultComboBoxModel<String> fichas = new DefaultComboBoxModel<String>();
	public DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>();
	File pastaTreinos = new File("data/treinos");
	File pastaFichas = new File("data/fichas");
	private PopupsService popups = new PopupsService();
	private File fichaAlvo;
	ExercicioSQLRepository tr = new ExercicioSQLRepository();

	
	public TreinoService() {
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
		modelo.addElement("Ombro");
	}
	
	public void criarTreino(String nomeTreino, String grupo) {
		tr.salvarExercicio(new Exercicio(nomeTreino, grupo));
	}
	//Funções de suporte
	
	public String buscaTipo(String exercicio) {
		try {
			return tr.encontrarExercicio(exercicio).grupo;
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String treinoPraArquivo(String exercicio) {
		return pastaTreinos+"/"+ exercicio.toLowerCase().replace(" ", "_")+".txt";
	}
	
	//Parte das Fichas
	public boolean criarFichaTreino(String matricula) {
		fichaAlvo = newFichaAlvo(matricula);
		try {
			fichaAlvo.createNewFile();
			String textoFicha = "A:[];B:[];C:[];D:[];E:[];F";
			Escritor.escreverComFile(fichaAlvo, textoFicha);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			popups.mostrarErro("Erro ao criar ficha de treino!");
		}
		return false;
	}
	
	public void removerTreinoDaFicha(String remover, String matricula, String tipoTreino) {
		if(constaFichaTreino(matricula)) {
			try {
				String textoAntigoFicha = Leitor.lerFicha(matricula);
				String subFichaAntiga = retornaSubstringFicha(tipoTreino, matricula);
				if(!subFichaAntiga.contains(remover)) {
					popups.mostrarErro("A ficha não contém o treino selecionado");
					return;
				}
				String subFichaNova = subFichaAntiga.replace(","+remover, "");
				String novoTextoFicha = textoAntigoFicha.replace(subFichaAntiga, subFichaNova);
				Escritor.escreverComFile(fichaAlvo, novoTextoFicha);
				popups.mostrarSucesso("Exercício " + remover + " removido da ficha " +tipoTreino+ " com sucesso!");
				
			} catch (IOException e) {
				popups.mostrarErro("Erro ao limpar ficha de treino!");
				e.printStackTrace();
			}
		}
	}
	
	
	public void adicionarTreino(String tipoTreino, String matricula, String novoTreino) {
		if(constaFichaTreino(matricula)) {
			try {
				String textoAntigoFicha = Leitor.lerFicha(matricula);
				String limite = retornaDelimitadorFicha(tipoTreino);
				String novoTextoFicha = textoAntigoFicha.replace(limite, ","+novoTreino+limite);
				Escritor.escreverComFile(fichaAlvo, novoTextoFicha);
				popups.mostrarSucesso(novoTreino + " adicionado na ficha " + tipoTreino + " com sucesso!");
			} catch (IOException e) {
				popups.mostrarErro("Erro ao criar ficha de treino!");
				e.printStackTrace();
			}
		}
	}
	
	
	public void limparGrupoFicha(String matricula, String tipoTreino) {
		if(constaFichaTreino(matricula)) {
			try {
				String textoAntigoFicha = Leitor.lerFicha(matricula);
				String subFichaAntiga = retornaSubstringFicha(tipoTreino, matricula);
				String novoTextoFicha = textoAntigoFicha.replace(subFichaAntiga, "");
				Escritor.escreverComFile(fichaAlvo, novoTextoFicha);
				popups.mostrarSucesso("Ficha" +tipoTreino+ " limpada com sucesso!");
			} catch (IOException e) {
				popups.mostrarErro("Erro ao limpar ficha de treino!");
				e.printStackTrace();
			}
		}
		
	}
	
	public ArrayList<String> lerFicha(String matricula, String tipoTreino) {
		if(constaFichaTreino(matricula)) {
			String subFicha = retornaSubstringFicha(tipoTreino, matricula);
			ArrayList<String> retorno = new ArrayList<String>();
			retorno.addAll(Arrays.asList(subFicha.split(",")));
			retorno.remove(0);
			return retorno;
	}
		return null;
	}
	
	public DefaultComboBoxModel<String> buscaTreinos(String categoria) {
		DefaultComboBoxModel<String> treinos = new DefaultComboBoxModel<String>();
		File pastaTreino = new File("data/treinos");
		ArrayList<File> treinoAnalisado = new ArrayList<File>();
		treinoAnalisado.addAll(Arrays.asList(pastaTreino.listFiles()));
		for (File treino : treinoAnalisado) {
			if(Leitor.getGrupoTreino(treino.getPath()).equals(categoria)) {
				treinos.addElement(Leitor.getNomeTreino(treino.getPath()));
			}
		}
		return treinos;
	}
	
	//Funções de suporte
	private File newFichaAlvo(String matricula) {
		return fichaAlvo = new File(pastaFichas+"/"+matricula+".txt");

	}
	
	private boolean constaFichaTreino(String matricula) {
		if(newFichaAlvo(matricula).exists()) {
			return true;
		}
		return criarFichaTreino(matricula);
		
	}
	
	private String retornaDelimitadorFicha(String tipoTreino) {
		char charTreino = tipoTreino.charAt(0);
		charTreino++;
		return "];"+charTreino;
	}
	
	private String retornaAberturaFicha(String tipoTreino) {
		return tipoTreino+":[";
	}
	
	private String retornaSubstringFicha(String fichaTipo, String matricula) {
		String resultado = null;
		try {
			String textoAntigoFicha = Leitor.lerFicha(matricula);
			String dInicial = retornaAberturaFicha(fichaTipo);
			String dFinal = retornaDelimitadorFicha(fichaTipo);
			int i0 = textoAntigoFicha.indexOf(dInicial);
			int iF = textoAntigoFicha.indexOf(dFinal);
			resultado = textoAntigoFicha.substring(i0+3,iF);
		} catch (IOException e) {
			e.printStackTrace();
			popups.mostrarErro("Erro ao procurar parte da ficha!");
		}
		
		
		return resultado;
	}
	
	

	
	
	

}
