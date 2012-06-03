package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Anwendung.AktionAnzeigen;
import Anwendung.AktionenZimmerBearbeiten;
import Datenbank.Datenbankbefehle;

public class ZimmerBearbeiten extends JPanel {

	private JPanel zimmerBearbeiten;

	public ZimmerBearbeiten() {
		buildGUI();

	}

	// Mietwagenstammdaten anzeigen
	public void buildGUI() {
		// neues Panel erstellen
		zimmerBearbeiten = new JPanel();
		this.add(zimmerBearbeiten);
		zimmerBearbeiten.setLayout(null);
		zimmerBearbeiten.setBackground(Color.white);
		zimmerBearbeiten.setPreferredSize(new Dimension(1000, 700));
		zimmerBearbeiten.setVisible(true);

		// JLabel Überschrift
		JLabel daten = new JLabel("Zimmerliste");
		daten.setBounds(50, 30, 200, 30);
		daten.setFont(new Font("Arial", Font.BOLD, 30));
		zimmerBearbeiten.add(daten);

		// JTabel Zimmerliste
		AktionAnzeigen anzeige = new AktionAnzeigen(
				Datenbankbefehle.zimmerAnzeigen());
		JScrollPane scrollPane = new JScrollPane(anzeige.getSQLTable());
		scrollPane.setBounds(120, 100, 800, 300);
		zimmerBearbeiten.add(scrollPane);

	}

}
