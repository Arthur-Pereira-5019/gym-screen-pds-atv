package pds_atv_tela_sistema_academia;

import javax.swing.JOptionPane;

public class PopupsService {
	
	
	public void mostrarErro(String erro) {
		JOptionPane.showMessageDialog(null, erro, "Erro!", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarSucesso(String sucesso) {
		JOptionPane.showMessageDialog(null, sucesso, "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}

}
