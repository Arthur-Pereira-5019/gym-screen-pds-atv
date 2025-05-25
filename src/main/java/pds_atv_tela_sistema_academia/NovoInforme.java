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

public class NovoInforme extends JFrame {
	public NovoInforme() {
		DefaultListModel<Integer> prioridades = new DefaultListModel<>();
		prioridades.addElement(1);
		prioridades.addElement(2);
		prioridades.addElement(3);
		
		getContentPane().setLayout(null);
		
		JTextArea txtInforme = new JTextArea();
		txtInforme.setText("Informe...");
		txtInforme.setBounds(48, 50, 470, 149);
		getContentPane().add(txtInforme);
		
		JList listPrioridade = new JList(prioridades);
		listPrioridade.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPrioridade.setBounds(164, 209, 272, 20);
		getContentPane().add(listPrioridade);
		
		
		JLabel lblNewLabel = new JLabel("Novo Informe");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel.setBounds(235, 11, 127, 24);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Aviso: O sistema comporta apenas três informes, criar um novo significa excluir o de menor hierarquia!");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 308, 551, 13);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela.informeService.cadastrarInforme(2, txtInforme.getText());
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnNewButton.setBounds(235, 262, 85, 21);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Prioridade:");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(48, 212, 106, 19);
		getContentPane().add(lblNewLabel_2);
	}
}
