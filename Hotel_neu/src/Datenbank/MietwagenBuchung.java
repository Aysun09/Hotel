package Datenbank;

public class MietwagenBuchung {

	private int kunde, mietwagen, dauer;
	private double preis;

	public MietwagenBuchung(int kunde, int mietwagen, int dauer, double preis) {

		this.kunde = kunde;
		this.mietwagen = mietwagen;
		this.dauer = dauer;
		this.preis = preis;
	}

	public int getKunde() {
		return kunde;
	}

	public void setKunde(int kunde) {
		this.kunde = kunde;
	}

	public int getMietwagen() {
		return mietwagen;
	}

	public void setMietwagen(int mietwagen) {
		this.mietwagen = mietwagen;
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
