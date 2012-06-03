package Anwendung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Datenbank.Zimmer;
import GUI.MainFrame;
import GUI.Start;
import GUI.ZimmerAnlegen;
import GUI.ZimmerBearbeiten;

public class AktionenZimmerAnlegen implements ActionListener {

	public ZimmerAnlegen zAnlegen;
	public static Connection conn = null;

	public AktionenZimmerAnlegen(ZimmerAnlegen z) {
		zAnlegen = z;
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

	// Zimmeraktionen ausführen
	public void actionPerformed(ActionEvent e) {
		System.out.println("Aktion: " + e.getActionCommand());

		if (e.getActionCommand().equals("ZIMMERSPEICHERN")) {

			Zimmer zimmer;
			try {

				int nummer = Integer.parseInt(zAnlegen.getTextNr().getText());
				String art = (String) zAnlegen.getZimmerBox().getSelectedItem();
				double preis = Double.parseDouble(zAnlegen.getTextPreis()
						.getText());

				zimmer = new Zimmer(nummer, art, preis);

				String query = "INSERT INTO zimmer(Zimmernummer, Zimmerart, Zimmerpreis)"
						+ "VALUES("
						+ zimmer.getZimmernr()
						+ ",'"
						+ zimmer.getZimmerart()
						+ "',"
						+ zimmer.getPreis()
						+ ")";

				boolean bool = this.executeQuery(query);
				if (bool) {
					zAnlegen.getTextNr().setText(null);
					zAnlegen.getTextPreis().setText(null);

					JOptionPane.showMessageDialog(new JFrame(),
							"Folgendes Zimmer ist in die Datenbank eingefügt worden:\n"
									+ zimmer.getZimmernr());
					MainFrame.frame.getContentPane().setVisible(false);
					MainFrame.frame.setContentPane(new ZimmerBearbeiten());
				}
			} catch (HotelException e1) {
				JOptionPane.showMessageDialog(new JFrame(), e1);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(new JFrame(),
						"Die Eingabewerte sind falsch");
			}
		}
		if (e.getActionCommand().equals("ZIMMERZURUECK")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(new Start());
		}

	}

}
