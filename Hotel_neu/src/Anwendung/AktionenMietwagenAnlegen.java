package Anwendung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Datenbank.Mietwagen;
import GUI.MainFrame;
import GUI.MietwagenAnlegen;
import GUI.MietwagenBearbeiten;
import GUI.Start;

public class AktionenMietwagenAnlegen implements ActionListener {

	public MietwagenAnlegen wAnlegen;
	public static Connection conn = null;

	public AktionenMietwagenAnlegen(MietwagenAnlegen w) {
		wAnlegen = w;
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

	// Mietwagen ausführen
	public void actionPerformed(ActionEvent e) {
		System.out.println("Aktion: " + e.getActionCommand());

		if (e.getActionCommand().equals("MIETWAGENSPEICHERN")) {

			Mietwagen wagen;
			try {

				String kfz = wAnlegen.getTextKfz().getText();
				String art = (String) wAnlegen.getWagenBox().getSelectedItem();
				double preis = Double.parseDouble(wAnlegen.getTextPreis()
						.getText());
				wagen = new Mietwagen(kfz, art, preis);

				String query = "INSERT INTO mietwagen(kennzeichen, wagentyp, wagenpreis)"
						+ "VALUES('"
						+ wagen.getKfz()
						+ "','"
						+ wagen.getArt()
						+ "'," + wagen.getPreis() + ")";

				boolean bool = this.executeQuery(query);
				if (bool) {
					wAnlegen.getTextKfz().setText(null);
					wAnlegen.getTextPreis().setText(null);

					JOptionPane.showMessageDialog(new JFrame(),
							"Folgender Mietwagen ist in die Datenbank eingefügt worden:\n"
									+ wagen.getKfz());
					MainFrame.frame.getContentPane().setVisible(false);
					MainFrame.frame.setContentPane(new MietwagenBearbeiten());
				}
			} catch (HotelException e1) {
				JOptionPane.showMessageDialog(new JFrame(), e1);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(new JFrame(),
						"Bitte überprüfen Sie ihren eingegebenen Preis!");
			} catch (ArrayIndexOutOfBoundsException e3) {
				JOptionPane
						.showMessageDialog(new JFrame(),
								"Bitte wählen Sie einen Kunden und einen Mietwagen aus!");
			}
		}
		if (e.getActionCommand().equals("MIETWAGENZURUECK")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(new Start());
		}

	}

}
