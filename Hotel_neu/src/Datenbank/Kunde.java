package Datenbank;

import java.util.Date;

import Anwendung.HotelException;

public class Kunde {

	private int kundenid, plz;
	private String anrede, vorname, name, strasse, ort, gdatum, telefonnummer;

	public Kunde(String anrede, String name, String vorname, String strasse,
			int plz, String ort, String gdatum, String telnr)
			throws HotelException {

		if (anrede.equals("Anrede") || anrede.equals(""))
			throw new HotelException("Es wurde keine Anrede eingegeben");
		if (vorname.equals(""))
			throw new HotelException("Es wurde kein Vorname eingegeben");
		if (name.equals(""))
			throw new HotelException("Es wurde kein Name eingegeben");
		if (strasse.equals(""))
			throw new HotelException("Es wurde keine Strasse eingegeben");
		if (plz == 0)
			throw new HotelException("Es wurde keine PLZ eingegeben");
		if (ort.equals(""))
			throw new HotelException("Es wurde kein Ort eingegeben");
		if (gdatum.equals(""))
			throw new HotelException("Es wurde kein Geburtsdatum eingegeben");
		if (telnr.equals(""))
			throw new HotelException("Es wurde keine Telefonnummer eingegeben");

		this.anrede = anrede;
		this.name = name;
		this.vorname = vorname;
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;
		this.gdatum = gdatum;
		this.telefonnummer = telnr;
	}

	public Kunde(int kundenID, String anrede, String name, String vorname,
			String strasse, int plz, String ort, String gdatum, String telnr)
			throws HotelException {

		if (anrede.equals("Anrede") || anrede.equals(""))
			throw new HotelException("Es wurde keine Anrede ausgewählt");
		if (vorname.equals(""))
			throw new HotelException("Es wurde kein Vorname eingegeben");
		if (name.equals(""))
			throw new HotelException("Es wurde kein Name eingegeben");
		if (strasse.equals(""))
			throw new HotelException("Es wurde keine Strasse eingegeben");
		if (plz == 0)
			throw new HotelException("Es wurde keine PLZ eingegeben");
		if (ort.equals(""))
			throw new HotelException("Es wurde kein Ort eingegeben");
		if (gdatum.equals(""))
			throw new HotelException("Es wurde kein Geburtsdatum eingegeben");
		if (telnr.equals(""))
			throw new HotelException("Es wurde keine Telefonnummer eingegeben");

		this.kundenid = kundenID;
		this.anrede = anrede;
		this.name = name;
		this.vorname = vorname;
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;
		this.gdatum = gdatum;
		this.telefonnummer = telnr;
	}

	public int getKundenid() {
		return kundenid;
	}

	public void setKundenid(int kundenid) {
		this.kundenid = kundenid;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getAnrede() {
		return anrede;
	}

	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public String getGdatum() {
		return gdatum;
	}

	public void setGdatum(String gdatum) {
		this.gdatum = gdatum;
	}

}
