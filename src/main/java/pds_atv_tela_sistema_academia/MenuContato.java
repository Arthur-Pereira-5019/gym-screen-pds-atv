package pds_atv_tela_sistema_academia;

import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class MenuContato extends JFrame {
	public MenuContato() {
		setTitle("Contato");
		
		getContentPane().setLayout(null);
		
		JTextArea sobre = new JTextArea();
		sobre.setLineWrap(true);
		sobre.setEditable(false);
		sobre.setBounds(10, 47, 416, 206);
		getContentPane().add(sobre);
		
		JLabel lblNewLabel = new JLabel("Fale Conosco");
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
			componente.setText(Leitor.ler("contatos/contato"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
