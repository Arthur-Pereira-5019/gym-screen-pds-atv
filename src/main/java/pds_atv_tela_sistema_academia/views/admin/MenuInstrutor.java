package pds_atv_tela_sistema_academia.views.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import pds_atv_tela_sistema_academia.views.generic.TelasPrincipais;

public class MenuInstrutor extends TelasPrincipais {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextArea textArea = new JTextArea();

	public MenuInstrutor() {
		super(textArea);
		
		setTitle("Sistema Academia (Modo Instrutor)");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 338, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Treinos");
		mnNewMenu.setFont(new Font("SansSerif", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem criarTreinos = new JMenuItem("Criar Treinos");
		criarTreinos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirNovo(6);
			}
		});
		mnNewMenu.add(criarTreinos);
		
		JMenuItem atribuirTreinos = new JMenuItem("Atribuir Treinos");
		atribuirTreinos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirNovo(7);
			}
		});
		mnNewMenu.add(atribuirTreinos);
		
		JMenu buttonUsuarios = new JMenu("Usuarios");
		buttonUsuarios.setFont(new Font("SansSerif", Font.PLAIN, 12));
		menuBar.add(buttonUsuarios);
		
		JMenuItem buttonCUsuario = new JMenuItem("Cadastrar Usuario");
		buttonCUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirNovo(5);
			}
			
		});
		buttonUsuarios.add(buttonCUsuario);
		
		JMenuItem buttonBBoletos = new JMenuItem("Baixar Boletos");
		buttonBBoletos.setForeground(new Color(255, 0, 0));
		buttonUsuarios.add(buttonBBoletos);
		
		JMenu buttonBoletos = new JMenu("Informes");
		buttonBoletos.setFont(new Font("SansSerif", Font.PLAIN, 12));
		menuBar.add(buttonBoletos);
		
		JMenuItem novosInformes = new JMenuItem("Novo Informe");
		novosInformes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirNovo(4);
			}
		});
		buttonBoletos.add(novosInformes);
		textArea.setLineWrap(true);
		
		
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBounds(10, 130, 414, 80);
		contentPane.add(textArea);
		
		JLabel userName = new JLabel("Bem vindo!");
		userName.setFont(new Font("SansSerif", Font.PLAIN, 16));
		userName.setBounds(10, 228, 121, 22);
		contentPane.add(userName);
	}
	
	public void mostrar() {
		this.setVisible(true);
	}
	
	
}
