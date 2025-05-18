package pds_atv_tela_sistema_academia;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;

public class AlterarDados extends JFrame {
	public AlterarDados() {
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Seus Dados");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setBounds(170, 10, 122, 21);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 39, 105, 21);
		getContentPane().add(lblNewLabel_1);
	}
}
