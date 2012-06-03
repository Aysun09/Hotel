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
import Anwendung.AktionenMietwagenAnlegen;
import Datenbank.Kunde;

public class KundeAnlegen extends JPanel {

	private JPanel kundeAnlegen;
	JLabel daten, anrede, name, vorname, strasse, plz, ort, gdatum, telefon;
	JTextField textName, textVorname, textStrasse, textPLZ, textOrt, textDatum,
			textTelefon;
	JComboBox anredeBox;
	JButton back, speichern, buchung;

	public KundeAnlegen() {
		buildGui();
	}

	public void buildGui() {

		// neues Panel erstellen
		kundeAnlegen = new JPanel();
		kundeAnlegen.setLayout(null);
		this.add(kundeAnlegen);
		kundeAnlegen.setBackground(Color.white);
		kundeAnlegen.setPreferredSize(new Dimension(1000, 700));
		kundeAnlegen.setVisible(true);

		// Überschrift Kundendaten
		daten = new JLabel("Kundendaten");
		daten.setBounds(50, 30, 200, 30);
		daten.setFont(new Font("Arial", Font.BOLD, 30));
		kundeAnlegen.add(daten);

		// JLabel Anrede
		anrede = new JLabel("Anrede");
		anrede.setBounds(50, 100, 200, 30);
		anrede.setFont(new Font("Arial", Font.PLAIN, 18));
		kundeAnlegen.add(anrede);

		// JComboBox Anrede
		String[] box = new String[] { "Anrede", "Frau", "Herr" };
		anredeBox = new JComboBox(box);
		anredeBox.setBounds(300, 100, 200, 30);
		anredeBox.setFont(new Font("Arial", Font.PLAIN, 16));
		kundeAnlegen.add(anredeBox);

		// JLabel Name
		name = new JLabel("Name");
		name.setBounds(50, 150, 200, 30);
		name.setFont(new Font("Arial", Font.PLAIN, 18));
		kundeAnlegen.add(name);

		// JTextField für Name
		textName = new JTextField("");
		textName.setBounds(300, 150, 350, 30);
		textName.setFont(new Font("Arial", Font.PLAIN, 16));
		kundeAnlegen.add(textName);
		// textName.setText(name.toString());

		// JLabel Vorname
		vorname = new JLabel("Vorname");
		vorname.setBounds(50, 200, 200, 30);
		vorname.setFont(new Font("Arial", Font.PLAIN, 18));
		kundeAnlegen.add(vorname);

		// JTextField für Vorname
		textVorname = new JTextField("");
		textVorname.setBounds(300, 200, 350, 30);
		textVorname.setFont(new Font("Arial", Font.PLAIN, 16));
		kundeAnlegen.add(textVorname);

		// JLabel Straße, Hausnummer
		strasse = new JLabel("Straße, HsNr");
		strasse.setBounds(50, 250, 200, 30);
		strasse.setFont(new Font("Arial", Font.PLAIN, 18));
		kundeAnlegen.add(strasse);

		// JTextField für Straße, HsNr
		textStrasse = new JTextField("");
		textStrasse.setBounds(300, 250, 350, 30);
		textStrasse.setFont(new Font("Arial", Font.PLAIN, 16));
		kundeAnlegen.add(textStrasse);

		// JLabel PLZ
		plz = new JLabel("PLZ");
		plz.setBounds(50, 300, 100, 30);
		plz.setFont(new Font("Arial", Font.PLAIN, 18));
		kundeAnlegen.add(plz);

		// JTextField PLZ
		textPLZ = new JTextField("");
		textPLZ.setBounds(100, 300, 150, 30);
		textPLZ.setFont(new Font("Arial", Font.PLAIN, 16));
		kundeAnlegen.add(textPLZ);

		// JLabel Ort
		ort = new JLabel("Ort");
		ort.setBounds(300, 300, 200, 30);
		ort.setFont(new Font("Arial", Font.PLAIN, 18));
		kundeAnlegen.add(ort);

		// JTextField Ort
		textOrt = new JTextField("");
		textOrt.setBounds(340, 300, 350, 30);
		textOrt.setFont(new Font("Arial", Font.PLAIN, 16));
		kundeAnlegen.add(textOrt);

		// JLabel Geburstdatum
		gdatum = new JLabel("Geburtsdatum");
		gdatum.setBounds(50, 350, 400, 30);
		gdatum.setFont(new Font("Arial", Font.PLAIN, 18));
		kundeAnlegen.add(gdatum);

		// TextField für Geburtsdatum
		textDatum = new JTextField("");
		textDatum.setBounds(300, 350, 350, 30);
		textDatum.setFont(new Font("Arial", Font.PLAIN, 16));
		kundeAnlegen.add(textDatum);

		// JLabel Telefon
		telefon = new JLabel("Telefonnummer");
		telefon.setBounds(50, 400, 400, 30);
		telefon.setFont(new Font("Arial", Font.PLAIN, 18));
		kundeAnlegen.add(telefon);

		// TextField für Telefon
		textTelefon = new JTextField("");
		textTelefon.setBounds(300, 400, 350, 30);
		textTelefon.setFont(new Font("Arial", Font.PLAIN, 16));
		kundeAnlegen.add(textTelefon);

		// JButton Zur Buchung
		buchung = new JButton("Zur Buchung");
		buchung.setBounds(535, 500, 150, 50);
		buchung.setFont(new Font("Arial", Font.BOLD, 16));
		buchung.setActionCommand("BUCHUNG");
		buchung.addActionListener(new AktionenKundeAnlegen(this));
		kundeAnlegen.add(buchung);

		// JButton Speichern
		speichern = new JButton("Speichern");
		speichern.setBounds(750, 500, 130, 50);
		speichern.setFont(new Font("Arial", Font.BOLD, 16));
		speichern.setActionCommand("KUNDESPEICHERN");
		speichern.addActionListener(new AktionenKundeAnlegen(this));
		kundeAnlegen.add(speichern);

	}

	public JPanel getKundeAnlegen() {
		return kundeAnlegen;
	}

	public void setKundeAnlegen(JPanel kundeAnlegen) {
		this.kundeAnlegen = kundeAnlegen;
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

	public JTextField getTextName() {
		return textName;
	}

	public void setTextName(JTextField textName) {
		this.textName = textName;
	}

	public JTextField getTextVorname() {
		return textVorname;
	}

	public void setTextVorname(JTextField textVorname) {
		this.textVorname = textVorname;
	}

	public JTextField getTextStrasse() {
		return textStrasse;
	}

	public void setTextStrasse(JTextField textStrasse) {
		this.textStrasse = textStrasse;
	}

	public JTextField getTextPLZ() {
		return textPLZ;
	}

	public void setTextPLZ(JTextField textPLZ) {
		this.textPLZ = textPLZ;
	}

	public JTextField getTextOrt() {
		return textOrt;
	}

	public void setTextOrt(JTextField textOrt) {
		this.textOrt = textOrt;
	}

	public JTextField getTextDatum() {
		return textDatum;
	}

	public void setTextDatum(JTextField textDatum) {
		this.textDatum = textDatum;
	}

	public JTextField getTextTelefon() {
		return textTelefon;
	}

	public void setTextTelefon(JTextField textTelefon) {
		this.textTelefon = textTelefon;
	}

	public JComboBox getAnredeBox() {
		return anredeBox;
	}

	public void setAnredeBox(JComboBox anredeBox) {
		this.anredeBox = anredeBox;
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

}
