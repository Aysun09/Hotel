package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Anwendung.AktionAnzeigen;
import Anwendung.AktionenGesamtBuchungBearbeiten;
import Datenbank.Datenbankbefehle;

public class GesamtBuchungBearbeiten extends JPanel {

	private JPanel buBearbeiten;
	private JLabel daten;
	private JButton buAendern, buLoeschen, zurueck;
	AktionAnzeigen anzeige;

	public GesamtBuchungBearbeiten() {
		this.buildGui();
	}

	// Aufbau der GUI
	public void buildGui() {

		// Panel erstellen
		buBearbeiten = new JPanel();
		buBearbeiten.setLayout(null);
		this.add(buBearbeiten);
		buBearbeiten.setBackground(Color.white);
		buBearbeiten.setPreferredSize(new Dimension(1000, 700));
		buBearbeiten.setVisible(true);

		// Überschrift Kundenstammdaten
		daten = new JLabel("Buchungsdaten");
		daten.setBounds(50, 30, 500, 30);
		daten.setFont(new Font("Arial", Font.BOLD, 26));
		buBearbeiten.add(daten);

		// JTable für Kundenstammdaten
		anzeige = new AktionAnzeigen(Datenbankbefehle.buchungenAnzeigen());
		JScrollPane scrollPane = new JScrollPane(anzeige.getSQLTable());
		scrollPane.setBounds(80, 100, 850, 300);
		buBearbeiten.add(scrollPane);

		// JButton "Löschen"
		buLoeschen = new JButton("Löschen");
		buLoeschen.setBounds(800, 500, 130, 50);
		buLoeschen.setFont(new Font("Arial", Font.BOLD, 16));
		buLoeschen.setActionCommand("BLOESCHEN");
		buLoeschen.addActionListener(new AktionenGesamtBuchungBearbeiten(this));
		buBearbeiten.add(buLoeschen);

	}

	public JPanel getBuBearbeiten() {
		return buBearbeiten;
	}

	public void setBuBearbeiten(JPanel buBearbeiten) {
		this.buBearbeiten = buBearbeiten;
	}

	public JLabel getDaten() {
		return daten;
	}

	public void setDaten(JLabel daten) {
		this.daten = daten;
	}

	public JButton getBuAendern() {
		return buAendern;
	}

	public void setBuAendern(JButton buAendern) {
		this.buAendern = buAendern;
	}

	public JButton getBuLoeschen() {
		return buLoeschen;
	}

	public void setBuLoeschen(JButton buLoeschen) {
		this.buLoeschen = buLoeschen;
	}

	public JButton getZurueck() {
		return zurueck;
	}

	public void setZurueck(JButton zurueck) {
		this.zurueck = zurueck;
	}

	public AktionAnzeigen getAnzeige() {
		return anzeige;
	}

	public void setAnzeige(AktionAnzeigen anzeige) {
		this.anzeige = anzeige;
	}

}
