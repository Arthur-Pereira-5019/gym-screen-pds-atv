package pds_atv_tela_sistema_academia;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class TelaLogin extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	public TelaLogin() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Entre com seus dados...");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 206, 24);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textField.setBounds(86, 71, 248, 39);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(86, 132, 248, 39);
		getContentPane().add(textField_1);
	}
}
