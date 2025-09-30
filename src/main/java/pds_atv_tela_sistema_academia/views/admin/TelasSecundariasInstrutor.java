package pds_atv_tela_sistema_academia.views.admin;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import pds_atv_tela_sistema_academia.views.generic.Telas;

public class TelasSecundariasInstrutor extends Telas {
	
	public TelasSecundariasInstrutor() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
				new MenuInstrutor().setVisible(true);
			}
		});
	}

}
