package Anwendung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Datenbank.Kunde;
import GUI.KundeAendern;
import GUI.KundeBearbeiten;
import GUI.MainFrame;
import GUI.Start;

public class AktionenKundeBearbeiten implements ActionListener {

	public KundeBearbeiten kBearbeiten;
	public KundeAendern kAendern;

	String kID;
	String anrede;
	String name;
	String vorname;
	String strasse;
	int plz;
	String ort;
	String geburtsdatum;
	String telefonnummer;

	public static Connection conn = null;

	public AktionenKundeBearbeiten() {

	}

	public AktionenKundeBearbeiten(KundeBearbeiten kB) {
		kBearbeiten = kB;
	}

	public AktionenKundeBearbeiten(KundeAendern kA) {
		kAendern = kA;
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

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(), e);
		}
		return true;
	}

	// Aktionen ausführen
	public void actionPerformed(ActionEvent e) {
		System.out.println("Aktion: " + e.getActionCommand());

		// Aktion Löschen
		if (e.getActionCommand().equals("KLOESCHEN")) {

			try {

				// Datenbankverbindung aufbauen
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/"
								+ "hotelprojekt?user=root&password=init");

				// KundenID aus JTable in String speichern
				String kundenID = (String) kBearbeiten
						.getAnzeige()
						.getSQLTable()
						.getValueAt(
								kBearbeiten.getAnzeige().getSQLTable()
										.getSelectedRow(), 0).toString();

				String kundeLoeschen = "DELETE kunden FROM kunden WHERE kunden.KundenID = '"
						+ kundenID
						+ "' AND KundenID NOT IN (SELECT Kunde FROM zimmerbuchung)";

				Statement st = conn.createStatement();
				st.executeUpdate(kundeLoeschen);

				JOptionPane.showMessageDialog(new JFrame(), kundenID
						+ " wurde aus der Datenbank gelöscht.");

				MainFrame.frame.getContentPane().setVisible(false);
				MainFrame.frame.setContentPane(new KundeBearbeiten());

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException e1) {
				JOptionPane.showMessageDialog(new JFrame(),
						"Bitte wählen Sie einen Kunden aus!");
			}

		}

		// Aktion Ändern-Button
		if (e.getActionCommand().equals("KAENDERN")) {

			try {

				// Datenbankverbindung aufbauen
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/"
								+ "hotelprojekt?user=root&password=init");

				Statement st = conn.createStatement();

				// KundenID aus JTable in String speichern
				String kundenID = (String) kBearbeiten
						.getAnzeige()
						.getSQLTable()
						.getValueAt(
								kBearbeiten.getAnzeige().getSQLTable()
										.getSelectedRow(), 0).toString();

				String abfrageKunde = "SELECT Anrede, Name, Vorname, Strasse, PLZ, Ort, Geburtsdatum, Telefonnummer FROM kunden WHERE KundenID = '"
						+ kundenID + "'";

				ResultSet rs = st.executeQuery(abfrageKunde);

				while (rs.next()) {
					kID = kundenID;
					anrede = rs.getString(1);
					name = rs.getString(2);
					vorname = rs.getString(3);
					strasse = rs.getString(4);
					plz = rs.getInt(5);
					ort = rs.getString(6);
					geburtsdatum = rs.getString(7);
					telefonnummer = rs.getString(8);
				}

				MainFrame.frame.getContentPane().setVisible(false);
				MainFrame.frame.setContentPane(new KundeAendern(new Kunde(
						Integer.parseInt(kID), anrede, name, vorname, strasse,
						plz, ort, geburtsdatum, telefonnummer)));

			} catch (SQLException e2) {
				JOptionPane.showMessageDialog(new JFrame(), e2);

			} catch (ClassNotFoundException e3) {
				JOptionPane.showMessageDialog(new JFrame(), e3);
			} catch (ArrayIndexOutOfBoundsException e1) {
				JOptionPane.showMessageDialog(new JFrame(),
						"Bitte wählen Sie einen Kunden aus!");
			}
		}

		// Aktion Zurueck
		if (e.getActionCommand().equals("ZURUECK")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(new KundeBearbeiten());
		}

		// Aktion Ändern-Speichern
		if (e.getActionCommand().equals("KUNDEAENDERN")) {

			try {

				int kid = Integer.parseInt(kAendern.getTextKid().getText());
				String anrede = kAendern.getTextAnrede().getText();
				String name = kAendern.getTextName().getText();
				String vorname = kAendern.getTextVorname().getText();
				String strasse = kAendern.getTextStrasse().getText();
				int plz = Integer.parseInt(kAendern.getTextPLZ().getText());
				String ort = kAendern.getTextOrt().getText();
				String datum = kAendern.getTextDatum().getText();
				String telefon = kAendern.getTextTelefon().getText();

				Kunde kunde = new Kunde(anrede, name, vorname, strasse, plz,
						ort, datum, telefon);

				String kundeAendern = "UPDATE kunden SET Anrede ='" + anrede
						+ "', Name='" + name + "' , Vorname='" + vorname
						+ "', Strasse= '" + strasse + "', PLZ =" + plz
						+ ", Ort ='" + ort + "', Geburtsdatum='" + datum
						+ "', Telefonnummer ='" + telefon + "' WHERE KundenID="
						+ kid;

				Statement st = conn.createStatement();
				st.executeUpdate(kundeAendern);

				JOptionPane.showMessageDialog(new JFrame(), kID
						+ " wurde geändert.");

				MainFrame.frame.getContentPane().setVisible(false);
				MainFrame.frame.setContentPane(new KundeBearbeiten());

			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(new JFrame(),
						"Die UPDATE Abfrage konnte nicht ausgeführt werden");

			} catch (HotelException e2) {
				JOptionPane.showMessageDialog(new JFrame(), e2);
			}
		}
	}

	public String getkID() {
		return kID;
	}

	public void setkID(String kID) {
		this.kID = kID;
	}

	public String getAnrede() {
		return anrede;
	}

	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

}
