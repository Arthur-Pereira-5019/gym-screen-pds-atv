package pds_atv_tela_sistema_academia;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;

public class MenuNovoInforme extends TelasSecundariasInstrutor {
	public MenuNovoInforme() {
		setBounds(100, 100, 570, 379);
		String[] prioridades = {"1", "2" ,"3"};
		getContentPane().setLayout(null);
		
		JTextArea txtInforme = new JTextArea();
		txtInforme.setLineWrap(true);
		txtInforme.setText("Informe...");
		txtInforme.setBounds(48, 50, 470, 149);
		getContentPane().add(txtInforme);
		
		
		JLabel lblNewLabel = new JLabel("Novo Informe");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel.setBounds(235, 11, 127, 24);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Aviso: O sistema comporta apenas três informes, criar um novo significa excluir o de menor hierarquia!");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 308, 551, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prioridade:");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(48, 212, 106, 19);
		getContentPane().add(lblNewLabel_2);
		
		JComboBox<String> comboBox = new JComboBox<String>(prioridades);
		comboBox.setBounds(155, 213, 298, 22);
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuLogin.informeService.cadastrarInforme(Integer.parseInt(comboBox.getSelectedItem().toString()), txtInforme.getText());
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnNewButton.setBounds(235, 262, 85, 21);
		getContentPane().add(btnNewButton);
	}

}
