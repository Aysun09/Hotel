package GUI;

import javax.swing.*;

import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Anwendung.AktionenKundeAnlegen;
import Anwendung.AktionenKundeBearbeiten;
import Anwendung.AktionenMietwagenAnlegen;
import Datenbank.Kunde;

public class KundeAendern extends JPanel {

	private JPanel kundeAendern;
	JLabel daten, kid, anrede, name, vorname, strasse, plz, ort, gdatum,
			telefon;
	static JTextField textKid;
	static JTextField textAnrede;
	static JTextField textName;
	static JTextField textVorname;
	static JTextField textStrasse;
	static JTextField textPLZ;
	static JTextField textOrt;
	static JTextField textDatum;
	static JTextField textTelefon;
	JButton back, speichern, buchung;
	AktionenKundeBearbeiten kBearbeiten = new AktionenKundeBearbeiten();
	Kunde kunde;

	public KundeAendern(Kunde k) {
		this.kunde = k;
		buildGui();
	}

	public void buildGui() {

		// neues Panel erstellen
		kundeAendern = new JPanel();
		kundeAendern.setLayout(null);
		this.add(kundeAendern);
		kundeAendern.setBackground(Color.white);
		kundeAendern.setPreferredSize(new Dimension(1000, 700));
		kundeAendern.setVisible(true);

		// Überschrift Kundendaten
		daten = new JLabel("Kundendaten");
		daten.setBounds(50, 30, 200, 30);
		daten.setFont(new Font("Arial", Font.BOLD, 30));
		kundeAendern.add(daten);

		// JLabel KundenID
		kid = new JLabel("KundenID");
		kid.setBounds(50, 100, 200, 30);
		kid.setFont(new Font("Arial", Font.PLAIN, 18));
		kundeAendern.add(kid);

		// JTextField für KundenID
		String kundenID = String.valueOf(kunde.getKundenid());
		textKid = new JTextField(kundenID);
		textKid.setBounds(300, 100, 50, 30);
		textKid.setFont(new Font("Arial", Font.PLAIN, 16));
		textKid.setEditable(false);
		kundeAendern.add(textKid);

		// JLabel Anrede
		anrede = new JLabel("Anrede");
		anrede.setBounds(50, 150, 200, 30);
		anrede.setFont(new Font("Arial", Font.PLAIN, 18));
		kundeAendern.add(anrede);

		// JTextField Anrede
		String anrede = kunde.getAnrede();
		textAnrede = new JTextField(anrede);
		textAnrede.setBounds(300, 150, 200, 30);
		textAnrede.setFont(new Font("Arial", Font.PLAIN, 16));
		kundeAendern.add(textAnrede);

		// JLabel Name
		name = new JLabel("Name");
		name.setBounds(50, 200, 200, 30);
		name.setFont(new Font("Arial", Font.PLAIN, 18));
		kundeAendern.add(name);

		// JTextField für Name
		String name = kunde.getName();
		textName = new JTextField(name);
		textName.setBounds(300, 200, 350, 30);
		textName.setFont(new Font("Arial", Font.PLAIN, 16));
		kundeAendern.add(textName);

		// JLabel Vorname
		vorname = new JLabel("Vorname");
		vorname.setBounds(50, 250, 200, 30);
		vorname.setFont(new Font("Arial", Font.PLAIN, 18));
		kundeAendern.add(vorname);

		// JTextField für Vorname
		String vorname = kunde.getVorname();
		textVorname = new JTextField(vorname);
		textVorname.setBounds(300, 250, 350, 30);
		textVorname.setFont(new Font("Arial", Font.PLAIN, 16));
		kundeAendern.add(textVorname);

		// JLabel Straße, Hausnummer
		strasse = new JLabel("Straße, HsNr");
		strasse.setBounds(50, 300, 200, 30);
		strasse.setFont(new Font("Arial", Font.PLAIN, 18));
		kundeAendern.add(strasse);

		// JTextField für Straße, HsNr
		String strasse = kunde.getStrasse();
		textStrasse = new JTextField(strasse);
		textStrasse.setBounds(300, 300, 350, 30);
		textStrasse.setFont(new Font("Arial", Font.PLAIN, 16));
		kundeAendern.add(textStrasse);

		// JLabel PLZ
		plz = new JLabel("PLZ");
		plz.setBounds(50, 350, 100, 30);
		plz.setFont(new Font("Arial", Font.PLAIN, 18));
		kundeAendern.add(plz);

		// JTextField PLZ
		int plz1 = kunde.getPlz();
		String plz2 = String.valueOf(plz1);
		textPLZ = new JTextField(plz2);
		textPLZ.setBounds(100, 350, 150, 30);
		textPLZ.setFont(new Font("Arial", Font.PLAIN, 16));
		kundeAendern.add(textPLZ);

		// JLabel Ort
		ort = new JLabel("Ort");
		ort.setBounds(300, 350, 200, 30);
		ort.setFont(new Font("Arial", Font.PLAIN, 18));
		kundeAendern.add(ort);

		// JTextField Ort
		String ort = kunde.getOrt();
		textOrt = new JTextField(ort);
		textOrt.setBounds(340, 350, 350, 30);
		textOrt.setFont(new Font("Arial", Font.PLAIN, 16));
		kundeAendern.add(textOrt);

		// JLabel Geburstdatum
		gdatum = new JLabel("Geburtsdatum");
		gdatum.setBounds(50, 400, 400, 30);
		gdatum.setFont(new Font("Arial", Font.PLAIN, 18));
		kundeAendern.add(gdatum);

		// TextField für Geburtsdatum
		String gdatum = kunde.getGdatum();
		textDatum = new JTextField(gdatum);
		textDatum.setBounds(300, 400, 350, 30);
		textDatum.setFont(new Font("Arial", Font.PLAIN, 16));
		kundeAendern.add(textDatum);

		// JLabel Telefon
		telefon = new JLabel("Telefonnummer");
		telefon.setBounds(50, 450, 400, 30);
		telefon.setFont(new Font("Arial", Font.PLAIN, 18));
		kundeAendern.add(telefon);

		// TextField für Telefon
		String telefon = kunde.getTelefonnummer();
		textTelefon = new JTextField(telefon);
		textTelefon.setBounds(300, 450, 350, 30);
		textTelefon.setFont(new Font("Arial", Font.PLAIN, 16));
		kundeAendern.add(textTelefon);

		// JButton Zurück
		back = new JButton("Zurück");
		back.setBounds(390, 550, 130, 50);
		back.setFont(new Font("Arial", Font.BOLD, 16));
		back.setActionCommand("ZURUECK");
		back.addActionListener(new AktionenKundeBearbeiten(this));
		kundeAendern.add(back);

		// JButton Speichern
		speichern = new JButton("Speichern");
		speichern.setBounds(700, 550, 130, 50);
		speichern.setFont(new Font("Arial", Font.BOLD, 16));
		speichern.setActionCommand("KUNDEAENDERN");
		speichern.addActionListener(new AktionenKundeBearbeiten(this));
		kundeAendern.add(speichern);

	}

