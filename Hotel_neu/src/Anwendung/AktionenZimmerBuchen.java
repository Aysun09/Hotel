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

import Datenbank.ZimmerBuchung;
import GUI.KundeAnlegen;
import GUI.MainFrame;
import GUI.MietwagenBuchen;
import GUI.Start;
import GUI.ZimmerBuchen;

public class AktionenZimmerBuchen implements ActionListener {

	public ZimmerBuchen ziBuchen;

	public static Connection conn = null;

	public AktionenZimmerBuchen(ZimmerBuchen buchen) {
		ziBuchen = buchen;
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
			// conn.close();

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

		// Aktion Weiter
		if (e.getActionCommand().equals("WEITER")) {

			try {

				// Fehlermeldung, falls keine Zeile ausgewählt wurde
				if (ziBuchen.getzAnzeige().getSQLTable().getSelectedRow() == -1) {
					throw new HotelException(
							"Es muss ein Zimmer ausgewählt werden");
				}

				// Zimmernummer aus JTable in String speichern
				String zimmer = (String) ziBuchen
						.getzAnzeige()
						.getSQLTable()
						.getValueAt(
								ziBuchen.getzAnzeige().getSQLTable()
										.getSelectedRow(), 0).toString();

				// KundenID aus JTable in String speichern
				String kunde = (String) ziBuchen
						.getkAnzeige()
						.getSQLTable()
						.getValueAt(
								ziBuchen.getkAnzeige().getSQLTable()
										.getSelectedRow(), 0).toString();

				// Gesamtpreis aus JTable in String speichern
				String preis = (String) ziBuchen
						.getzAnzeige()
						.getSQLTable()
						.getValueAt(
								ziBuchen.getzAnzeige().getSQLTable()
										.getSelectedRow(), 2).toString();

				double zimmerpreis = Double.parseDouble(preis);
				if ((ziBuchen.getTextDauer().getText()).equals("")) {
					JOptionPane.showMessageDialog(new JFrame(),
							"Bitte geben Sie eine Aufenthaltsdauer ein");
				} else {
					int dauer = Integer.parseInt(ziBuchen.getTextDauer()
							.getText());
					double gesamtPreis = zimmerpreis * dauer;

					ZimmerBuchung gebucht = new ZimmerBuchung(
							Integer.parseInt(zimmer), Integer.parseInt(kunde),
							dauer, gesamtPreis);

					// Neue Zimmerbuchung anlegen
					String queryZi = "INSERT INTO zimmerbuchung(Zimmer, Kunde, Aufenthaltsdauer, Zimmergesamtpreis)"
							+ "VALUES("
							+ gebucht.getZimmer()
							+ ","
							+ gebucht.getKunde()
							+ ","
							+ gebucht.getDauer()
							+ "," + gebucht.getPreis() + ")";

					// Zimmerbuchung ausführen

					boolean bool = this.executeQuery(queryZi);
					if (bool) {

						JOptionPane.showMessageDialog(new JFrame(), "Zimmer "
								+ gebucht.getZimmer() + " ist von Kunde "
								+ gebucht.getKunde() + " gebucht worden:\n");
						MainFrame.frame.getContentPane().setVisible(false);
						MainFrame.frame.setContentPane(new MietwagenBuchen(
								false));
					}
				}
			} catch (HotelException e1) {
				JOptionPane.showMessageDialog(new JFrame(),
						"Bitte wählen Sie einen Kunden und ein Zimmer aus");
			}
		}
		if (e.getActionCommand().equals("KANLEGEN")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(new KundeAnlegen());

		}
		if (e.getActionCommand().equals("ZURUECK")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(new Start());
		}

	}
}
