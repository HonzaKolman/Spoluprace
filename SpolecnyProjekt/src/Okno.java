import java.awt.FlowLayout;

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
	private String cesta;
	
	public Okno() {
		this.setTitle("XOR šifra");
		this.setResizable(false);
		this.setSize(600, 350);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		label = new JLabel("Zadej cestu: ");
		this.add(label);
		field = new JTextField(cesta, 40);
		this.add(field);
		but = new JButton("Zašifrovat");
		this.add(but);
		area = new JTextArea(15, 50);
		this.add(area);
		this.setVisible(true);
	}
	public void setCesta()throws Exception {
		if(cesta.length()==0) {
			throw new Exception("Cesta nesmí býtprázdná!");
		}else {
			this.cesta = cesta;
		}
	}
}
