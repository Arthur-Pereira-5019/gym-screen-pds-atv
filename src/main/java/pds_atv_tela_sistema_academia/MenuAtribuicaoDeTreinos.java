package pds_atv_tela_sistema_academia;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MenuAtribuicaoDeTreinos extends TelasSecundariasInstrutor {
	private JTextField campoBusca;
	private JTextField campoMatricula;
	private TreinoService treino = new TreinoService();
	private JComboBox<String> treinos = null;
	private JComboBox<String> gruposM = null;
	private JComboBox<String> gruposT = null;
	private Usuario usuario = new Usuario();
	
	public MenuAtribuicaoDeTreinos() {
		
		setSize(460, 320);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Atribuir um Treino");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel.setBounds(144, 10, 180, 24);
		getContentPane().add(lblNewLabel);
		
		campoBusca = new JTextField();
		campoBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					buscarPeloNome();
				}
			}
		});
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
		
		gruposM = new JComboBox<String>(treino.modelo);
		gruposM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				treinos.setModel(treino.buscaTreinos(gruposM.getSelectedItem().toString()));
			}
		});
		gruposM.setFont(new Font("SansSerif", Font.PLAIN, 16));
		gruposM.setToolTipText("Grupo Muscular");
		gruposM.setBounds(10, 178, 153, 31);
		getContentPane().add(gruposM);
		
		treinos = new JComboBox<String>(treino.buscaTreinos(gruposM.getSelectedItem().toString()));
		treinos.setToolTipText("Treino");
		treinos.setBounds(199, 178, 191, 30);
		getContentPane().add(treinos);
		
		
		
		
		campoMatricula = new JTextField();
		campoMatricula.addKeyListener(new KeyAdapter() {
			@Override
				public void keyPressed(KeyEvent arg0) {
					if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
						buscarPeloId();
					}
				}
		});
		campoMatricula.setBounds(199, 91, 165, 32);
		getContentPane().add(campoMatricula);
		campoMatricula.setColumns(10);
		
		JButton buttonLimpar = new JButton("Limpar");
		buttonLimpar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		buttonLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparTreinos();
			}
		});
		buttonLimpar.setBounds(32, 219, 85, 24);
		getContentPane().add(buttonLimpar);
		
		JLabel lblNewLabel_3 = new JLabel("Grupo de Treino:");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 128, 142, 24);
		getContentPane().add(lblNewLabel_3);
		
		gruposT = new JComboBox<String>(treino.fichas);
		gruposT.setBounds(199, 133, 165, 30);
		getContentPane().add(gruposT);
		
		JButton buttonAdicionar = new JButton("Adicionar");
		buttonAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionarTreino();
			}
		});
		buttonAdicionar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		buttonAdicionar.setBounds(144, 219, 115, 21);
		getContentPane().add(buttonAdicionar);
		
		JButton buttonRemover = new JButton("Remover");
		buttonRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removerTreino();
			}
		});
		buttonRemover.setFont(new Font("SansSerif", Font.PLAIN, 16));
		buttonRemover.setBounds(297, 218, 105, 22);
		getContentPane().add(buttonRemover);
	}
	
	private void atualizarNome(String nome) {
		campoBusca.setText(nome);
	}
	
	private void buscarPeloId() {
		atualizarNome(Leitor.getNome(campoMatricula.getText()));
	}
	
	private void buscarPeloNome() {
		File arquivoUsuario;
		if((arquivoUsuario = usuario.buscarUsuario(campoBusca.getText())) != null) {
			atualizarId(arquivoUsuario.getName().replace(".txt", ""));
		}
	}
	
	private void atualizarId(String id) {
		campoMatricula.setText(id);
	}
	
	private void removerTreino() {
		treino.removerTreinoDaFicha(treinos.getSelectedItem().toString(), campoMatricula.getText(), gruposT.getSelectedItem().toString());
	}
	
	private void adicionarTreino() {
		try {
			Integer.parseInt(campoMatricula.getText());
		} catch (Exception e) {
			popups.mostrarErro("O campo matrícula deve ser numérico!");
			return;
		}
		treino.adicionarTreino(gruposT.getSelectedItem().toString(), campoMatricula.getText(), treinos.getSelectedItem().toString());
	}
	
	private void limparTreinos() {
		treino.limparGrupoFicha(campoMatricula.getText(), gruposT.getSelectedItem().toString());
	}
	
}
