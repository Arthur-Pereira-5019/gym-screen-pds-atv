package pds_atv_tela_sistema_academia;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MenuCriarTreinos extends TelasSecundariasInstrutor {
	private JTextField nomeField;
	private JComboBox<String> grupoSelecao;
	private TreinoService treino = new TreinoService();
	public MenuCriarTreinos() {
		setSize(442, 250);
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Novo Treino");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel.setBounds(173, 10, 120, 24);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizarTreino();
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton.setBounds(163, 175, 109, 29);
		getContentPane().add(btnNewButton);
		
		nomeField = new JTextField();
		nomeField.setBounds(135, 44, 278, 29);
		getContentPane().add(nomeField);
		nomeField.setColumns(10);
		
		grupoSelecao = new JComboBox<String>(treino.modelo);
		grupoSelecao.setBounds(135, 93, 278, 21);
		getContentPane().add(grupoSelecao);
		
		JLabel lblNewLabel_1 = new JLabel("Exercício:");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 52, 76, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Grupo:");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 93, 115, 21);
		getContentPane().add(lblNewLabel_2);
	}
	
	public void atualizarTreino() {
		treino.criarTreino(nomeField.getText(), grupoSelecao.getSelectedItem().toString());
	}
	
}
