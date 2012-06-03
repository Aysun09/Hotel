package Datenbank;

public class ZimmerBuchung {

	private int zimmer, kunde, dauer;
	private double preis;

	public ZimmerBuchung(int zimmer, int kunde, int dauer, double preis) {

		this.zimmer = zimmer;
		this.kunde = kunde;
		this.dauer = dauer;
		this.preis = preis;
	}

	public int getZimmer() {
		return zimmer;
	}

	public void setZimmer(int zimmer) {
		this.zimmer = zimmer;
	}

	public int getKunde() {
		return kunde;
	}

	public void setKunde(int kunde) {
		this.kunde = kunde;
	}

	public int getDauer() {
		return dauer;
	}

	public void setDauer(int dauer) {
		this.dauer = dauer;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

}
