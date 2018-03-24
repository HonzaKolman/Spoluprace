import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

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
		frmXorifrakolmantokr.setTitle("XOR \u0161ifra-Kolman, \u0160tokr");
		frmXorifrakolmantokr.setBounds(100, 100, 512, 326);
		frmXorifrakolmantokr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmXorifrakolmantokr.getContentPane().setLayout(null);
		
		JLabel lblCestaKSouboru = new JLabel("Cesta k souboru:");
		lblCestaKSouboru.setBounds(10, 11, 105, 14);
		frmXorifrakolmantokr.getContentPane().add(lblCestaKSouboru);
		
		/**
		 * Button na naètení textu z vybraného souboru
		 */
		JButton btnNast = new JButton("Na\u010D\u00EDst");
		btnNast.setBounds(397, 7, 89, 23);
		frmXorifrakolmantokr.getContentPane().add(btnNast);
		
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
		textArea.setBounds(10, 36, 476, 74);
		frmXorifrakolmantokr.getContentPane().add(textArea);
		textArea.setEditable(false);
		
		/**
		 * Button na vygenerování klíèe
		 */
		JButton btnKl = new JButton("Kl\u00ED\u010D");
		btnKl.setBounds(10, 121, 82, 23);
		frmXorifrakolmantokr.getContentPane().add(btnKl);
		
		/**
		 * Výpis klíèe
		 */
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(102, 125, 223, 14);
		frmXorifrakolmantokr.getContentPane().add(textArea_1);
		textArea_1.setEditable(false);
		
		JLabel lblZaifrovanText = new JLabel("Za\u0161ifrovan\u00FD text:");
		lblZaifrovanText.setBounds(10, 155, 105, 14);
		frmXorifrakolmantokr.getContentPane().add(lblZaifrovanText);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(10, 171, 476, 85);
		frmXorifrakolmantokr.getContentPane().add(textArea_2);
	}
}
