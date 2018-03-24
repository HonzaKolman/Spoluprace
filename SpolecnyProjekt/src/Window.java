import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Window {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCestaKSouboru = new JLabel("Cesta k souboru:");
		lblCestaKSouboru.setBounds(10, 11, 82, 14);
		frame.getContentPane().add(lblCestaKSouboru);
		
		/**
		 * Button na naètení textu z vybraného souboru
		 */
		JButton btnNast = new JButton("Na\u010D\u00EDst");
		btnNast.setBounds(335, 7, 89, 23);
		frame.getContentPane().add(btnNast);
		
		/**
		 * Area na napsání cesty k souboru
		 */
		textField = new JTextField();
		textField.setBounds(102, 8, 223, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		/**
		 * Výpis ze souboru
		 */
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 36, 414, 74);
		frame.getContentPane().add(textArea);
		textArea.setEditable(false);
		
		/**
		 * Button na vygenerování klíèe
		 */
		JButton btnKl = new JButton("Kl\u00ED\u010D");
		btnKl.setBounds(10, 121, 82, 23);
		frame.getContentPane().add(btnKl);
		
		/**
		 * Výpis klíèe
		 */
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(102, 125, 223, 14);
		frame.getContentPane().add(textArea_1);
		textArea_1.setEditable(false);
	}
}
