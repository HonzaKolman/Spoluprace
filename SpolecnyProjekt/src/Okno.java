import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	String cesta;
	
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
		area = new JTextArea(15, 50);
		this.add(area);
		this.setVisible(true);
	}
	
	public void ctiSoubor(String cesta) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(cesta));
			String radek = "";
			ArrayList<String> l = new ArrayList<>();
			
				while((radek=br.readLine())!=null) {
					l.add(radek);
				}	
				br.close();
				System.out.println(l);
			
		} catch (FileNotFoundException e) {
			System.out.println("Soubor nenalezen.");
			e.printStackTrace();
		}catch (IOException e) {
				
			e.printStackTrace();
		}
	}
	
}