	public JPanel getKundeAnlegen() {
		return kundeAendern;
	}

	public void setKundeAendern(JPanel kundeAendern) {
		this.kundeAendern = kundeAendern;
	}

	public void setDaten(JLabel daten) {
		this.daten = daten;
	}

	public void setAnrede(JLabel anrede) {
		this.anrede = anrede;
	}

	public void setName(JLabel name) {
		this.name = name;
	}

	public void setVorname(JLabel vorname) {
		this.vorname = vorname;
	}

	public JLabel getStrasse() {
		return strasse;
	}

	public void setStrasse(JLabel strasse) {
		this.strasse = strasse;
	}

	public JLabel getPlz() {
		return plz;
	}

	public void setPlz(JLabel plz) {
		this.plz = plz;
	}

	public JLabel getOrt() {
		return ort;
	}

	public void setOrt(JLabel ort) {
		this.ort = ort;
	}

	public JLabel getGdatum() {
		return gdatum;
	}

	public void setGdatum(JLabel gdatum) {
		this.gdatum = gdatum;
	}

	public JLabel getTelefon() {
		return telefon;
	}

	public void setTelefon(JLabel telefon) {
		this.telefon = telefon;
	}

	public static JTextField getTextName() {
		return textName;
	}

	public void setTextName(JTextField textName) {
		this.textName = textName;
	}

	public static JTextField getTextVorname() {
		return textVorname;
	}

	public void setTextVorname(JTextField textVorname) {
		this.textVorname = textVorname;
	}

	public static JTextField getTextStrasse() {
		return textStrasse;
	}

	public void setTextStrasse(JTextField textStrasse) {
		this.textStrasse = textStrasse;
	}

	public static JTextField getTextPLZ() {
		return textPLZ;
	}

	public void setTextPLZ(JTextField textPLZ) {
		this.textPLZ = textPLZ;
	}

	public static JTextField getTextOrt() {
		return textOrt;
	}

	public void setTextOrt(JTextField textOrt) {
		this.textOrt = textOrt;
	}

	public static JTextField getTextDatum() {
		return textDatum;
	}

	public void setTextDatum(JTextField textDatum) {
		this.textDatum = textDatum;
	}

	public static JTextField getTextTelefon() {
		return textTelefon;
	}

	public void setTextTelefon(JTextField textTelefon) {
		this.textTelefon = textTelefon;
	}

	public static JTextField getTextAnrede() {
		return textAnrede;
	}

	public void setTextAnrede(JTextField textAnrede) {
		this.textAnrede = textAnrede;
	}

	public JLabel getAnrede() {
		return anrede;
	}

	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}

	public JButton getSpeichern() {
		return speichern;
	}

	public void setSpeichern(JButton speichern) {
		this.speichern = speichern;
	}

	public static JTextField getTextKid() {
		return textKid;
	}

	public static void setTextKid(JTextField textKid) {
		KundeAendern.textKid = textKid;
	}

}
