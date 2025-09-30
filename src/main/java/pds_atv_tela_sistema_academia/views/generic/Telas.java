package pds_atv_tela_sistema_academia.views.generic;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import pds_atv_tela_sistema_academia.services.PopupsService;
import pds_atv_tela_sistema_academia.views.admin.MenuAtribuicaoDeTreinos;
import pds_atv_tela_sistema_academia.views.admin.MenuCriarTreinos;
import pds_atv_tela_sistema_academia.views.admin.MenuNovoInforme;
import pds_atv_tela_sistema_academia.views.admin.MenuNovoUsuario;
import pds_atv_tela_sistema_academia.views.usuario.MenuAtualizarUsuario;
import pds_atv_tela_sistema_academia.views.usuario.MenuContato;
import pds_atv_tela_sistema_academia.views.usuario.MenuFichaTreinoEmitida;
import pds_atv_tela_sistema_academia.views.usuario.MenuRegras;
import pds_atv_tela_sistema_academia.views.usuario.MenuSobre;

@SuppressWarnings("serial")
public abstract class Telas extends JFrame {
	public PopupsService popups = new PopupsService();
	
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
			new MenuAtualizarUsuario().setVisible(true);
			break;
		case 4:
			new MenuNovoInforme().setVisible(true);
			break;
		case 5:
			new MenuNovoUsuario().setVisible(true);
			break;
		case 6:
			new MenuCriarTreinos().setVisible(true);
			break;
		case 7:
			new MenuAtribuicaoDeTreinos().setVisible(true);
			break;
		case 8:
			new MenuFichaTreinoEmitida().setVisible(true);
			break;
		case 9:
			new MenuRegras().setVisible(true);
			break;
		default:
			break;
		}
	}

}
