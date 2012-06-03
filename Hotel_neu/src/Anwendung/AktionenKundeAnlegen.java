package Anwendung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Datenbank.Kunde;
import Datenbank.Zimmer;
import GUI.KundeAnlegen;
import GUI.KundeBearbeiten;
import GUI.MainFrame;
import GUI.Start;
import GUI.ZimmerAnlegen;
import GUI.ZimmerBearbeiten;
import GUI.ZimmerBuchen;

public class AktionenKundeAnlegen implements ActionListener {

	public KundeAnlegen kAnlegen;
	public static Connection conn = null;

	public AktionenKundeAnlegen(KundeAnlegen k) {
		kAnlegen = k;
	}

	public boolean executeQuery(String SQLquery) {

		try {
			// Datenbankverbindung aufbauen
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
					+ "hotelprojekt?user=root&password=init");

			Statement st = conn.createStatement();
			st.execute(SQLquery);
			st.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(), e);
		}
		return true;

	}

	public void addKunde(int i) throws HotelException {

		Kunde kunde;

		try {

			String anrede = (String) kAnlegen.getAnredeBox().getSelectedItem();
			String name = (String) kAnlegen.getTextName().getText();
			String vorname = (String) kAnlegen.getTextVorname().getText();
			String strasse = (String) kAnlegen.getTextStrasse().getText();
			String ort = (String) kAnlegen.getTextOrt().getText();
			int plz = Integer.parseInt(kAnlegen.getTextPLZ().getText());
			String gdatum = (String) kAnlegen.getTextDatum().getText();
			String telefonnummer = (String) kAnlegen.getTextTelefon().getText();

			kunde = new Kunde(anrede, name, vorname, strasse, plz, ort, gdatum,
					telefonnummer);

			String query = "INSERT INTO kunden(Anrede, Name, Vorname, Strasse, Ort, PLZ, Geburtsdatum, Telefon)"
					+ "VALUES('"
					+ kunde.getAnrede()
					+ "','"
					+ kunde.getName()
					+ "','"
					+ kunde.getVorname()
					+ "','"
					+ kunde.getStrasse()
					+ "','"
					+ kunde.getOrt()
					+ "',"
					+ kunde.getPlz()
					+ ",'"
					+ kunde.getGdatum()
					+ "','"
					+ kunde.getTelefonnummer()
					+ "')";

			boolean bool = this.executeQuery(query);
			if (bool) {
				kAnlegen.getTextName().setText(null);
				kAnlegen.getTextVorname().setText(null);
				kAnlegen.getTextStrasse().setText(null);
				kAnlegen.getTextPLZ().setText(null);
				kAnlegen.getTextOrt().setText(null);
				kAnlegen.getTextDatum().setText(null);
				kAnlegen.getTextTelefon().setText(null);

				JOptionPane.showMessageDialog(new JFrame(),
						"Folgender Kunde ist in die Datenbank eingefügt worden:\n"
								+ kunde.getName() + ", " + kunde.getVorname());

				// 1
				if (i == 1) {
					MainFrame.frame.getContentPane().setVisible(false);
					MainFrame.frame.setContentPane(new KundeBearbeiten());
				}

				// 2
				if (i == 2) {
					MainFrame.frame.getContentPane().setVisible(false);
					MainFrame.frame.setContentPane(new ZimmerBuchen());
				}
			}
		} catch (HotelException e1) {
			JOptionPane.showMessageDialog(new JFrame(), e1);
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(new JFrame(),
					"Bitte überprüfen Sie ihre eingegebene Postleitzahl!");
		}

	}

	// Kundenaktionen ausführen
	public void actionPerformed(ActionEvent e) {
		System.out.println("Aktion: " + e.getActionCommand());

		if (e.getActionCommand().equals("KUNDESPEICHERN")) {
			this.addKunde(1);
		}
		if (e.getActionCommand().equals("BUCHUNG")) {
			this.addKunde(2);
		}
		if (e.getActionCommand().equals("ZURUECK")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(new Start());
		}

	}

}
