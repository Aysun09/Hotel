package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Anwendung.AktionenMainFrame;

public class MainFrame extends JFrame {

	public static MainFrame frame = new MainFrame();

	public MainFrame() {

		setTitle("Hotelmanager 2012");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 700);
		buildMenu();
		setVisible(true);
	}

	private void buildMenu() {

		// Menübar anlegen
		JMenuBar bar = new JMenuBar();
		bar.setLayout(new GridLayout());
		setJMenuBar(bar);

		// Überpunkte anlegen
		JMenuItem home = new JMenuItem("Home");
		home.setActionCommand("HOME");
		home.addActionListener(new AktionenMainFrame(this));
		bar.add(home);
		JMenu anlegen = new JMenu("Anlegen");
		bar.add(anlegen);
		JMenu anzeigen = new JMenu("Anzeigen");
		bar.add(anzeigen);
		JMenu buchen = new JMenu("Buchen");
		bar.add(buchen);
		JMenuItem beenden = new JMenuItem("Beenden");
		beenden.setActionCommand("BEENDEN");
		beenden.addActionListener(new AktionenMainFrame(this));
		bar.add(beenden);

		// Unterpunkte "Anlegen"
		JMenuItem kundeAnlegen = new JMenuItem("Kunde");
		kundeAnlegen.setActionCommand("KUNDEANLEGEN");
		kundeAnlegen.addActionListener(new AktionenMainFrame(this));
		anlegen.add(kundeAnlegen);

		JMenuItem zimmerAnlegen = new JMenuItem("Zimmer");
		zimmerAnlegen.setActionCommand("ZIMMERANLEGEN");
		zimmerAnlegen.addActionListener(new AktionenMainFrame(this));
		anlegen.add(zimmerAnlegen);

		JMenuItem mietwagenAnlegen = new JMenuItem("Mietwagen");
		mietwagenAnlegen.setActionCommand("MIETWAGENANLEGEN");
		mietwagenAnlegen.addActionListener(new AktionenMainFrame(this));
		anlegen.add(mietwagenAnlegen);

		// Unterpunkte "Bearbeiten"
		JMenuItem kundeBearbeiten = new JMenuItem("Kunde");
		kundeBearbeiten.setActionCommand("KUNDEBEARBEITEN");
		kundeBearbeiten.addActionListener(new AktionenMainFrame(this));
		anzeigen.add(kundeBearbeiten);

		JMenuItem zimmerBearbeiten = new JMenuItem("Zimmer");
		zimmerBearbeiten.setActionCommand("ZIMMERBEARBEITEN");
		zimmerBearbeiten.addActionListener(new AktionenMainFrame(this));
		anzeigen.add(zimmerBearbeiten);

		JMenuItem mietwagenBearbeiten = new JMenuItem("Mietwagen");
		mietwagenBearbeiten.setActionCommand("MIETWAGENBEARBEITEN");
		mietwagenBearbeiten.addActionListener(new AktionenMainFrame(this));
		anzeigen.add(mietwagenBearbeiten);

		JMenuItem buchungBearbeiten = new JMenuItem("Buchung");
		buchungBearbeiten.setActionCommand("BUCHUNGBEARBEITEN");
		buchungBearbeiten.addActionListener(new AktionenMainFrame(this));
		anzeigen.add(buchungBearbeiten);

		// Unterpunkte "Buchen"
		JMenuItem zimmerBuchen = new JMenuItem("Zimmer");
		zimmerBuchen.setActionCommand("ZIMMERBUCHEN");
		zimmerBuchen.addActionListener(new AktionenMainFrame(this));
		buchen.add(zimmerBuchen);

		JMenuItem mietwagenBuchen = new JMenuItem("Mietwagen");
		mietwagenBuchen.setActionCommand("MIETWAGENBUCHEN");
		mietwagenBuchen.addActionListener(new AktionenMainFrame(this));
		buchen.add(mietwagenBuchen);

	}

	// Start des Programms
	public static void main(String[] args) {
		frame.setContentPane(new Start());
	}
}
