package cep;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sobre extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setModal(true);
		setResizable(false);
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/home.png")));
		setBounds(150, 150, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar CEP Vers\u00E3o Experimental");
		lblNewLabel.setBounds(36, 40, 219, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("@Author Virg\u00EDlio Pires");
		lblNewLabel_1.setBounds(36, 86, 219, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("WEB Service:");
		lblNewLabel_2.setBounds(36, 133, 80, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblWebService = new JLabel("republicavirtual.com.br");
		lblWebService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    link("https://www.republicavirtual.com.br/");
			}
		});
		lblWebService.setForeground(SystemColor.textHighlight);
		lblWebService.setBounds(142, 133, 113, 14);
		getContentPane().add(lblWebService);
		
		JButton btnGithub = new JButton("");
		btnGithub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    link("https://github.com/Virgiliopc");
			}
		});
		btnGithub.setIcon(new ImageIcon(Sobre.class.getResource("/img/github.png")));
		btnGithub.setBorder(null);
		btnGithub.setBackground(SystemColor.control);
		btnGithub.setBounds(46, 192, 48, 48);
		getContentPane().add(btnGithub);
		
		JButton btnLinkedin = new JButton("");
		btnLinkedin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    link("https://www.linkedin.com/in/virgilio-pires-da-costa/");
			}
		});
		btnLinkedin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLinkedin.setIcon(new ImageIcon(Sobre.class.getResource("/img/linkedin.png")));
		btnLinkedin.setBorder(null);
		btnLinkedin.setBackground(SystemColor.control);
		btnLinkedin.setBounds(121, 192, 48, 48);
		getContentPane().add(btnLinkedin);

	}
	
	private void link(String site) {
	    Desktop desktop = Desktop.getDesktop();
	    try {
		URI uri = new URI(site);
		desktop.browse(uri);
	    } catch (Exception e) {
		System.out.println(e);
	    }
	}

}
