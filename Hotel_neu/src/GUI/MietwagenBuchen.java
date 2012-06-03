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
import Anwendung.AktionenMietwagenBuchen;
import Datenbank.Datenbankbefehle;

public class MietwagenBuchen extends JPanel {

	private JPanel miBuchen;
	JLabel datenMi, datenKu, dauer;
	JTable mietwagen, kunden;
	JTextField textDauer;
	JButton zurueck, neuerKunde, weiter;
	AktionAnzeigen mAnzeige, kAnzeige;
	boolean überMenü;

	public MietwagenBuchen(boolean b) {
		this.überMenü = b;
		this.buildGUI();

	}

	// GUI falls Mietwagen ohne Zimmer gebucht wird
	public void buildGUI() {
		System.out.println(überMenü);
		// Panel erstellen
		miBuchen = new JPanel();
		miBuchen.setLayout(null);
		this.add(miBuchen);
		miBuchen.setBackground(Color.white);
		miBuchen.setPreferredSize(new Dimension(1000, 700));
		miBuchen.setVisible(true);

		// Überschrift Mietwagen
		datenMi = new JLabel("Bitte wählen Sie einen Mietwagen aus");
		datenMi.setBounds(50, 30, 500, 20);
		datenMi.setFont(new Font("Arial", Font.BOLD, 20));
		miBuchen.add(datenMi);

		// JTable für Mietwagen
		mAnzeige = new AktionAnzeigen(Datenbankbefehle.miAuswahlAnzeigen());
		JScrollPane scrollPane = new JScrollPane(mAnzeige.getSQLTable());
		scrollPane.setBounds(50, 60, 850, 150);
		miBuchen.add(scrollPane);

		// Überschrift Kunden
		datenKu = new JLabel("Bitte wählen Sie einen Kunden aus");
		datenKu.setBounds(50, 250, 500, 20);
		datenKu.setFont(new Font("Arial", Font.BOLD, 20));
		miBuchen.add(datenKu);

		// JTable für Kunden
		if (überMenü) {
			kAnzeige = new AktionAnzeigen(Datenbankbefehle.kuAuswahlAnzeigen1());
			JScrollPane scrollPane2 = new JScrollPane(kAnzeige.getSQLTable());
			scrollPane2.setBounds(50, 280, 850, 150);
			miBuchen.add(scrollPane2);
		} else {
			kAnzeige = new AktionAnzeigen(Datenbankbefehle.kuAuswahlAnzeigen2());
			JScrollPane scrollPane2 = new JScrollPane(kAnzeige.getSQLTable());
			scrollPane2.setBounds(50, 280, 850, 35);
			miBuchen.add(scrollPane2);
		}

		// JLabel Mietdauer
		if (überMenü) {
			dauer = new JLabel("Mietdauer");
			dauer.setBounds(50, 460, 200, 20);
			dauer.setFont(new Font("Arial", Font.BOLD, 16));
			miBuchen.add(dauer);
		} else {
			dauer = new JLabel("Mietdauer");
			dauer.setBounds(50, 360, 200, 20);
			dauer.setFont(new Font("Arial", Font.BOLD, 16));
			miBuchen.add(dauer);
		}

		// JTextField Mietdauer
		if (überMenü) {
			textDauer = new JTextField("");
			textDauer.setBounds(220, 460, 100, 20);
			textDauer.setFont(new Font("Arial", Font.PLAIN, 16));
			miBuchen.add(textDauer);
		} else {
			textDauer = new JTextField("");
			textDauer.setBounds(220, 360, 100, 20);
			textDauer.setFont(new Font("Arial", Font.PLAIN, 16));
			miBuchen.add(textDauer);
		}
		// JButton "Zurück
		if (überMenü) {
			JButton zurueck = new JButton("Zurück");
			zurueck.setBounds(500, 500, 130, 50);
			zurueck.setFont(new Font("Arial", Font.BOLD, 16));
			zurueck.setActionCommand("ZURUECK");
			zurueck.addActionListener(new AktionenMietwagenBuchen(this));
			miBuchen.add(zurueck);
		}

		// JButton "Weiter"
		if (überMenü) {
			weiter = new JButton("Weiter");
			weiter.setBounds(700, 500, 130, 50);
			weiter.setFont(new Font("Arial", Font.BOLD, 16));
			weiter.setActionCommand("WEITERZUMIBES");
			weiter.addActionListener(new AktionenMietwagenBuchen(this));
			miBuchen.add(weiter);
		} else {
			weiter = new JButton("Weiter");
			weiter.setBounds(700, 450, 130, 50);
			weiter.setFont(new Font("Arial", Font.BOLD, 16));
			weiter.setActionCommand("WEITERZUGESBES");
			weiter.addActionListener(new AktionenMietwagenBuchen(this));
			miBuchen.add(weiter);
		}
	}

	public JPanel getMiBuchen() {
		return miBuchen;
	}

	public void setMiBuchen(JPanel miBuchen) {
		this.miBuchen = miBuchen;
	}

	public JLabel getDatenMi() {
		return datenMi;
	}

	public void setDatenMi(JLabel datenMi) {
		this.datenMi = datenMi;
	}

	public JLabel getDatenKu() {
		return datenKu;
	}

	public void setDatenKu(JLabel datenKu) {
		this.datenKu = datenKu;
	}

	public JTable getMietwagen() {
		return mietwagen;
	}

	public void setMietwagen(JTable mietwagen) {
		this.mietwagen = mietwagen;
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

	public AktionAnzeigen getmAnzeige() {
		return mAnzeige;
	}

	public void setmAnzeige(AktionAnzeigen mAnzeige) {
		this.mAnzeige = mAnzeige;
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
