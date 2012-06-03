package GUI;

import javax.swing.*;

import Anwendung.AktionenZimmerAnlegen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ZimmerAnlegen extends JPanel {

	private JPanel zimmerAnlegen;
	JLabel daten, nummer, art, preis;
	JTextField textNr, textPreis;
	JComboBox zimmerBox;
	JButton back, speichern;

	public ZimmerAnlegen() {
		buildGUI();

	}

	// Aufbau der GUI
	public void buildGUI() {

		// neues Panel erstellen
		zimmerAnlegen = new JPanel();
		zimmerAnlegen.setLayout(null);
		this.add(zimmerAnlegen);
		zimmerAnlegen.setBackground(Color.white);
		zimmerAnlegen.setPreferredSize(new Dimension(1000, 700));
		zimmerAnlegen.setVisible(true);

		// Überschrift Zimmerdaten
		daten = new JLabel("Zimmerdaten");
		daten.setBounds(50, 30, 200, 30);
		daten.setFont(new Font("Arial", Font.BOLD, 30));
		zimmerAnlegen.add(daten);

		// JLabel Zimmernummer
		nummer = new JLabel("Zimmernummer");
		nummer.setBounds(50, 130, 200, 30);
		nummer.setFont(new Font("Arial", Font.PLAIN, 20));
		zimmerAnlegen.add(nummer);

		// JTextField für Zimmernummer
		textNr = new JTextField("");
		textNr.setBounds(300, 130, 150, 30);
		textNr.setFont(new Font("Arial", Font.PLAIN, 16));
		zimmerAnlegen.add(textNr);

		// JLabel Zimmerart
		art = new JLabel("Zimmerart");
		art.setBounds(50, 200, 200, 30);
		art.setFont(new Font("Arial", Font.PLAIN, 20));
		zimmerAnlegen.add(art);

		// JComboBox Zimmerart
		String[] box = new String[] { "Zimmerart", "Einzelzimmer",
				"Doppelzimmer" };
		zimmerBox = new JComboBox(box);
		zimmerBox.setBounds(300, 200, 200, 30);
		zimmerBox.setFont(new Font("Arial", Font.PLAIN, 16));
		zimmerAnlegen.add(zimmerBox);

		// JLabel Preis
		preis = new JLabel("Zimmerpreis");
		preis.setBounds(50, 270, 200, 30);
		preis.setFont(new Font("Arial", Font.PLAIN, 20));
		zimmerAnlegen.add(preis);

		// JTextField Preis
		textPreis = new JTextField("");
		textPreis.setBounds(300, 270, 150, 30);
		textPreis.setFont(new Font("Arial", Font.PLAIN, 16));
		zimmerAnlegen.add(textPreis);

		// JButton Speichern
		speichern = new JButton("Speichern");
		speichern.setBounds(650, 400, 130, 50);
		speichern.setActionCommand("ZIMMERSPEICHERN");
		speichern.addActionListener(new AktionenZimmerAnlegen(this));
		speichern.setFont(new Font("Arial", Font.BOLD, 16));
		zimmerAnlegen.add(speichern);

	}

	public JPanel getZimmerAnlegen() {
		return zimmerAnlegen;
	}

	public void setZimmerAnlegen(JPanel zimmerAnlegen) {
		this.zimmerAnlegen = zimmerAnlegen;
	}

	public JLabel getDaten() {
		return daten;
	}

	public void setDaten(JLabel daten) {
		this.daten = daten;
	}

	public JLabel getNummer() {
		return nummer;
	}

	public void setNummer(JLabel nummer) {
		this.nummer = nummer;
	}

	public JLabel getArt() {
		return art;
	}

	public void setArt(JLabel art) {
		this.art = art;
	}

	public JLabel getPreis() {
		return preis;
	}

	public void setPreis(JLabel preis) {
		this.preis = preis;
	}

	public JTextField getTextNr() {
		return textNr;
	}

	public void setTextNr(JTextField textNr) {
		this.textNr = textNr;
	}

	public JTextField getTextPreis() {
		return textPreis;
	}

	public void setTextPreis(JTextField textPreis) {
		this.textPreis = textPreis;
	}

	public JComboBox getZimmerBox() {
		return zimmerBox;
	}

	public void setZimmerBox(JComboBox zimmerBox) {
		this.zimmerBox = zimmerBox;
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
