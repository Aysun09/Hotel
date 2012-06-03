package Anwendung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GUI.GesamtBuchungBearbeiten;
import GUI.KundeAnlegen;
import GUI.KundeBearbeiten;
import GUI.MainFrame;
import GUI.MietwagenAnlegen;
import GUI.MietwagenBearbeiten;
import GUI.MietwagenBuchen;
import GUI.Start;
import GUI.ZimmerAnlegen;
import GUI.ZimmerBearbeiten;
import GUI.ZimmerBuchen;

public class AktionenMainFrame implements ActionListener {

	public MainFrame aFrame;

	public AktionenMainFrame(MainFrame a) {
		aFrame = a;
	}

	// Aktionen der Klasse MainFrame ausführen
	public void actionPerformed(ActionEvent e) {

		// Instanzen der Panels
		Start start = new Start();

		MietwagenAnlegen waAnlegen = new MietwagenAnlegen();
		ZimmerAnlegen ziAnlegen = new ZimmerAnlegen();
		KundeAnlegen kuAnlegen = new KundeAnlegen();

		KundeBearbeiten kuBearbeiten = new KundeBearbeiten();
		ZimmerBearbeiten ziBearbeiten = new ZimmerBearbeiten();
		MietwagenBearbeiten miBearbeiten = new MietwagenBearbeiten();
		GesamtBuchungBearbeiten buBearbeiten = new GesamtBuchungBearbeiten();

		ZimmerBuchen ziBuchen = new ZimmerBuchen();
		MietwagenBuchen miBuchen = new MietwagenBuchen(true);

		System.out.println("Aktion: " + e.getActionCommand());

		// Aktionen Home und Beenden
		if (e.getActionCommand().equals("HOME")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(new Start());
		}
		if (e.getActionCommand().equals("BEENDEN")) {

			Object[] options = { "Ja", "Nein" };

			int n = JOptionPane.showOptionDialog(null,
					"Möchten Sie das Programm wirklich beenden?", "Exit",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			if (n == JOptionPane.YES_OPTION) {
				System.exit(0);
			} else {
				MainFrame.frame.setContentPane(start);
			}
		}

		// Aktionen Anlegen
		if (e.getActionCommand().equals("KUNDEANLEGEN")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(kuAnlegen);
		}
		if (e.getActionCommand().equals("ZIMMERANLEGEN")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(ziAnlegen);
		}
		if (e.getActionCommand().equals("MIETWAGENANLEGEN")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(waAnlegen);
		}

		// Aktionen Bearbeiten
		if (e.getActionCommand().equals("KUNDEBEARBEITEN")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(kuBearbeiten);
		}
		if (e.getActionCommand().equals("ZIMMERBEARBEITEN")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(ziBearbeiten);
		}
		if (e.getActionCommand().equals("MIETWAGENBEARBEITEN")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(miBearbeiten);
		}
		if (e.getActionCommand().equals("BUCHUNGBEARBEITEN")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(buBearbeiten);
		}

		// Aktionen Buchen
		if (e.getActionCommand().equals("ZIMMERBUCHEN")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(ziBuchen);
		}
		if (e.getActionCommand().equals("MIETWAGENBUCHEN")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(miBuchen);
		}
	}

}
