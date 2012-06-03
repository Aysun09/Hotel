package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Anwendung.AktionAnzeigen;
import Anwendung.AktionenKundeBearbeiten;
import Datenbank.Datenbankbefehle;

public class KundeBearbeiten extends JPanel {

	private JPanel kBearbeiten;
	private JLabel daten;
	private JButton kAendern, kLoeschen, zurueck;
	AktionAnzeigen anzeige;

	public KundeBearbeiten() {
		this.buildGui();
	}

	// Aufbau der GUI
	public void buildGui() {

		// Panel erstellen
		kBearbeiten = new JPanel();
		kBearbeiten.setLayout(null);
		this.add(kBearbeiten);
		kBearbeiten.setBackground(Color.white);
		kBearbeiten.setPreferredSize(new Dimension(1000, 700));
		kBearbeiten.setVisible(true);

		// Überschrift Kundenstammdaten
		daten = new JLabel("Kundenstammdaten");
		daten.setBounds(50, 30, 500, 30);
		daten.setFont(new Font("Arial", Font.BOLD, 26));
		kBearbeiten.add(daten);

		// JTable für Kundenstammdaten
		anzeige = new AktionAnzeigen(Datenbankbefehle.kundenAnzeigen());
		JScrollPane scrollPane = new JScrollPane(anzeige.getSQLTable());
		scrollPane.setBounds(80, 100, 850, 300);
		kBearbeiten.add(scrollPane);

		// JButton "Ändern"
		kAendern = new JButton("Ändern");
		kAendern.setBounds(800, 500, 130, 50);
		kAendern.setFont(new Font("Arial", Font.BOLD, 16));
		kAendern.setActionCommand("KAENDERN");
		kAendern.addActionListener(new AktionenKundeBearbeiten(this));
		kBearbeiten.add(kAendern);

		// JButton "Löschen"
		kLoeschen = new JButton("Löschen");
		kLoeschen.setBounds(650, 500, 130, 50);
		kLoeschen.setFont(new Font("Arial", Font.BOLD, 16));
		kLoeschen.setActionCommand("KLOESCHEN");
		kLoeschen.addActionListener(new AktionenKundeBearbeiten(this));
		kBearbeiten.add(kLoeschen);

	}

	public JPanel getkBearbeiten() {
		return kBearbeiten;
	}

	public void setkBearbeiten(JPanel kBearbeiten) {
		this.kBearbeiten = kBearbeiten;
	}

	public JLabel getDaten() {
		return daten;
	}

	public void setDaten(JLabel daten) {
		this.daten = daten;
	}

	public JButton getkAendern() {
		return kAendern;
	}

	public void setkAendern(JButton kAendern) {
		this.kAendern = kAendern;
	}

	public JButton getkLoeschen() {
		return kLoeschen;
	}

	public void setkLoeschen(JButton kLoeschen) {
		this.kLoeschen = kLoeschen;
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
