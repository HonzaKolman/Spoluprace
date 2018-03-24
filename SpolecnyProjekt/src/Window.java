import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Window {

	private JFrame frmXorsifrakolmanstokr;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmXorsifrakolmanstokr.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmXorsifrakolmanstokr = new JFrame();
		frmXorsifrakolmanstokr.setTitle("XOR �ifra-Kolman, �tokr");
		frmXorsifrakolmanstokr.setBounds(100, 100, 588, 409);
		frmXorsifrakolmanstokr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmXorsifrakolmanstokr.getContentPane().setLayout(null);
		
		JLabel lblCestaKSouboru = new JLabel("Cesta k souboru:");
		lblCestaKSouboru.setBounds(10, 11, 105, 14);
		frmXorsifrakolmanstokr.getContentPane().add(lblCestaKSouboru);
		
		/**
		 * Area na naps�n� cesty k souboru
		 */
		textField = new JTextField();
		textField.setBounds(125, 8, 305, 20);
		frmXorsifrakolmanstokr.getContentPane().add(textField);
		textField.setColumns(10);
		
		/**
		 * V�pis ze souboru
		 */
		JTextArea textArea = new JTextArea();

		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setLineWrap(true);

		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBounds(10, 36, 552, 130);
		frmXorsifrakolmanstokr.getContentPane().add(textArea);

		
		/**
		 * Button na na�ten� textu z vybran�ho souboru
		 */
		JButton btnNacist = new JButton("Na��st");
		btnNacist.setBounds(473, 7, 89, 23);
		frmXorsifrakolmanstokr.getContentPane().add(btnNacist);
		btnNacist.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				try {
					BufferedReader br = new BufferedReader(new FileReader(text));
					String radek = "";
						while((radek=br.readLine())!=null) {
							textArea.setText(radek);
						}	
						br.close();
						textArea.getText();
				} catch (FileNotFoundException e1) {
					JOptionPane error = new JOptionPane();
					error.showMessageDialog(null, "Soubor nenalezen.", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (IOException e1) {
				}
			}
		});
		
		/**
		 * Button na vygenerov�n� kl��e
		 */
		JButton btnKlic = new JButton("Kl��");
		btnKlic.setBounds(10, 177, 82, 23);
		frmXorsifrakolmanstokr.getContentPane().add(btnKlic);
		
		/**
		 * V�pis kl��e
		 */
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea_1.setBounds(102, 177, 225, 23);
		frmXorsifrakolmanstokr.getContentPane().add(textArea_1);
		textArea_1.setEditable(false);
		
		JLabel lblZasifrovanyText = new JLabel("Za�ifrovan� text:");
		lblZasifrovanyText.setBounds(10, 211, 105, 14);
		frmXorsifrakolmanstokr.getContentPane().add(lblZasifrovanyText);
		
		/**
		 * V�pis za�ifrovan�ho textu
		 */
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea_2.setBounds(10, 236, 552, 123);
		frmXorsifrakolmanstokr.getContentPane().add(textArea_2);
		textArea_2.setEditable(false);
		
		/**
		 * Button,kter� za�ifruje soubor
		 */
		JButton btnZasifrovat = new JButton("Za�ifrovat");
		btnZasifrovat.setBounds(337, 177, 101, 23);
		frmXorsifrakolmanstokr.getContentPane().add(btnZasifrovat);
		
		/**
		 * Button, kter� roz�ifruje soubor
		 */
		JButton btnRozsifrovat = new JButton("Roz�ifrovat");
		btnRozsifrovat.setBounds(457, 177, 105, 23);
		frmXorsifrakolmanstokr.getContentPane().add(btnRozsifrovat);

	}
}
