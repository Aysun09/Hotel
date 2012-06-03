package Anwendung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Datenbank.Kunde;
import Datenbank.Mietwagen;
import Datenbank.Zimmer;

public class AktionAnzeigen {

	private static Connection conn = null;
	private JTable SQLTable = null;

	Kunde kunde;
	Zimmer zimmer;
	Mietwagen wagen;

	// Getter für Anzeigetabelle
	public JTable getSQLTable() {

		return SQLTable;
	}

	// Konstruktor
	public AktionAnzeigen(String SQLquery) {

		SQLTable = anzeigen(SQLquery);
	}

	/**
	 * Anzeigen einer Datenbank
	 * 
	 * @param SQLquery
	 * @return
	 */
	private static JTable anzeigen(String SQLquery) {

		int columnCount = 0;
		int cnt = 1;

		// JTable erstellen
		JTable anzeige = new JTable();
		anzeige.enableInputMethods(false);
		anzeige.setDragEnabled(false);
		anzeige.setColumnSelectionAllowed(false);
		anzeige.setRowSelectionAllowed(true);
		anzeige.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Datenmodell mit Referenz auf JTable erstellen
		DefaultTableModel model = (DefaultTableModel) anzeige.getModel();

		try {
			// Datenbankverbindung aufbauen
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
					+ "hotelprojekt?user=root&password=init");

			// PreparedStatement für Abfrage
			PreparedStatement st = conn.prepareStatement(SQLquery);

			// Ergebnisliste der Abfrage
			ResultSet rs = st.executeQuery(SQLquery);

			// Groesse der Ergebnisliste ermitteln
			ResultSetMetaData rsmd = rs.getMetaData();
			columnCount = rsmd.getColumnCount();

			// Spaltennamen in der Tabelle einfügen
			for (int column = 1; column <= columnCount; column++) {

				model.addColumn(rsmd.getColumnLabel(column));
			}

			// Inhalt der Tabelle einfügen
			Object[] objects = new Object[columnCount];
			while (rs.next()) {
				cnt = 0;
				// Tabelle füllen
				while (cnt < columnCount) {
					objects[cnt] = rs.getObject(cnt + 1);
					cnt++;
				}
				model.addRow(objects);
			}

			// JTable mit Datenbankinhalt
			anzeige.setModel(model);

			// Verbindung schließen
			conn.close();

		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(), e);
		}

		return anzeige;
	}

}
