package pds_atv_tela_sistema_academia.views.generic;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTextArea;

public class TelasPrincipais extends Telas{
	
	TimerTask atualizador;
	Timer timer = new Timer();
	
	public TelasPrincipais(JTextArea componente) {
		this.atualizador = new AtualizadorDeTela(componente);
		timer.schedule(atualizador, 0, 6000);
		
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent arg0) {
					dispose();
					MenuLogin.frame.mostrar();
				}
			});
	}
	
}
