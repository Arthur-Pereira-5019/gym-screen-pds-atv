package pds_atv_tela_sistema_academia.menus;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import pds_atv_tela_sistema_academia.services.InformeService;
import pds_atv_tela_sistema_academia.services.LoginException;
import pds_atv_tela_sistema_academia.users.Usuario;

public class MenuLogin extends Telas {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MenuSobre menuSobre;
	private JTextField campoMatricula;
	private File listaDeArquivos;

	private static String loggedUser;
	private static String loggedUserName;
	public static int cadastrados;
	private JPasswordField campoSenha;
	public static MenuLogin frame;
	
	public static Usuario usuarioLogado = new Usuario();
	
	public static InformeService informeService = new InformeService();

	
	public static void main(String[] args) {
		cadastrados();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MenuLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MenuLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 450, 300);
		JLabel lblNewLabel = new JLabel("Entre com seus dados...");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 206, 24);
		getContentPane().add(lblNewLabel);

		campoMatricula = new JTextField();
		campoMatricula.setFont(new Font("SansSerif", Font.PLAIN, 16));
		campoMatricula.setBounds(86, 98, 248, 34);
		getContentPane().add(campoMatricula);
		campoMatricula.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Matrícula:");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(86, 64, 248, 24);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(86, 131, 248, 39);
		getContentPane().add(lblNewLabel_2);

		JButton buttonEntrar = new JButton("Entrar");
		buttonEntrar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		buttonEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				validarCampos();

			}
		});
		buttonEntrar.setBounds(160, 208, 103, 34);
		getContentPane().add(buttonEntrar);

		campoSenha = new JPasswordField();
		campoSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					validarCampos();
				}

			}
		});
		campoSenha.setBounds(86, 163, 248, 34);
		getContentPane().add(campoSenha);
	}

	public void validarCampos() {
		if (campoMatricula.getText().length() > 0 && campoSenha.getText().length() > 3) {
			try {
				usuarioLogado.logar(campoMatricula.getText(), campoSenha.getText());
				if (campoMatricula.getText().equals("root")) {
					new MenuInstrutor().setVisible(true);
				} else {
					new MenuUsuario().setVisible(true);
				}
				campoSenha.setText("");
				campoMatricula.setText("");
				setVisible(false);
			} catch(LoginException e) {
				popups.mostrarErro("SENHA OU MATRÍCULA INCORRETAS!");
				campoSenha.setText("");
				campoSenha.requestFocus();
			}
		} else {
			JOptionPane.showMessageDialog(null, "OS CAMPOS DEVEM TER NO MÍNIMO 3 CARACTERES!", "ERRO!",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void cadastrados() {
		cadastrados = new File("data/users").listFiles().length;
	}
	
	public void mostrar() {
		campoSenha.setText("");
		campoMatricula.setText("");
		loggedUser = "";
		loggedUserName = "";
		setVisible(true);
	}
	
	public static String getLogged() {
		return loggedUser;
	}
	
	public static String getLoggedName() {
		return loggedUserName;
	}
	
	
	
	
}
