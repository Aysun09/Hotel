package Datenbank;

import GUI.MietwagenBuchen;

public class Datenbankbefehle {

	// KundenBearbeiten
	public static String kundenAnzeigen() {

		return "SELECT * FROM kunden ORDER BY kundenID";
	}

	// ZimmerBearbeiten
	public static String zimmerAnzeigen() {

		return "SELECT * FROM zimmer ORDER BY zimmernummer";
	}

	// MietwagenBearbeiten
	public static String wagenAnzeigen() {

		return "SELECT * FROM mietwagen ORDER BY mietwagenID";
	}

	// ZimmerBuchen
	public static String ziAuswahlAnzeigen() {

		return "SELECT * FROM zimmer WHERE zimmernummer NOT IN (SELECT zimmer FROM zimmerbuchung) ORDER BY zimmernummer";
	}

	// MietwagenBuchen
	public static String miAuswahlAnzeigen() {

		return "SELECT * FROM mietwagen WHERE mietwagenID NOT IN (SELECT mietwagen FROM mietwagenbuchung) ORDER BY mietwagenID";
	}

	public static String kuAuswahlAnzeigen1() {

		return "SELECT * FROM kunden WHERE kundenID IN (SELECT kunde FROM zimmerbuchung) ORDER BY kundenID";
	}

	public static String kuAuswahlAnzeigen2() {

		return "SELECT * FROM kunden WHERE kundenId IN (SELECT kunde From zimmerbuchung where zimmerbuchungId IN (SELECT max(zimmerbuchungID) FROM zimmerbuchung))";
	}

	// GesamtBuchung
	public static String buchungenAnzeigen() {
		return "select * from buchung";
	}

	public static String kuBuchungAnzeige() {
		return "select * from kunden where kundenId in (select kunde from zimmerbuchung where zimmerbuchungId in(select max(zimmerbuchungId) from zimmerbuchung))";
	}

	public static String ziBuchungAnzeige() {
		return "select * from zimmer where zimmernummer in (select zimmer from zimmerbuchung where zimmerbuchungId in(select max(zimmerbuchungId) from zimmerbuchung))";
	}

	public static String miBuchungAnzeige() {
		return "select * from mietwagen where mietwagenId in (select mietwagen from mietwagenbuchung where mietwagenbuchungId in(select max(mietwagenbuchungId) from mietwagenbuchung))";
	}

	public static String ziBuchungsPreis() {
		return "select Zimmergesamtpreis from zimmerbuchung where zimmerbuchungID in (select max(zimmerbuchungId) from zimmerbuchung)";
	}

	public static String miBuchungsPreis() {
		return "select Wagengesamtpreis from mietwagenbuchung where mietwagenbuchungID in (select max(mietwagenbuchungId) from mietwagenbuchung)";
	}

}
