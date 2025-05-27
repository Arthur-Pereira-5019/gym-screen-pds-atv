package pds_atv_tela_sistema_academia;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class MenuCriarTreinos extends TelasSecundariasInstrutor {
	private JTextField textField;
	public MenuCriarTreinos() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Novo Treino");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel.setBounds(163, 10, 120, 24);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton.setBounds(163, 232, 109, 21);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(135, 44, 278, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(135, 93, 278, 21);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Exercício:");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 52, 76, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Grupo:");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 93, 115, 21);
		getContentPane().add(lblNewLabel_2);
	}
}
