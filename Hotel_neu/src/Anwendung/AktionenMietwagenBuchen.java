package Anwendung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Datenbank.MietwagenBuchung;
import GUI.GesamtBuchungAnlegen;
import GUI.MainFrame;
import GUI.MietwagenBestätigung;
import GUI.MietwagenBuchen;
import GUI.Start;

public class AktionenMietwagenBuchen implements ActionListener {

	public MietwagenBuchen miBuchen;

	public static Connection conn = null;

	public AktionenMietwagenBuchen(MietwagenBuchen buchen) {
		miBuchen = buchen;
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

	// Aktionen ausführen
	public void actionPerformed(ActionEvent e) {

		System.out.println("Aktion: " + e.getActionCommand());

		// Aktion Weiter
		if (e.getActionCommand().equals("WEITERZUGESBES")) {

			try {
				if (miBuchen.getmAnzeige().getSQLTable().getSelectedRow() == -1) {
					Object[] options = { "Ja", "Nein" };

					int n = JOptionPane.showOptionDialog(null,
							"Buchung ohne Mietwagen fortsetzen?",
							"Mietwagenabfrage",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options,
							options[0]);

					if (n == JOptionPane.YES_OPTION) {
						MainFrame.frame.getContentPane().setVisible(false);
						MainFrame.frame
								.setContentPane(new GesamtBuchungAnlegen(false));
					}

				} else {

					// Mietwagennummer aus JTable in String speichern
					String mietwagen = (String) miBuchen
							.getmAnzeige()
							.getSQLTable()
							.getValueAt(
									miBuchen.getmAnzeige().getSQLTable()
											.getSelectedRow(), 0).toString();

					// KundenID aus JTable in String speichern
					String kunde = (String) miBuchen
							.getkAnzeige()
							.getSQLTable()
							.getValueAt(
									miBuchen.getkAnzeige().getSQLTable()
											.getSelectedRow(), 0).toString();

					// Gesamtpreis aus JTable in String speichern
					String preis = (String) miBuchen
							.getmAnzeige()
							.getSQLTable()
							.getValueAt(
									miBuchen.getmAnzeige().getSQLTable()
											.getSelectedRow(), 3).toString();

					double mietwagenpreis = Double.parseDouble(preis);
					if ((miBuchen.getTextDauer().getText()).equals("")) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Bitte geben Sie eine Mietdauer ein");
					} else {
						int dauer = Integer.parseInt(miBuchen.getTextDauer()
								.getText());
						double gesamtPreis = mietwagenpreis * dauer;

						MietwagenBuchung gebucht = new MietwagenBuchung(
								Integer.parseInt(kunde),
								Integer.parseInt(mietwagen), dauer, gesamtPreis);

						// Neue Mietwagebuchung anlegen
						String queryMi = "INSERT INTO mietwagenbuchung(Kunde, Mietwagen, Mietdauer, Wagengesamtpreis)"
								+ "VALUES("
								+ gebucht.getKunde()
								+ ","
								+ gebucht.getMietwagen()
								+ ","
								+ gebucht.getDauer()
								+ ","
								+ gebucht.getPreis()
								+ ")";

						// Mietwagenbuchung ausführen
						boolean bool = this.executeQuery(queryMi);
						if (bool) {
							JOptionPane.showMessageDialog(
									new JFrame(),
									"Mietwagen " + gebucht.getMietwagen()
											+ " ist von Kunde "
											+ gebucht.getKunde()
											+ " gebucht worden:\n");
							MainFrame.frame.getContentPane().setVisible(false);
							MainFrame.frame
									.setContentPane(new GesamtBuchungAnlegen(
											true));
						}
					}
				}
			} catch (ArrayIndexOutOfBoundsException e1) {
				JOptionPane
						.showMessageDialog(new JFrame(),
								"Bitte wählen Sie einen Kunden und einen Mietwagen aus");
			}
		}
		if (e.getActionCommand().equals("WEITERZUMIBES")) {
			try {
				if (miBuchen.getmAnzeige().getSQLTable().getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(new JFrame(),
							"Es wurde kein Mietwagen ausgewählt!");
				} else {

					// Mietwagennummer aus JTable in String speichern
					String mietwagen = (String) miBuchen
							.getmAnzeige()
							.getSQLTable()
							.getValueAt(
									miBuchen.getmAnzeige().getSQLTable()
											.getSelectedRow(), 0).toString();

					// KundenID aus JTable in String speichern
					String kunde = (String) miBuchen
							.getkAnzeige()
							.getSQLTable()
							.getValueAt(
									miBuchen.getkAnzeige().getSQLTable()
											.getSelectedRow(), 0).toString();

					// Gesamtpreis aus JTable in String speichern
					String preis = (String) miBuchen
							.getmAnzeige()
							.getSQLTable()
							.getValueAt(
									miBuchen.getmAnzeige().getSQLTable()
											.getSelectedRow(), 3).toString();

					double mietwagenpreis = Double.parseDouble(preis);
					if ((miBuchen.getTextDauer().getText()).equals("")) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Bitte geben Sie eine Mietdauer ein");
					} else {
						int dauer = Integer.parseInt(miBuchen.getTextDauer()
								.getText());
						double gesamtPreis = mietwagenpreis * dauer;

						MietwagenBuchung gebucht = new MietwagenBuchung(
								Integer.parseInt(kunde),
								Integer.parseInt(mietwagen), dauer, gesamtPreis);

						// Neue Mietwagebuchung anlegen
						String queryMi = "INSERT INTO mietwagenbuchung(Kunde, Mietwagen, Mietdauer, Wagengesamtpreis)"
								+ "VALUES("
								+ gebucht.getKunde()
								+ ","
								+ gebucht.getMietwagen()
								+ ","
								+ gebucht.getDauer()
								+ ","
								+ gebucht.getPreis()
								+ ")";

						// Mietwagenbuchung ausführen
						boolean bool = this.executeQuery(queryMi);
						if (bool) {
							JOptionPane.showMessageDialog(
									new JFrame(),
									"Mietwagen " + gebucht.getMietwagen()
											+ " ist von Kunde "
											+ gebucht.getKunde()
											+ " gebucht worden:\n");
							MainFrame.frame.getContentPane().setVisible(false);
							MainFrame.frame
									.setContentPane(new MietwagenBestätigung());
						}
					}
				}
			} catch (ArrayIndexOutOfBoundsException e1) {
				JOptionPane
						.showMessageDialog(new JFrame(),
								"Bitte wählen Sie einen Kunden und einen Mietwagen aus");
			}
		}
		if (e.getActionCommand().equals("ZURUECK")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(new Start());
		}

	}

}
