package pds_atv_tela_sistema_academia;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MenuSobre menuSobre;
	private JTextField campoMatricula;
	private JTextField campoSenha;
	private File listaDeArquivos;

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
getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Entre com seus dados...");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 206, 24);
		getContentPane().add(lblNewLabel);
		
		campoMatricula = new JTextField();
		campoMatricula.setFont(new Font("SansSerif", Font.PLAIN, 16));
		campoMatricula.setBounds(86, 98, 248, 39);
		getContentPane().add(campoMatricula);
		campoMatricula.setColumns(10);
		
		campoSenha = new JTextField();
		campoSenha.setFont(new Font("SansSerif", Font.PLAIN, 16));
		campoSenha.setColumns(10);
		campoSenha.setBounds(86, 163, 248, 39);
		getContentPane().add(campoSenha);
		
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
			public void actionPerformed(ActionEvent arg0) {
				if(ValidarUsuario.validar(campoMatricula.getText(), campoSenha.getText())) {
					System.out.println("DEU PORRA");
				} else {
					
				}
			}
		});
		buttonEntrar.setBounds(162, 219, 103, 34);
		getContentPane().add(buttonEntrar);
	}
}
