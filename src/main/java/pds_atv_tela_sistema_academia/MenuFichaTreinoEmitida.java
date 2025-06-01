package pds_atv_tela_sistema_academia;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class MenuFichaTreinoEmitida extends TelasSecundariasUsuarios {
	private JTable tabelaTreinos = new JTable();
	private TreinoService treino = new TreinoService();
	private String[] colunas = {"Grupo Muscular","Músculo"};
	private String[][] dados;
	private JComboBox<String> fichas;
	private JScrollPane scrollPane;
	public MenuFichaTreinoEmitida() {
		
		setBounds(100, 100, 444, 512);
		getContentPane().setLayout(null);
		
		
		
		fichas = new JComboBox<String>();
		fichas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizarFicha();
			}
		});
		fichas.setBounds(173, 11, 202, 25);
		getContentPane().add(fichas);
		
		JLabel lblNewLabel = new JLabel("Grupo:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setBounds(75, 10, 71, 21);
		getContentPane().add(lblNewLabel);
		
		tabelaTreinos.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tabelaTreinos.setBounds(75, 42, 300, 421);
		
		scrollPane = new JScrollPane(tabelaTreinos);
		scrollPane.setBounds(33, 59, 374, 385);
		getContentPane().add(scrollPane);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				fichas.setModel(treino.fichas);
				atualizarFicha();
			}
		});
	}
	
	private void atualizarFicha() {
		ArrayList<String> treinosEncontrados = treino.lerFicha(MenuLogin.getLogged(), fichas.getSelectedItem().toString());
		dados = new String[treinosEncontrados.size()][2];
		int i = 0;
		for(String treinoT: treinosEncontrados) {
			dados[i][0] = treinoT;
			dados[i][1] = treino.buscaTipo(treinoT);
			i++;
		}
		tabelaTreinos = new JTable(dados, colunas);
		scrollPane.setViewportView(tabelaTreinos);
		repaint();

	}
}
