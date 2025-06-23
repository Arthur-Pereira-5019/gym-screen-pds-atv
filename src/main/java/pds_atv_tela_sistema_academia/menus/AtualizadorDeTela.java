package pds_atv_tela_sistema_academia.menus;

import java.io.IOException;
import java.util.TimerTask;

import javax.swing.JTextArea;

import pds_atv_tela_sistema_academia.services.InformeService;
import pds_atv_tela_sistema_academia.services.Leitor;


public class AtualizadorDeTela extends TimerTask {
		
	JTextArea componente;
	int i = 0;

	AtualizadorDeTela(JTextArea componente) {
		this.componente = componente;
	}

	@Override
	public void run() {
		if(i < InformeService.informes.size()) {
			i++;
		}else {
			i = 1;
		}
		try {
			componente.setText(Leitor.ler(InformeService.informes.get(i).getPath(),true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
