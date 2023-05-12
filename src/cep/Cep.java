package cep;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;

@SuppressWarnings("serial")
public class Cep extends JFrame {

    private JPanel contentPane;
    private JTextField textCep;
    private JTextField textEndereco;
    private JTextField textBairro;
    private JTextField textCidade;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Cep frame = new Cep();
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
    public Cep() {
	setTitle("Buscar CEP");
	setResizable(false);
	setIconImage(Toolkit.getDefaultToolkit().getImage(Cep.class.getResource("/img/home.png")));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblNewLabel = new JLabel("CEP");
	lblNewLabel.setBounds(31, 39, 46, 14);
	contentPane.add(lblNewLabel);

	textCep = new JTextField();
	textCep.setBounds(87, 36, 103, 20);
	contentPane.add(textCep);
	textCep.setColumns(10);

	JLabel lblNewLabel_1 = new JLabel("Endere\u00E7o");
	lblNewLabel_1.setBounds(31, 85, 46, 14);
	contentPane.add(lblNewLabel_1);

	JLabel lblNewLabel_2 = new JLabel("Bairro");
	lblNewLabel_2.setBounds(31, 134, 46, 14);
	contentPane.add(lblNewLabel_2);

	JLabel lblNewLabel_3 = new JLabel("Cidade");
	lblNewLabel_3.setBounds(31, 174, 46, 14);
	contentPane.add(lblNewLabel_3);

	textEndereco = new JTextField();
	textEndereco.setBounds(87, 82, 315, 20);
	contentPane.add(textEndereco);
	textEndereco.setColumns(10);

	textBairro = new JTextField();
	textBairro.setBounds(87, 131, 315, 20);
	contentPane.add(textBairro);
	textBairro.setColumns(10);

	textCidade = new JTextField();
	textCidade.setBounds(87, 171, 189, 20);
	contentPane.add(textCidade);
	textCidade.setColumns(10);

	JLabel lblNewLabel_4 = new JLabel("UF");
	lblNewLabel_4.setBounds(286, 174, 37, 14);
	contentPane.add(lblNewLabel_4);

	JComboBox cboUf = new JComboBox();
	cboUf.setModel(new DefaultComboBoxModel(
		new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
			"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
	cboUf.setBounds(333, 170, 69, 22);
	contentPane.add(cboUf);

	JButton btnCep = new JButton("Buscar");
	btnCep.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (textCep.getText().equals("")) {
		    JOptionPane.showMessageDialog(null, "Informe o CEP!");
		    textCep.requestFocus();
		} else {
		    buscarCep();
		}

	    }
	});
	btnCep.setBounds(216, 35, 89, 23);
	contentPane.add(btnCep);

	JButton btnLimpar = new JButton("Limpar");
	btnLimpar.setBounds(27, 213, 89, 23);
	contentPane.add(btnLimpar);

	JButton btnSobre = new JButton("");
	btnSobre.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		Sobre sobre = new Sobre();
		sobre.setVisible(true);
	    }
	});
	btnSobre.setIcon(new ImageIcon(Cep.class.getResource("/img/about.png")));
	btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnSobre.setBorder(null);
	btnSobre.setBackground(SystemColor.controlHighlight);
	btnSobre.setBounds(354, 23, 48, 48);
	contentPane.add(btnSobre);

	// Uso da biblioteca atxy2k para valida��o do campo textCep
	RestrictedTextField validar = new RestrictedTextField(textCep);
	validar.setOnlyNums(true);
	validar.setLimit(8);
    }

    private void buscarCep() {
	String logradouro = "";
	String tipoLogradouro = "";
	String resultado = null;
	String cep = textCep.getText();
	try {
	    URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "formato=xml");
	    SAXReader xml = new SAXReader();
	    Document document = xml.read(url);
	    Element root = document.getRootElement();
	    for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
	        Element element = it.next();
	        if (element.getQualifiedName().equals("cidade")) {
	            textCidade.setText(element.getText());
	        }
	             	
	        	
	        
	    }
	} catch (Exception e) {
	    System.out.println(e);
	}
    }
}
