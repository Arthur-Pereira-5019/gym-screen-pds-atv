package pds_atv_tela_sistema_academia;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelasSecundariasInstrutor extends Telas {
	
	public TelasSecundariasInstrutor() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				dispose();
				MenuInstrutor.mostrar();
			}
		});
	}

}
