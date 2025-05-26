package pds_atv_tela_sistema_academia;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelasSecundariasUsuarios extends Telas {
	
	public TelasSecundariasUsuarios() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				dispose();
				MenuUsuario.mostrar();
			}
		});
	}

}
