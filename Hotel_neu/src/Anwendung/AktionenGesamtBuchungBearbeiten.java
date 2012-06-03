package Anwendung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GUI.GesamtBuchungBearbeiten;
import GUI.KundeBearbeiten;
import GUI.MainFrame;
import GUI.Start;

public class AktionenGesamtBuchungBearbeiten implements ActionListener {

	public GesamtBuchungBearbeiten buBearbeiten;
	public static Connection conn = null;

	public AktionenGesamtBuchungBearbeiten(GesamtBuchungBearbeiten z) {
		buBearbeiten = z;
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

	public void actionPerformed(ActionEvent e) {
		System.out.println("Aktion: " + e.getActionCommand());

		if (e.getActionCommand().equals("BLOESCHEN")) {

			try {
				// Datenbankverbindung aufbauen
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/"
								+ "hotelprojekt?user=root&password=init");

				// BuchungID aus JTable in String speichern
				String buchungID = (String) buBearbeiten
						.getAnzeige()
						.getSQLTable()
						.getValueAt(
								buBearbeiten.getAnzeige().getSQLTable()
										.getSelectedRow(), 0).toString();

				String buLoeschen = "DELETE buchung, zimmerbuchung, mietwagenbuchung FROM buchung, zimmerbuchung, mietwagenbuchung WHERE BuchungId = '"
						+ buchungID
						+ "' AND buchung.Zimmerbuchung = zimmerbuchung.ZimmerbuchungID AND buchung.Mietwagenbuchung = mietwagenbuchung.MietwagenbuchungID";

				Statement st;
				st = conn.createStatement();

				st.executeUpdate(buLoeschen);

				JOptionPane.showMessageDialog(new JFrame(), buchungID
						+ " wurde aus der Datenbank gelöscht.");

				MainFrame.frame.getContentPane().setVisible(false);
				MainFrame.frame.setContentPane(new GesamtBuchungBearbeiten());
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(new JFrame(),
						"Der SQL-Befehl ist falsch");
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException e3) {
				JOptionPane.showMessageDialog(new JFrame(),
						"Bitte wählen Sie eine Buchung aus");
			}

		}

	}

}
