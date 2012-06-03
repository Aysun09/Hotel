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
import Anwendung.AktionenMietwagenBearbeiten;
import Datenbank.Datenbankbefehle;

public class MietwagenBearbeiten extends JPanel {

	private JPanel wagenBearbeiten;

	public MietwagenBearbeiten() {
		buildGUI();

	}

	// Aufbau GUI
	public void buildGUI() {
		// neues Panel erstellen
		wagenBearbeiten = new JPanel();
		this.add(wagenBearbeiten);
		wagenBearbeiten.setLayout(null);
		wagenBearbeiten.setBackground(Color.white);
		wagenBearbeiten.setPreferredSize(new Dimension(1000, 700));
		wagenBearbeiten.setVisible(true);

		// JLabel Überschrift
		JLabel daten = new JLabel("Mietwagenliste");
		daten.setBounds(50, 30, 300, 50);
		daten.setFont(new Font("Arial", Font.BOLD, 30));
		wagenBearbeiten.add(daten);

		// JTabel Mietwagenliste
		AktionAnzeigen anzeige = new AktionAnzeigen(
				Datenbankbefehle.wagenAnzeigen());
		JScrollPane scrollPane = new JScrollPane(anzeige.getSQLTable());
		scrollPane.setBounds(120, 100, 800, 300);
		wagenBearbeiten.add(scrollPane);

	}

}
