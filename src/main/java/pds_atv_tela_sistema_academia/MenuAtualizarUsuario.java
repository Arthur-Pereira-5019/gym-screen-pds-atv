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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuAtualizarUsuario extends TelasSecundariasUsuarios{
	private JTextField campoNome;
	private Dictionary<Integer, JLabel> sliderDic = new Hashtable<>();
	private JTextField campoEndereco;
	private File novoUsuario;
	private ButtonGroup genero = new ButtonGroup();
	private FileWriter escritor;
	private final JButton btnCriar = new JButton("Atualizar");
	private JPasswordField campoSenha;

	public MenuAtualizarUsuario() {
		
		setResizable(false);
		setBounds(100, 100, 450, 379);
		sliderDic.put(0, new JLabel("Novato"));
		sliderDic.put(1, new JLabel("Iniciante"));
		sliderDic.put(2, new JLabel("Rato"));
		sliderDic.put(3, new JLabel("Experiente"));
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setBounds(18, 38, 97, 21);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Atualizar Dados");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_1.setBounds(152, 10, 155, 20);
		getContentPane().add(lblNewLabel_1);
		
		campoNome = new JTextField();
		campoNome.setBounds(125, 38, 278, 27);
		getContentPane().add(campoNome);
		campoNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Experiência:");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(18, 90, 96, 27);
		getContentPane().add(lblNewLabel_2);
		
		JSlider sliderExp = new JSlider();
		sliderExp.setPaintLabels(true);
		sliderExp.setMajorTickSpacing(1);
		sliderExp.setValue(1);
		sliderExp.setMaximum(3);
		sliderExp.setLabelTable(sliderDic);
		sliderExp.setBounds(125, 90, 278, 31);
		getContentPane().add(sliderExp);
		
		JLabel lblNewLabel_3 = new JLabel("Endereço:");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(18, 144, 89, 29);
		getContentPane().add(lblNewLabel_3);
		
		campoEndereco = new JTextField();
		campoEndereco.setBounds(125, 140, 278, 31);
		getContentPane().add(campoEndereco);
		campoEndereco.setColumns(10);
		
		JRadioButton buttonM = new JRadioButton("Masculino");
		buttonM.setSelected(true);
		buttonM.setFont(new Font("SansSerif", Font.PLAIN, 13));
		buttonM.setBounds(125, 207, 89, 21);
		getContentPane().add(buttonM);
		
		JRadioButton buttonF = new JRadioButton("Feminino");
		buttonF.setFont(new Font("SansSerif", Font.PLAIN, 13));
		buttonF.setBounds(216, 207, 89, 21);
		getContentPane().add(buttonF);
		
		JRadioButton buttonNB = new JRadioButton("Não Binárie");
		buttonNB.setFont(new Font("SansSerif", Font.PLAIN, 13));
		buttonNB.setBounds(307, 207, 103, 21);
		getContentPane().add(buttonNB);
		
		JLabel lblNewLabel_4 = new JLabel("Gênero:");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(18, 207, 82, 18);
		getContentPane().add(lblNewLabel_4);
		genero.add(buttonNB);
		genero.add(buttonM);
		genero.add(buttonF);
		genero.setSelected(null, true);
		btnCriar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				char genero = 'M';
				if(buttonNB.isSelected()) {
					genero = 'N';
				}else if(buttonF.isSelected()) {
					genero = 'F';
				}
				try {
					MenuLogin.usuarioLogado = new Usuario(campoNome.getText(), sliderExp.getValue(), campoEndereco.getText(), genero, campoSenha.getText(), MenuLogin.frame.usuarioLogado.getMatricula());
					MenuLogin.usuarioLogado.atualizarUsuario();
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCriar.setBounds(163, 297, 110, 36);
		getContentPane().add(btnCriar);
		btnCriar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		JLabel labelSenha = new JLabel("Nova Senha:");
		labelSenha.setFont(new Font("SansSerif", Font.PLAIN, 16));
		labelSenha.setBounds(18, 254, 97, 21);
		getContentPane().add(labelSenha);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(125, 250, 278, 27);
		getContentPane().add(campoSenha);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel, lblNewLabel_1, campoNome, lblNewLabel_2, sliderExp, lblNewLabel_3, campoEndereco, buttonM, buttonF, buttonNB, lblNewLabel_4, btnCriar, labelSenha, campoSenha}));
	
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				String matricula = MenuLogin.getLogged();
				sliderExp.setValue(Leitor.getExp(matricula));
				campoEndereco.setText(Leitor.getEnd(matricula));
				campoNome.setText((Leitor.getNome(matricula)));
				char genero = Leitor.getGenero(matricula);
				if(genero == 'M') {
					buttonM.setSelected(true);
					return;
				}else if(genero == 'F') {
					buttonF.setSelected(true);
					return;
				}
				buttonNB.setSelected(true);
			}
		});
	
	}
	
	
}
