package Anwendung;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Datenbank.GesamtBuchung;
import GUI.GesamtBuchungAnlegen;
import GUI.MainFrame;
import GUI.MietwagenBestätigung;
import GUI.Start;

public class AktionenMietwagenBestätigung implements ActionListener {

	public static Connection conn = null;
	private MietwagenBestätigung bestätigung;
	int KundenID;
	int ziBuchungID;
	int miBuchungID;
	int gesBuchungID;
	double startPreis;

	public AktionenMietwagenBestätigung(MietwagenBestätigung bestätigung) {
		this.bestätigung = bestätigung;
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

	public double executeQueryRS2(String SQLquery) {
		double wert = 0;
		try {
			// Datenbankverbindung aufbauen
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
					+ "hotelprojekt?user=root&password=init");

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(SQLquery);

			while (rs.next()) {
				wert = rs.getDouble(1);
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

	public void actionPerformed(ActionEvent e) {

		System.out.println("Aktion: " + e.getActionCommand());
		try {
			if (e.getActionCommand().equals("BESTAETIGEN")) {

				// KundenId
				String kuNummer = (String) bestätigung
						.getkAnzeige()
						.getSQLTable()
						.getValueAt(
								bestätigung.getkAnzeige().getSQLTable()
										.getSelectedRow(), 0).toString();

				String querykuNu = "SELECT KundenID FROM Kunden WHERE(KundenID ='"
						+ kuNummer + "')";
				this.KundenID = this.executeQueryRS(querykuNu);

				// MietwagenbuchungId
				String miNummer = (String) bestätigung
						.getmAnzeige()
						.getSQLTable()
						.getValueAt(
								bestätigung.getmAnzeige().getSQLTable()
										.getSelectedRow(), 0).toString();

				String querymiNu = "SELECT MietwagenbuchungID FROM Mietwagenbuchung WHERE(Mietwagen =  "
						+ miNummer + ")";
				this.miBuchungID = this.executeQueryRS(querymiNu);

				String queryziNu = "SELECT ZimmerbuchungID FROM Zimmerbuchung WHERE (Kunde = "
						+ String.valueOf(KundenID) + ")";
				this.ziBuchungID = this.executeQueryRS(queryziNu);

				String querybuNu = "SELECT BuchungID FROM Buchung WHERE ((Zimmerbuchung = "
						+ ziBuchungID + ") AND (MietwagenBuchung IS NULL))";
				this.gesBuchungID = this.executeQueryRS(querybuNu);

				if (gesBuchungID == 0) {
					JOptionPane.showMessageDialog(new JFrame(),
							"Kunde hat bereits einen Mietwagen!");
				} else {
					String queryStartpreis = "SELECT Buchunggesamtpreis FROM Buchung WHERE (BuchungID="
							+ gesBuchungID + ")";
					this.startPreis = this.executeQueryRS2(queryStartpreis);

					double gesamtPreis = (Double.parseDouble(bestätigung
							.getPreis()) + startPreis);

					String queryInsert = "UPDATE Buchung SET Mietwagenbuchung="
							+ miBuchungID + ", Buchunggesamtpreis="
							+ gesamtPreis + "WHERE BuchungID =" + gesBuchungID;
					boolean bool = this.executeQuery(queryInsert);
					if (bool) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Buchung war erfolgreich!");
					}
					MainFrame.frame.getContentPane().setVisible(false);
					MainFrame.frame.setContentPane(new Start());
				}
			}
		} catch (ArrayIndexOutOfBoundsException e1) {
			JOptionPane.showMessageDialog(new JFrame(),
					"Bitte bestätigen Sie den Kunden und den Mietwagen");
		}

		if (e.getActionCommand().equals("ABBRECHEN")) {

			String miBuchung = "SELECT MAX(MietwagenbuchungID) FROM Mietwagenbuchung";
			int maxBuchungId = this.executeQueryRS(miBuchung);

			try {
				// Datenbankverbindung aufbauen
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/"
								+ "hotelprojekt?user=root&password=init");

				String miLoeschen = "DELETE FROM mietwagenbuchung WHERE MietwagenbuchungID = "
						+ maxBuchungId;
				Statement st = conn.createStatement();
				st.executeUpdate(miLoeschen);

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
