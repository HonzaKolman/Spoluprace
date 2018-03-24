
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
import java.util.Random;
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
		frmXorsifrakolmanstokr.setTitle("XOR Šifra-Kolman, Štokr");
		frmXorsifrakolmanstokr.setBounds(100, 100, 588, 409);
		frmXorsifrakolmanstokr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmXorsifrakolmanstokr.getContentPane().setLayout(null);
		frmXorsifrakolmanstokr.setResizable(false);
		
		JLabel lblCestaKSouboru = new JLabel("Cesta k souboru:");
		lblCestaKSouboru.setBounds(10, 11, 105, 14);
		frmXorsifrakolmanstokr.getContentPane().add(lblCestaKSouboru);
		
		/**
		 * Area na napsání cesty k souboru
		 */
		textField = new JTextField();
		textField.setBounds(125, 8, 305, 20);
		frmXorsifrakolmanstokr.getContentPane().add(textField);
		textField.setColumns(10);
		
		/**
		 * Výpis ze souboru
		 */
		JTextArea textArea = new JTextArea();

		textArea.setEditable(false);
		textArea.setLineWrap(true);

		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBounds(10, 36, 552, 130);
		frmXorsifrakolmanstokr.getContentPane().add(textArea);
		
		/**
		 * Výpis klíèe
		 */
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea_1.setBounds(102, 177, 225, 23);
		frmXorsifrakolmanstokr.getContentPane().add(textArea_1);
		textArea_1.setEditable(false);
		
		/**
		 * Button na naètení textu z vybraného souboru
		 */
		JButton btnNacist = new JButton("Naèíst");
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
		 * Button na vygenerování klíèe
		 */
		JButton btnKlic = new JButton("Klíè");
		btnKlic.setBounds(10, 177, 82, 23);
		frmXorsifrakolmanstokr.getContentPane().add(btnKlic);

		btnKlic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String abeceda = "abcdefghijklmnopqrstuvwxyz123456789";
				StringBuilder sb = new StringBuilder(10);
				Random generator = new Random();
				for(int i = 0; i < 10; i++) {
					sb.append(abeceda.charAt(generator.nextInt(abeceda.length())));
					String klic = new String(sb);
					textArea_1.setText(klic);
				}
				textArea_1.getText();
			}
		});

		JLabel lblZasifrovanyText = new JLabel("Zašifrovaný text:");
		lblZasifrovanyText.setBounds(10, 211, 105, 14);
		frmXorsifrakolmanstokr.getContentPane().add(lblZasifrovanyText);
		
		/**
		 * Výpis zašifrovaného textu
		 */
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea_2.setBounds(10, 236, 552, 123);
		frmXorsifrakolmanstokr.getContentPane().add(textArea_2);
		textArea_2.setEditable(false);
		
		/**
		 * Button,který zašifruje soubor
		 */
		JButton btnZasifrovat = new JButton("Zašifrovat");
		btnZasifrovat.setBounds(337, 177, 225, 23);
		frmXorsifrakolmanstokr.getContentPane().add(btnZasifrovat);

		btnZasifrovat.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e){
				String a = textArea.getText();
				String b = textArea_1.getText();
				for(int i = 0; i < b.length(); i++) {
					for(int x = 0; x <= a.length(); x++) {
						System.out.printf("xoring <%s> [%s] with <%s> [%s]\n",
		                    a.charAt(x), Integer.toBinaryString(a.charAt(x)),
		                    b.charAt(i), Integer.toBinaryString(b.charAt(i)));
						int c = (a.charAt(0) ^ b.charAt(i));
		            System.out.printf("result is <%s> [%s]\n",
		                    (char) c, Integer.toBinaryString(c));
		            	i++;
		            	if(i == 10) {
		            		i = 0;
		            	}
		            	
		            }
				}

			}
		
		});
	}
}
