package GUI;

import javax.swing.*;

import Anwendung.AktionenMietwagenAnlegen;

import java.awt.*;

public class MietwagenAnlegen extends JPanel {

	private JPanel wagenAnlegen;
	JLabel daten, typ, kfz, preis;
	JComboBox wagenBox;
	JTextField textKfz, textPreis;
	JButton back, speichern;

	public MietwagenAnlegen() {

		buildGUI();
	}

	public void buildGUI() {

		// neues JPanel erstellen
		wagenAnlegen = new JPanel();
		wagenAnlegen.setLayout(null);
		this.add(wagenAnlegen);
		wagenAnlegen.setBackground(Color.white);
		wagenAnlegen.setPreferredSize(new Dimension(1000, 700));
		wagenAnlegen.setVisible(true);

		// JLabel Mietwagendaten
		daten = new JLabel("Mietwagendaten");
		daten.setBounds(50, 30, 400, 50);
		daten.setFont(new Font("Arial", Font.BOLD, 30));
		wagenAnlegen.add(daten);

		// JLabel KFZ-Kennzeichen
		kfz = new JLabel("KFZ-Kennzeichen");
		kfz.setBounds(50, 150, 200, 30);
		kfz.setFont(new Font("Arial", Font.PLAIN, 20));
		wagenAnlegen.add(kfz);

		// JTextField KFZ-Kennzeichen
		textKfz = new JTextField();
		textKfz.setBounds(300, 150, 200, 30);
		textKfz.setFont(new Font("Arial", Font.PLAIN, 16));
		wagenAnlegen.add(textKfz);

		// JLabel Mietwagentyp
		typ = new JLabel("Mietwagentyp");
		typ.setBounds(50, 220, 200, 30);
		typ.setFont(new Font("Arial", Font.PLAIN, 20));
		wagenAnlegen.add(typ);

		// JComboBox Mietwagentyp
		String[] box = new String[] { "Mietwagentyp", "Cabrio", "Geländewagen",
				"Sportwagen", "Kombi", "Kleinwagen", "Mittelklasse",
				"Oberklasse" };
		wagenBox = new JComboBox(box);
		wagenBox.setBounds(300, 220, 200, 30);
		wagenBox.setFont(new Font("Arial", Font.PLAIN, 16));
		wagenAnlegen.add(wagenBox);

		// JLabel Preis
		preis = new JLabel("Mietwagenpreis");
		preis.setBounds(50, 290, 200, 30);
		preis.setFont(new Font("Arial", Font.PLAIN, 20));
		wagenAnlegen.add(preis);

		// JTextField Preis
		textPreis = new JTextField();
		textPreis.setBounds(300, 290, 200, 30);
		textPreis.setFont(new Font("Arial", Font.PLAIN, 16));
		wagenAnlegen.add(textPreis);

		// JButton Speichern
		speichern = new JButton("Speichern");
		speichern.setBounds(650, 400, 130, 50);
		speichern.setActionCommand("MIETWAGENSPEICHERN");
		speichern.addActionListener(new AktionenMietwagenAnlegen(this));
		speichern.setFont(new Font("Arial", Font.BOLD, 16));
		wagenAnlegen.add(speichern);

	}

	public JPanel getWagenAnlegen() {
		return wagenAnlegen;
	}

	public void setWagenAnlegen(JPanel wagenAnlegen) {
		this.wagenAnlegen = wagenAnlegen;
	}

	public JLabel getDaten() {
		return daten;
	}

	public void setDaten(JLabel daten) {
		this.daten = daten;
	}

	public JLabel getTyp() {
		return typ;
	}

	public void setTyp(JLabel typ) {
		this.typ = typ;
	}

	public JLabel getKfz() {
		return kfz;
	}

	public void setKfz(JLabel kfz) {
		this.kfz = kfz;
	}

	public JLabel getPreis() {
		return preis;
	}

	public void setPreis(JLabel preis) {
		this.preis = preis;
	}

	public JComboBox getWagenBox() {
		return wagenBox;
	}

	public void setWagenBox(JComboBox wagenBox) {
		this.wagenBox = wagenBox;
	}

	public JTextField getTextKfz() {
		return textKfz;
	}

	public void setTextKfz(JTextField textKfz) {
		this.textKfz = textKfz;
	}

	public JTextField getTextPreis() {
		return textPreis;
	}

	public void setTextPreis(JTextField textPreis) {
		this.textPreis = textPreis;
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
