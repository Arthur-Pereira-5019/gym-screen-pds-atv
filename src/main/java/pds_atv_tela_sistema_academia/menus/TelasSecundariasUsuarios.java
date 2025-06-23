package pds_atv_tela_sistema_academia.menus;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelasSecundariasUsuarios extends Telas {
	
	public TelasSecundariasUsuarios() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
				new MenuUsuario().mostrar();

			}
		});
	}
	
	

}
