package pds_atv_tela_sistema_academia;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAtribuicaoDeTreinos extends TelasSecundariasInstrutor {
	private JTextField campoBusca;
	private JTextField textField;
	public TelaAtribuicaoDeTreinos() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Atribuir um Treino");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel.setBounds(144, 10, 180, 24);
		getContentPane().add(lblNewLabel);
		
		campoBusca = new JTextField();
		campoBusca.setBounds(199, 44, 165, 30);
		getContentPane().add(campoBusca);
		campoBusca.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar por Nome:");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 44, 142, 34);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Matrícula Usuário:");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 88, 130, 30);
		getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 16));
		comboBox.setToolTipText("Grupo Muscular");
		comboBox.setBounds(10, 178, 153, 31);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("Treino");
		comboBox_1.setBounds(199, 178, 191, 30);
		getContentPane().add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(199, 91, 165, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(32, 219, 85, 24);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Grupo de Treino:");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 128, 142, 24);
		getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(199, 133, 165, 30);
		getContentPane().add(comboBox_2);
		
		JButton btnNewButton_1 = new JButton("Adicionar");
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton_1.setBounds(144, 219, 115, 21);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remover");
		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton_2.setBounds(297, 218, 105, 22);
		getContentPane().add(btnNewButton_2);
	}
	
}
