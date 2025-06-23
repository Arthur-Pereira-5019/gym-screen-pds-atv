package pds_atv_tela_sistema_academia.menus;

import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import pds_atv_tela_sistema_academia.services.Leitor;

public class MenuRegras extends TelasSecundariasUsuarios {
	public MenuRegras() {
		setBounds(100, 100, 450, 300);

		setTitle("Regras");
		
		getContentPane().setLayout(null);
		
		JTextArea sobre = new JTextArea();
		sobre.setLineWrap(true);
		sobre.setEditable(false);
		sobre.setBounds(10, 47, 416, 206);
		getContentPane().add(sobre);
		
		JLabel lblNewLabel = new JLabel("Regras");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel.setBounds(151, 10, 141, 27);
		getContentPane().add(lblNewLabel);
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				atualizarSobre(sobre);
			}
		});
	}
	
	public void atualizarSobre(JTextArea componente) {
		try {
			componente.setText(Leitor.ler("sobre/regras"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
