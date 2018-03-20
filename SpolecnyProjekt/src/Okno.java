import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Okno extends JFrame{
	private JLabel label;
	private JTextField field;
	private JButton but;
	private JTextArea area;

	public Okno() {
		this.setTitle("XOR šifra");
		this.setResizable(false);
		this.setSize(600, 350);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		label = new JLabel("Zadej cestu: ");
		this.add(label);
		field = new JTextField(40);
		this.add(field);
		but = new JButton("Zašifrovat");
		this.add(but);
		but.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = field.getText();
				try {
					BufferedReader br = new BufferedReader(new FileReader(text));
					String radek = "";
					ArrayList<String> l = new ArrayList<>();
						while((radek=br.readLine())!=null) {
							l.add(radek);
						}	
						br.close();
						
						System.out.println(l);

				} catch (FileNotFoundException e1) {
					System.out.println("Soubor nenalezen.");
					e1.printStackTrace();
				}catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		area = new JTextArea(15, 30);
		this.add(area);
		this.setVisible(true);
	}
}
