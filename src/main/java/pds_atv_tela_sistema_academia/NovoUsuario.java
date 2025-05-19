package pds_atv_tela_sistema_academia;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class NovoUsuario extends JFrame{
	private JTextField campoNome;
	private Dictionary<Integer, JLabel> sliderDic = new Hashtable<>();
	private JTextField textField;
	private File novoUsuario;
	private FileWriter escritor;
	private final JButton btnCriar = new JButton("Criar");
	public NovoUsuario() {
		setResizable(false);
		setBounds(100, 100, 450, 336);
		sliderDic.put(0, new JLabel("Novato"));
		sliderDic.put(1, new JLabel("Iniciante"));
		sliderDic.put(2, new JLabel("Rato"));
		sliderDic.put(3, new JLabel("Experiente"));
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setBounds(18, 38, 97, 21);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nova Conta");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_1.setBounds(163, 10, 117, 20);
		getContentPane().add(lblNewLabel_1);
		
		campoNome = new JTextField();
		campoNome.setBounds(125, 38, 278, 27);
		getContentPane().add(campoNome);
		campoNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Experiência:");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(18, 90, 96, 27);
		getContentPane().add(lblNewLabel_2);
		
		JSlider slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(1);
		slider.setValue(1);
		slider.setMaximum(3);
		slider.setLabelTable(sliderDic);
		slider.setBounds(125, 90, 278, 31);
		getContentPane().add(slider);
		
		JLabel lblNewLabel_3 = new JLabel("Endereço:");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(18, 144, 89, 29);
		getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(125, 140, 278, 31);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Masculino");
		rdbtnNewRadioButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBounds(125, 207, 89, 21);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Feminino");
		rdbtnNewRadioButton_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		rdbtnNewRadioButton_1.setBounds(216, 207, 77, 21);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Não Binárie");
		rdbtnNewRadioButton_2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		rdbtnNewRadioButton_2.setBounds(301, 207, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Gênero:");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(18, 207, 82, 18);
		getContentPane().add(lblNewLabel_4);
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnCriar.setBounds(170, 253, 110, 36);
		getContentPane().add(btnCriar);
		btnCriar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel, lblNewLabel_1, campoNome, lblNewLabel_2, slider, lblNewLabel_3, textField, rdbtnNewRadioButton, rdbtnNewRadioButton_1, rdbtnNewRadioButton_2, lblNewLabel_4, btnCriar}));
	}
	
	public void criarUsuario(String nome, int exp, String endereco, char G, String senha) {
	novoUsuario = new File("data/users/1.txt");
	
	try {
		novoUsuario.createNewFile();
		escritor = new FileWriter("data/users/1.txt");
		escritor.write("NOM:"+nome+"\nSEN:"+"E");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
