package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Anwendung.AktionAnzeigen;
import Anwendung.AktionenZimmerBuchen;
import Datenbank.Datenbankbefehle;

public class ZimmerBuchen extends JPanel {

	private JPanel ziBuchen;
	JLabel datenZi, datenKu, anreise, abreise;
	JTable zimmer, kunden;
	Calendar anreiseCalendar, abreiseCalendar;
	JButton zurueck, neuerKunde, weiter;
	AktionAnzeigen zAnzeige, kAnzeige;

	public ZimmerBuchen() {

		this.buildGUI();
	}

	public void buildGUI() {

		// Panel erstellen
		ziBuchen = new JPanel();
		ziBuchen.setLayout(null);
		this.add(ziBuchen);
		ziBuchen.setBackground(Color.white);
		ziBuchen.setPreferredSize(new Dimension(1000, 700));
		ziBuchen.setVisible(true);

		// Überschrift Kunden
		datenKu = new JLabel("Bitte wählen Sie einen Kunden aus");
		datenKu.setBounds(50, 35, 500, 20);
		datenKu.setFont(new Font("Arial", Font.BOLD, 20));
		ziBuchen.add(datenKu);

		// JTable für Kunden
		kAnzeige = new AktionAnzeigen(Datenbankbefehle.kundenAnzeigen());
		JScrollPane scrollPane2 = new JScrollPane(kAnzeige.getSQLTable());
		scrollPane2.setBounds(50, 90, 850, 130);
		ziBuchen.add(scrollPane2);

		// JButton "Kunde anlegen"
		neuerKunde = new JButton("Neuer Kunde");
		neuerKunde.setBounds(500, 28, 150, 40);
		neuerKunde.setFont(new Font("Arial", Font.BOLD, 16));
		neuerKunde.setActionCommand("KANLEGEN");
		neuerKunde.addActionListener(new AktionenZimmerBuchen(this));
		ziBuchen.add(neuerKunde);

		// Überschrift Zimmer
		datenZi = new JLabel("Bitte wählen Sie ein Zimmer aus");
		datenZi.setBounds(50, 270, 500, 20);
		datenZi.setFont(new Font("Arial", Font.BOLD, 20));
		ziBuchen.add(datenZi);

		// JTable für Zimmer
		zAnzeige = new AktionAnzeigen(Datenbankbefehle.ziAuswahlAnzeigen());
		JScrollPane scrollPane = new JScrollPane(zAnzeige.getSQLTable());
		scrollPane.setBounds(50, 310, 850, 130);
		ziBuchen.add(scrollPane);

		// JLabel Anreisedatum
		anreise = new JLabel("Anreisedatum");
		anreise.setBounds(50, 480, 200, 20);
		anreise.setFont(new Font("Arial", Font.BOLD, 16));
		ziBuchen.add(anreise);

		// Calendar Abreisedatum
		anreiseCalendar = Calendar.getInstance();

		
		// JLabel Buchungsdatum
		
		
		// JTextField Buchungsdatum

		// JButton "Weiter"
		weiter = new JButton("Weiter");
		weiter.setBounds(750, 500, 130, 50);
		weiter.setFont(new Font("Arial", Font.BOLD, 16));
		weiter.setActionCommand("WEITER");
		weiter.addActionListener(new AktionenZimmerBuchen(this));
		ziBuchen.add(weiter);
	}

	public JPanel getZiBuchen() {
		return ziBuchen;
	}

	public void setZiBuchen(JPanel ziBuchen) {
		this.ziBuchen = ziBuchen;
	}

	public JLabel getDatenZi() {
		return datenZi;
	}

	public void setDatenZi(JLabel datenZi) {
		this.datenZi = datenZi;
	}

	public JLabel getDatenKu() {
		return datenKu;
	}

	public void setDatenKu(JLabel datenKu) {
		this.datenKu = datenKu;
	}

	public JTable getZimmer() {
		return zimmer;
	}

	public void setZimmer(JTable zimmer) {
		this.zimmer = zimmer;
	}

	public JTable getKunden() {
		return kunden;
	}

	public void setKunden(JTable kunden) {
		this.kunden = kunden;
	}

	public JButton getZurueck() {
		return zurueck;
	}

	public void setZurueck(JButton zurueck) {
		this.zurueck = zurueck;
	}

	public JButton getNeuerKunde() {
		return neuerKunde;
	}

	public void setNeuerKunde(JButton neuerKunde) {
		this.neuerKunde = neuerKunde;
	}

	public JButton getWeiter() {
		return weiter;
	}

	public void setWeiter(JButton weiter) {
		this.weiter = weiter;
	}

	public AktionAnzeigen getzAnzeige() {
		return zAnzeige;
	}

	public void setzAnzeige(AktionAnzeigen zAnzeige) {
		this.zAnzeige = zAnzeige;
	}

	public AktionAnzeigen getkAnzeige() {
		return kAnzeige;
	}

	public void setkAnzeige(AktionAnzeigen kAnzeige) {
		this.kAnzeige = kAnzeige;
	}

	public JLabel getDauer() {
		return dauer;
	}

	public void setDauer(JLabel dauer) {
		this.dauer = dauer;
	}

	public JTextField getTextDauer() {
		return textDauer;
	}

	public void setTextDauer(JTextField textDauer) {
		this.textDauer = textDauer;
	}

}
