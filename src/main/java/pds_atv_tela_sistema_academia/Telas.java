package pds_atv_tela_sistema_academia;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class Telas extends JFrame {
	public Telas() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				if(getTitle().isEmpty()) {
					setTitle("Bora Bill Academia");
				}
				
			}
		});
	}
	
	public void abrirNovo(int a) {
		this.dispose();
		switch (a) {
		case 1:
			new MenuContato().setVisible(true);
			break;
		case 2:
			new MenuSobre().setVisible(true);
			break;
		case 3:
			new AtualizarUsuario().setVisible(true);
			break;
		case 4:
			new NovoInforme().setVisible(true);
			break;
		case 5:
			new NovoUsuario().setVisible(true);
			break;
		case 6:
			new MenuCriarTreinos().setVisible(true);
			break;
		case 7:
			new TelaAtribuicaoDeTreinos().setVisible(true);
			break;
		default:
			break;
		}
	}

}
