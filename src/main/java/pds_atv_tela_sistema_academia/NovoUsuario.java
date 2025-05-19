package pds_atv_tela_sistema_academia;

import java.awt.Font;
import java.util.Dictionary;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class NovoUsuario extends JFrame {
	private JTextField campoNome;
	private Dictionary<String, Integer> sliderDic;
	public NovoUsuario() {
		sliderDic.put("Novato", 1);
		sliderDic.put("Iniciante", 1);
		sliderDic.put("Rato", 2);
		sliderDic.put("Experiente", 3);
		
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel.setBounds(39, 39, 97, 21);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nova Conta");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_1.setBounds(151, 11, 117, 20);
		getContentPane().add(lblNewLabel_1);
		
		campoNome = new JTextField();
		campoNome.setBounds(120, 36, 170, 27);
		getContentPane().add(campoNome);
		campoNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Experiência");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(18, 72, 96, 14);
		getContentPane().add(lblNewLabel_2);
		
		JSlider slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(1);
		slider.setValue(1);
		slider.setMaximum(3);
		slider.setLabelTable(sliderDic);
		slider.setBounds(107, 68, 200, 31);
		getContentPane().add(slider);
	}
}
