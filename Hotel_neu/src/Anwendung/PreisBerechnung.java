package Anwendung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Datenbank.Datenbankbefehle;

public class PreisBerechnung {

	String abfrageZiPreis = Datenbankbefehle.ziBuchungsPreis();
	String abfrageMiPreis = Datenbankbefehle.miBuchungsPreis();
	double zimmerPreis = this.executeZimmerPreis();
	double mietwagenPreis = this.executeMietwagenPreis();
	double gesamtPreis = this
			.gesamtPreisBerechnung(zimmerPreis, mietwagenPreis);
	String nurZimmerGebucht = String.valueOf(zimmerPreis);
	String buchungGesamtPreis = String.valueOf(gesamtPreis);
	String nurMietwagenGebucht = String.valueOf(mietwagenPreis);

	public String getNurMietwagenGebucht() {
		return nurMietwagenGebucht;
	}

	public void setNurMietwagenGebucht(String nurMietwagenGebucht) {
		this.nurMietwagenGebucht = nurMietwagenGebucht;
	}

	public String getBuchungGesamtPreis() {
		return buchungGesamtPreis;
	}

	public void setBuchungGesamtPreis(String buchungGesamtPreis) {
		this.buchungGesamtPreis = buchungGesamtPreis;
	}

	public static Connection conn = null;

	public double executeZimmerPreis() {

		try {

			// Datenbankverbindung aufbauen
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
					+ "hotelprojekt?user=root&password=init");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(abfrageZiPreis);

			while (rs.next()) {
				zimmerPreis = rs.getDouble(1);
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(), e);
		}
		return zimmerPreis;
	}

	public double executeMietwagenPreis() {

		try {

			// Datenbankverbindung aufbauen
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
					+ "hotelprojekt?user=root&password=init");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(abfrageMiPreis);

			while (rs.next()) {
				mietwagenPreis = rs.getDouble(1);
			}

			rs.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(), e);
		}
		return mietwagenPreis;
	}

	public double gesamtPreisBerechnung(double zimmer, double mietwagen) {

		gesamtPreis = zimmer + mietwagen;
		return gesamtPreis;
	}

	public String getNurZimmerGebucht() {
		return nurZimmerGebucht;
	}

	public void setNurZimmerGebucht(String nurZimmerGebucht) {
		this.nurZimmerGebucht = nurZimmerGebucht;
	}

}
