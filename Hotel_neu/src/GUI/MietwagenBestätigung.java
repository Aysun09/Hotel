package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Anwendung.AktionAnzeigen;
import Anwendung.AktionenGesamtBuchungAnlegen;
import Anwendung.AktionenMietwagenBestätigung;
import Anwendung.AktionenZimmerBuchen;
import Anwendung.PreisBerechnung;
import Datenbank.Datenbankbefehle;

public class MietwagenBestätigung extends JPanel {

	private JPanel mietwagenBuchen;
	JLabel ueberschrift, datenKu, datenMi, gesamtPreis;
	JTextField textGesamtPreis;
	JTable zimmer, mietwagen;
	JButton abbrechen, bestaetigen;
	AktionAnzeigen kAnzeige, mAnzeige;
	PreisBerechnung preisBerechnung = new PreisBerechnung();
	boolean mietwagenGebucht;
	String preis;

	public AktionAnzeigen getkAnzeige() {
		return kAnzeige;
	}

	public void setkAnzeige(AktionAnzeigen kAnzeige) {
		this.kAnzeige = kAnzeige;
	}

	public AktionAnzeigen getmAnzeige() {
		return mAnzeige;
	}

	public void setmAnzeige(AktionAnzeigen mAnzeige) {
		this.mAnzeige = mAnzeige;
	}

	public String getPreis() {
		return preis;
	}

	public void setPreis(String preis) {
		this.preis = preis;
	}

	public MietwagenBestätigung() {

		this.buildGUI();
	}

	public void buildGUI() {

		// Panel erstellen
		mietwagenBuchen = new JPanel();
		mietwagenBuchen.setLayout(null);
		this.add(mietwagenBuchen);
		mietwagenBuchen.setBackground(Color.white);
		mietwagenBuchen.setPreferredSize(new Dimension(1000, 700));
		mietwagenBuchen.setVisible(true);

		// Buchungsbestätigung
		ueberschrift = new JLabel("Mietwagen Buchungsbestätigung");
		ueberschrift.setBounds(50, 30, 500, 50);
		ueberschrift.setFont(new Font("Arial", Font.BOLD, 26));
		mietwagenBuchen.add(ueberschrift);

		// Überschrift Kunden
		datenKu = new JLabel("Kundendaten");
		datenKu.setBounds(50, 100, 500, 20);
		datenKu.setFont(new Font("Arial", Font.BOLD, 20));
		mietwagenBuchen.add(datenKu);

		// JTable Kunden
		kAnzeige = new AktionAnzeigen(Datenbankbefehle.kuBuchungAnzeige());
		JScrollPane scrollPane = new JScrollPane(kAnzeige.getSQLTable());
		scrollPane.setBounds(50, 130, 850, 35);
		mietwagenBuchen.add(scrollPane);

		// Überschrift Mietwagendaten
		datenMi = new JLabel("Mietwagen");
		datenMi.setBounds(50, 280, 500, 20);
		datenMi.setFont(new Font("Arial", Font.BOLD, 20));
		mietwagenBuchen.add(datenMi);

		// JTable für Mietwagen
		mAnzeige = new AktionAnzeigen(Datenbankbefehle.miBuchungAnzeige());
		JScrollPane scrollPane2 = new JScrollPane(mAnzeige.getSQLTable());
		scrollPane2.setBounds(50, 310, 850, 35);
		mietwagenBuchen.add(scrollPane2);

		// JLabel Preis
		gesamtPreis = new JLabel("Preis");
		gesamtPreis.setBounds(50, 400, 200, 20);
		gesamtPreis.setFont(new Font("Arial", Font.BOLD, 20));
		mietwagenBuchen.add(gesamtPreis);

		// JTextField Preis

		this.preis = preisBerechnung.getNurMietwagenGebucht();
		JTextField textGesamtPreis = new JTextField(preis);
		textGesamtPreis.setBounds(300, 400, 200, 20);
		textGesamtPreis.setFont(new Font("Arial", Font.BOLD, 16));
		mietwagenBuchen.add(textGesamtPreis);

		// JButton Abbrechen
		JButton abbrechen = new JButton("Abbrechen");
		abbrechen.setBounds(600, 500, 130, 50);
		abbrechen.setFont(new Font("Arial", Font.BOLD, 16));
		abbrechen.setActionCommand("ABBRECHEN");
		abbrechen.addActionListener(new AktionenMietwagenBestätigung(this));
		mietwagenBuchen.add(abbrechen);

		// JButton Bestätigen
		bestaetigen = new JButton("Bestätigen");
		bestaetigen.setBounds(800, 500, 130, 50);
		bestaetigen.setFont(new Font("Arial", Font.BOLD, 16));
		bestaetigen.setActionCommand("BESTAETIGEN");
		bestaetigen.addActionListener(new AktionenMietwagenBestätigung(this));
		mietwagenBuchen.add(bestaetigen);
	}

}
