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
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

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
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JPanel p4;
	private JPanel p5;
	

	public Okno() {
		this.setTitle("XOR šifra");
		this.setResizable(false);
		this.setSize(650, 850);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		p1 = new JPanel(new FlowLayout());
		label = new JLabel("Zadej cestu: ");
		p1.add(label);
		cesta = new JTextField(40);
		p1.add(cesta);
		nacti = new JButton("Naèti");
		p1.add(nacti);
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
		p2 = new JPanel(new FlowLayout());
		text = new JLabel("Text ze souboru:");
		p2.add(text);
		area = new JTextArea(15, 45);
		p2.add(area);
		area.setEditable(false);
		area.setLineWrap(true);
		area.setAutoscrolls(true);
		p3= new JPanel(new FlowLayout());
		labelKlic = new JLabel("Klíè:");
		p3.add(labelKlic);
		klic = new JTextArea(15, 45);
		p3.add(klic);
		klic.setEditable(false);
		generovat = new JButton("Generovat");
		p3.add(generovat);
		p4 = new JPanel(new FlowLayout());
		sifruj = new JButton("Šifruj");
		p4.add(sifruj);
		rozsifruj = new JButton("Rozšifruj\n");
		p4.add(rozsifruj);
		p5 = new JPanel(new FlowLayout());
		labelSifra = new JLabel("Šifra:");
		p5.add(labelSifra);
		sifra = new JTextArea(15, 40);
		p5.add(sifra);
		sifra.setEditable(false);
		this.setVisible(true);
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
	}
}
