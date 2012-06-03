package Datenbank;

import Anwendung.HotelException;

public class Zimmer {

	private int zimmernr;
	private String zimmerart;
	private double preis;

	public Zimmer(int nummer, String art, double preis) throws HotelException {
		if (nummer == 0)
			throw new HotelException("Es wurde keine Zimmernummer eingegeben");
		if (art.equals("Zimmerart") || (art.equals("")))
			throw new HotelException("Es wurde keine Zimmerart ausgewählt");
		if (preis == 0)
			throw new HotelException("Es wurde kein Zimmerpreis eingegeben");
		this.zimmernr = nummer;
		this.zimmerart = art;
		this.preis = preis;

	}

	public int getZimmernr() {
		return zimmernr;
	}

	public void setZimmernr(int zimmernr) {
		this.zimmernr = zimmernr;
	}

	public String getZimmerart() {
		return zimmerart;
	}

	public void setZimmerart(String zimmerart) {
		this.zimmerart = zimmerart;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

}
