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
import Anwendung.AktionenGesamtBuchungBearbeiten;
import Anwendung.AktionenZimmerBuchen;
import Anwendung.PreisBerechnung;
import Datenbank.Datenbankbefehle;

public class GesamtBuchungAnlegen extends JPanel {

	private JPanel gesamtBuchen;
	JLabel ueberschrift, datenKu, datenZi, datenMi, gesamtPreis;
	JTextField textGesamtPreis;
	JTable zimmer, mietwagen;
	JButton abbrechen, bestaetigen;
	AktionAnzeigen kAnzeige, zAnzeige, mAnzeige;
	PreisBerechnung preisBerechnung = new PreisBerechnung();
	boolean mietwagenGebucht;

	String preis;

	public GesamtBuchungAnlegen(boolean b) {

		this.mietwagenGebucht = b;
		this.buildGUI();
	}

	public void buildGUI() {

		// Panel erstellen
		gesamtBuchen = new JPanel();
		gesamtBuchen.setLayout(null);
		this.add(gesamtBuchen);
		gesamtBuchen.setBackground(Color.white);
		gesamtBuchen.setPreferredSize(new Dimension(1000, 700));
		gesamtBuchen.setVisible(true);

		// Buchungsbestätigung
		ueberschrift = new JLabel("Buchungsbestätigung");
		ueberschrift.setBounds(50, 30, 500, 50);
		ueberschrift.setFont(new Font("Arial", Font.BOLD, 26));
		gesamtBuchen.add(ueberschrift);

		// Überschrift Kunden
		datenKu = new JLabel("Kundendaten");
		datenKu.setBounds(50, 100, 500, 20);
		datenKu.setFont(new Font("Arial", Font.BOLD, 20));
		gesamtBuchen.add(datenKu);

		// JTable Kunden
		kAnzeige = new AktionAnzeigen(Datenbankbefehle.kuBuchungAnzeige());
		JScrollPane scrollPane = new JScrollPane(kAnzeige.getSQLTable());
		scrollPane.setBounds(50, 130, 850, 35);
		gesamtBuchen.add(scrollPane);

		// Überschrift Zimmerdaten
		datenZi = new JLabel("Zimmer");
		datenZi.setBounds(50, 190, 500, 20);
		datenZi.setFont(new Font("Arial", Font.BOLD, 20));
		gesamtBuchen.add(datenZi);

		// JTable für Zimmer
		zAnzeige = new AktionAnzeigen(Datenbankbefehle.ziBuchungAnzeige());
		JScrollPane scrollPane1 = new JScrollPane(zAnzeige.getSQLTable());
		scrollPane1.setBounds(50, 220, 850, 35);
		gesamtBuchen.add(scrollPane1);

		// Überschrift Mietwagendaten
		if (mietwagenGebucht) {
			datenMi = new JLabel("Mietwagen");
			datenMi.setBounds(50, 280, 500, 20);
			datenMi.setFont(new Font("Arial", Font.BOLD, 20));
			gesamtBuchen.add(datenMi);
		}

		// JTable für Mietwagen
		if (mietwagenGebucht) {
			mAnzeige = new AktionAnzeigen(Datenbankbefehle.miBuchungAnzeige());
			JScrollPane scrollPane2 = new JScrollPane(mAnzeige.getSQLTable());
			scrollPane2.setBounds(50, 310, 850, 35);
			gesamtBuchen.add(scrollPane2);
		}

		// JLabel Gesamtpreis
		gesamtPreis = new JLabel("Gesamtpreis");
		gesamtPreis.setBounds(50, 400, 200, 20);
		gesamtPreis.setFont(new Font("Arial", Font.BOLD, 20));
		gesamtBuchen.add(gesamtPreis);

		// JTextField Gesamtpreis
		if (mietwagenGebucht) {
			this.preis = preisBerechnung.getBuchungGesamtPreis();
		} else {
			this.preis = preisBerechnung.getNurZimmerGebucht();
		}
		JTextField textGesamtPreis = new JTextField(preis);
		textGesamtPreis.setBounds(300, 400, 200, 20);
		textGesamtPreis.setFont(new Font("Arial", Font.BOLD, 16));
		gesamtBuchen.add(textGesamtPreis);

		// JButton Abbrechen
		JButton abbrechen = new JButton("Abbrechen");
		abbrechen.setBounds(600, 500, 130, 50);
		abbrechen.setFont(new Font("Arial", Font.BOLD, 16));
		abbrechen.setActionCommand("ABBRECHEN");
		abbrechen.addActionListener(new AktionenGesamtBuchungAnlegen(this));
		gesamtBuchen.add(abbrechen);

		// JButton Bestätigen
		bestaetigen = new JButton("Bestätigen");
		bestaetigen.setBounds(800, 500, 130, 50);
		bestaetigen.setFont(new Font("Arial", Font.BOLD, 16));
		bestaetigen.setActionCommand("BESTAETIGEN");
		bestaetigen.addActionListener(new AktionenGesamtBuchungAnlegen(this));
		gesamtBuchen.add(bestaetigen);
	}

	public JPanel getGesamtBuchen() {
		return gesamtBuchen;
	}

	public void setGesamtBuchen(JPanel gesamtBuchen) {
		this.gesamtBuchen = gesamtBuchen;
	}

	public JLabel getUeberschrift() {
		return ueberschrift;
	}

	public void setUeberschrift(JLabel ueberschrift) {
		this.ueberschrift = ueberschrift;
	}

	public JLabel getDatenKu() {
		return datenKu;
	}

	public void setDatenKu(JLabel datenKu) {
		this.datenKu = datenKu;
	}

	public JLabel getDatenZi() {
		return datenZi;
	}

	public void setDatenZi(JLabel datenZi) {
		this.datenZi = datenZi;
	}

	public JLabel getDatenMi() {
		return datenMi;
	}

	public void setDatenMi(JLabel datenMi) {
		this.datenMi = datenMi;
	}

	public JLabel getGesamtPreis() {
		return gesamtPreis;
	}

	public void setGesamtPreis(JLabel gesamtPreis) {
		this.gesamtPreis = gesamtPreis;
	}

	public JTextField getTextGesamtPreis() {
		return textGesamtPreis;
	}

	public void setTextGesamtPreis(JTextField textGesamtPreis) {
		this.textGesamtPreis = textGesamtPreis;
	}

	public JTable getZimmer() {
		return zimmer;
	}

	public void setZimmer(JTable zimmer) {
		this.zimmer = zimmer;
	}

	public JTable getMietwagen() {
		return mietwagen;
	}

	public void setMietwagen(JTable mietwagen) {
		this.mietwagen = mietwagen;
	}

	public JButton getAbbrechen() {
		return abbrechen;
	}

	public void setAbbrechen(JButton abbrechen) {
		this.abbrechen = abbrechen;
	}

	public JButton getBestaetigen() {
		return bestaetigen;
	}

	public void setBestaetigen(JButton bestaetigen) {
		this.bestaetigen = bestaetigen;
	}

	public AktionAnzeigen getkAnzeige() {
		return kAnzeige;
	}

	public void setkAnzeige(AktionAnzeigen kAnzeige) {
		this.kAnzeige = kAnzeige;
	}

	public AktionAnzeigen getzAnzeige() {
		return zAnzeige;
	}

	public void setzAnzeige(AktionAnzeigen zAnzeige) {
		this.zAnzeige = zAnzeige;
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

	public boolean isMietwagenGebucht() {
		return mietwagenGebucht;
	}

	public void setMietwagenGebucht(boolean mietwagenGebucht) {
		this.mietwagenGebucht = mietwagenGebucht;
	}
}
