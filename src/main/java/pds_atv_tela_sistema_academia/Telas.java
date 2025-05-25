package pds_atv_tela_sistema_academia;

import javax.swing.JFrame;

public abstract class Telas extends JFrame {
	
	public void abrirNovo(int a) {
		this.setVisible(false);
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
			
		default:
			break;
		}
	}

}
