package Datenbank;

import Anwendung.HotelException;

public class Mietwagen {

	private String kfz, art;
	private double preis;

	public Mietwagen(String kfz, String art, double preis)
			throws HotelException {
		if (kfz.equals(""))
			throw new HotelException("Es wurde kein KFZ-Kennzeichen eingegeben");
		if (art.equals("Mietwagentyp") || (art.equals("")))
			throw new HotelException("Es wurde kein Wagentyp ausgewählt");
		if (preis == 0)
			throw new HotelException("Es wurde kein Mietwagenpreis eingegeben");
		this.kfz = kfz;
		this.art = art;
		this.preis = preis;
	}

	public String getKfz() {
		return kfz;
	}

	public void setKfz(String kfz) {
		this.kfz = kfz;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

}
