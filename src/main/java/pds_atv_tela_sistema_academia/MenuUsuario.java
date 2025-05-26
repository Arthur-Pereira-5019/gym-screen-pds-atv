package pds_atv_tela_sistema_academia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;

public class MenuUsuario extends TelasPrincipais {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MenuSobre menuSobre;
	private static JTextArea campoInformes = new JTextArea();;

	public MenuUsuario() {
		
		super(campoInformes);
		
		setTitle("Sistema Academia");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Consultar Treinos");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Emitir Treinos");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Boletos");
		mnNewMenu_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Consultar Boletos");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Emitir Boletos");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("Minha Conta");
		mnNewMenu_2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Alterar Dados");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirNovo(3);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("Institucional");
		mnNewMenu_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem botaoSobre = new JMenuItem("Sobre");
		botaoSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirNovo(2);
			}
		});
		mnNewMenu_3.add(botaoSobre);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Consultar Regras");
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenu contatoButton = new JMenu("Contato");
		contatoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirNovo(1);
			}
		});
		contatoButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
		menuBar.add(contatoButton);
		
		campoInformes.setEnabled(false);
		campoInformes.setEditable(false);
		campoInformes.setBounds(10, 130, 414, 80);
		contentPane.add(campoInformes);
		
		JLabel bemVindo = new JLabel("");
		bemVindo.setBounds(10, 231, 414, 22);
		contentPane.add(bemVindo);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				dispose();
				Tela.mostrar();
			}
			@Override
			public void windowOpened(WindowEvent arg0) {
				bemVindo.setText("Bem vindo ao sistema "+Tela.loggedUserName);
			}
		});
		
		
	}
	
}
