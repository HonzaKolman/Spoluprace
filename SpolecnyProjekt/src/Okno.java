import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Okno extends JFrame{
	private JLabel label;
	private JTextField field;
	private JButton but;
	
	public Okno() {
		this.setTitle("XOR šifra");
		this.setResizable(false);
		this.setSize(250, 250);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		label = new JLabel("Zadej cestu: ");
		this.add(label);
		field = new JTextField(50);
		this.add(field);
		but = new JButton("Zašifrovat");
		this.setVisible(true);
	}
}
