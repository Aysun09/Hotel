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

import Datenbank.GesamtBuchung;
import GUI.GesamtBuchungAnlegen;
import GUI.GesamtBuchungBearbeiten;
import GUI.MainFrame;
import GUI.Start;

public class AktionenGesamtBuchungAnlegen implements ActionListener {

	GesamtBuchungAnlegen gesamtBuchung;
	GesamtBuchung gebucht;
	int ziBuchungID;
	int miBuchungID;
	public static Connection conn = null;

	public AktionenGesamtBuchungAnlegen(GesamtBuchungAnlegen buchen) {
		gesamtBuchung = buchen;
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

	public int executeQueryRS(String SQLquery) {
		int wert = 0;
		try {
			// Datenbankverbindung aufbauen
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
					+ "hotelprojekt?user=root&password=init");

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(SQLquery);

			while (rs.next()) {
				wert = rs.getInt(1);
			}
			st.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(), e);
		}
		return wert;
	}

	// Aktionen ausführen
	public void actionPerformed(ActionEvent e) {

		System.out.println("Aktion: " + e.getActionCommand());

		if (e.getActionCommand().equals("BESTAETIGEN")) {

			try {
				// ZimmerbuchungId
				String ziNummer = (String) gesamtBuchung
						.getzAnzeige()
						.getSQLTable()
						.getValueAt(
								gesamtBuchung.getzAnzeige().getSQLTable()
										.getSelectedRow(), 0).toString();

				String queryziNu = "SELECT ZimmerbuchungID FROM Zimmerbuchung WHERE(Zimmer ='"
						+ ziNummer + "')";
				this.ziBuchungID = this.executeQueryRS(queryziNu);

				// Gesamtpreis berechnen
				double gesamtPreis = Double.parseDouble(gesamtBuchung
						.getPreis());

				// MietwagenbuchungId
				if (gesamtBuchung.isMietwagenGebucht()) {
					String miNummer = (String) gesamtBuchung
							.getmAnzeige()
							.getSQLTable()
							.getValueAt(
									gesamtBuchung.getmAnzeige().getSQLTable()
											.getSelectedRow(), 0).toString();

					String querymiNu = "SELECT MietwagenbuchungID FROM Mietwagenbuchung WHERE(Mietwagen =  '"
							+ miNummer + "')";
					this.miBuchungID = this.executeQueryRS(querymiNu);

					gebucht = new GesamtBuchung(ziBuchungID, miBuchungID,
							gesamtPreis);

					String queryBu = "INSERT INTO buchung(Zimmerbuchung, Mietwagenbuchung, Buchunggesamtpreis)"
							+ "VALUES("
							+ gebucht.getZimmerBuchung()
							+ ","
							+ gebucht.getMietwagenBuchung()
							+ ","
							+ gebucht.getGesamtpreis() + ")";
					boolean bool = this.executeQuery(queryBu);
					if (bool) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Buchung war erfolgreich!");
					}
				} else {
					gebucht = new GesamtBuchung(ziBuchungID, 0, gesamtPreis);
					String queryBu = "INSERT INTO buchung(Zimmerbuchung, Buchunggesamtpreis)"
							+ "VALUES("
							+ gebucht.getZimmerBuchung()
							+ ","
							+ gebucht.getGesamtpreis() + ")";

					boolean bool = this.executeQuery(queryBu);
					if (bool) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Buchung war erfolgreich!");
					}
				}
				MainFrame.frame.getContentPane().setVisible(false);
				MainFrame.frame.setContentPane(new Start());
			} catch (ArrayIndexOutOfBoundsException e1) {
				JOptionPane
						.showMessageDialog(
								new JFrame(),
								"Bitte wählen Sie einen Kunden, ein Zimmer und falls vorhanden einen Mietwagen aus");
			}
		}

		if (e.getActionCommand().equals("ABBRECHEN")) {
			try {
				// Datenbankverbindung aufbauen
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/"
								+ "hotelprojekt?user=root&password=init");

				String zimmerAbfrage = "SELECT MAX(zimmerbuchungID) FROM zimmerbuchung";
				Statement st = conn.createStatement();
				ResultSet rsZimmer = st.executeQuery(zimmerAbfrage);
				String zimmerID = "";
				while (rsZimmer.next()) {
					zimmerID = rsZimmer.getString(1);
				}

				String kundenAbfrage = "SELECT KundenID FROM zimmerbuchung WHERE ZimmerbuchungID = "
						+ zimmerID;
				ResultSet rsKunde = st.executeQuery(zimmerAbfrage);
				String kundenID = "";
				;
				while (rsKunde.next()) {
					kundenID = rsKunde.getString(1);
				}

				String mietwagenAbfrage = "SELECT MAX(mietwagenbuchungID) FROM mietwagenbuchung";
				ResultSet rsMietwagen = st.executeQuery(mietwagenAbfrage);
				String mietwagenID = "";
				;
				while (rsMietwagen.next()) {
					mietwagenID = rsMietwagen.getString(1);
				}

				String kundenAbfrage2 = "SELECT KundenID FROM mietwagenbuchung WHERE MietwagenbuchungID = "
						+ mietwagenID;
				ResultSet rsKunde2 = st.executeQuery(zimmerAbfrage);
				String kundenID2 = "";

				while (rsKunde2.next()) {
					kundenID2 = rsKunde2.getString(1);
				}

				if (kundenID.equals(kundenID2)) {
					String abbrechenAbfrage = "DELETE zimmerbuchung, mietwagenbuchung FROM zimmerbuchung, mietwagenbuchung WHERE ZimmerbuchungID = '"
							+ zimmerID
							+ "'AND MietwagenbuchungID ='"
							+ mietwagenID + "'";

					st.executeUpdate(abbrechenAbfrage);

					JOptionPane.showMessageDialog(new JFrame(),
							"Die Zimmerbuchung " + zimmerID
									+ "und die Mietwagenbuchung " + mietwagenID
									+ " wurden aus der Datenbank gelöscht.");
				} else {
					String abbrechenAbfrage = "DELETE zimmerbuchung FROM zimmerbuchung WHERE ZimmerbuchungID = '"
							+ zimmerID + "'";

					st.executeUpdate(abbrechenAbfrage);

					JOptionPane.showMessageDialog(new JFrame(),
							"Die Zimmerbuchung " + zimmerID
									+ " wurde aus der Datenbank gelöscht.");
				}

				MainFrame.frame.getContentPane().setVisible(false);
				MainFrame.frame.setContentPane(new Start());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		}

	}

}
