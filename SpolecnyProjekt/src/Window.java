import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Window {

	private JFrame frmXorifrakolmantokr;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmXorifrakolmantokr.setVisible(true);
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
		frmXorifrakolmantokr = new JFrame();
		frmXorifrakolmantokr.setTitle("XOR Šifra-Kolman, Štokr");
		frmXorifrakolmantokr.setBounds(100, 100, 512, 326);
		frmXorifrakolmantokr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmXorifrakolmantokr.getContentPane().setLayout(null);
		
		JLabel lblCestaKSouboru = new JLabel("Cesta k souboru:");
		lblCestaKSouboru.setBounds(10, 11, 105, 14);
		frmXorifrakolmantokr.getContentPane().add(lblCestaKSouboru);
		
		/**
		 * Button na naètení textu z vybraného souboru
		 */
		JButton btnNacist = new JButton("Naèíst");
		btnNacist.setBounds(397, 7, 89, 23);
		frmXorifrakolmantokr.getContentPane().add(btnNacist);
		
		/**
		 * Area na napsání cesty k souboru
		 */
		textField = new JTextField();
		textField.setBounds(125, 8, 262, 20);
		frmXorifrakolmantokr.getContentPane().add(textField);
		textField.setColumns(10);
		
		/**
		 * Výpis ze souboru
		 */
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBounds(10, 36, 476, 74);
		frmXorifrakolmantokr.getContentPane().add(textArea);
		textArea.setEditable(false);
		
		/**
		 * Button na vygenerování klíèe
		 */
		JButton btnKlic = new JButton("Klíè");
		btnKlic.setBounds(10, 121, 82, 23);
		frmXorifrakolmantokr.getContentPane().add(btnKlic);
		
		/**
		 * Výpis klíèe
		 */
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea_1.setBounds(102, 121, 225, 23);
		frmXorifrakolmantokr.getContentPane().add(textArea_1);
		textArea_1.setEditable(false);
		
		JLabel lblZasifrovanyText = new JLabel("Zašifrovaný text:");
		lblZasifrovanyText.setBounds(10, 155, 105, 14);
		frmXorifrakolmantokr.getContentPane().add(lblZasifrovanyText);
		
		/**
		 * Výpis zašifrovaného textu
		 */
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea_2.setBounds(10, 171, 476, 85);
		frmXorifrakolmantokr.getContentPane().add(textArea_2);
	}
}
