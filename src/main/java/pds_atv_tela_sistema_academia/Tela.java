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

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MenuSobre menuSobre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setTitle("Sistema Academia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("Institucional");
		mnNewMenu_3.setFont(new Font("SansSerif", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem botaoSobre = new JMenuItem("Sobre");
		botaoSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MenuSobre().setVisible(true);
			}
		});
		mnNewMenu_3.add(botaoSobre);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Consultar Regras");
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenu contatoButton = new JMenu("Contato");
		contatoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MenuContato().setVisible(true);
			}
		});
		contatoButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
		menuBar.add(contatoButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBounds(10, 130, 414, 80);
		contentPane.add(textArea);
	}
}
