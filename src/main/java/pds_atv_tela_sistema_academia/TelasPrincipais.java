package pds_atv_tela_sistema_academia;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTextArea;

public class TelasPrincipais extends Tela{
	
	TimerTask atualizador;
	Timer timer = new Timer();
	
	public TelasPrincipais(JTextArea componente) {
		this.atualizador = new AtualizadorDeTela(componente);
		timer.schedule(atualizador, 0, 6000);
	}
	
	

}
