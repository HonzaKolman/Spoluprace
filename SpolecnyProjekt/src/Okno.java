import java.awt.BorderLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Okno extends JFrame{
	private JLabel label;
	private JTextField cesta;
	private JButton nacti;
	private JLabel text;
	private JTextArea area;
	private JLabel labelKlic;
	private JTextArea klic;
	private JButton generovat;
	private JButton sifruj;
	private JButton rozsifruj;
	private JLabel labelSifra;
	private JTextArea sifra;

	public Okno() {
		this.setTitle("XOR šifra");
		this.setResizable(false);
		this.setSize(650, 850);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		label = new JLabel("Zadej cestu: ");
		this.add(label);
		cesta = new JTextField(40);
		this.add(cesta);
		nacti = new JButton("Naèti");
		this.add(nacti);
		nacti.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = cesta.getText();
				try {
					BufferedReader br = new BufferedReader(new FileReader(text));
					String radek = "";
						while((radek=br.readLine())!=null) {
							area.setText(radek);
						}	
						br.close();
						area.getText();
				} catch (FileNotFoundException e1) {
					JOptionPane error = new JOptionPane();
					error.showMessageDialog(null, "Soubor nenalezen.", "Error", JOptionPane.ERROR_MESSAGE);
				}catch (IOException e1) {
				}
			}
		});
		text = new JLabel("Text ze souboru:");
		this.add(text);
		area = new JTextArea(15, 45);
		this.add(area);
		area.setEditable(false);
		labelKlic = new JLabel("Klíè:");
		this.add(labelKlic);
		klic = new JTextArea(15, 45);
		this.add(klic);
		klic.setEditable(false);
		generovat = new JButton("Generovat");
		this.add(generovat);
		sifruj = new JButton("Šifruj");
		this.add(sifruj);
		rozsifruj = new JButton("Rozšifruj\n");
		this.add(rozsifruj);
		labelSifra = new JLabel("Šifra:");
		this.add(labelSifra);
		sifra = new JTextArea(15, 40);
		this.add(sifra);
		sifra.setEditable(false);
		this.setVisible(true);
	}
}
