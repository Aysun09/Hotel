package Datenbank;

public class GesamtBuchung {

	int zimmerBuchung, mietwagenBuchung;
	double gesamtpreis;

	public GesamtBuchung(int zimmer, int mietwagen, double preis) {
		this.zimmerBuchung = zimmer;
		this.mietwagenBuchung = mietwagen;
		this.gesamtpreis = preis;
	}

	public int getZimmerBuchung() {
		return zimmerBuchung;
	}

	public void setZimmerBuchung(int zimmerBuchung) {
		this.zimmerBuchung = zimmerBuchung;
	}

	public int getMietwagenBuchung() {
		return mietwagenBuchung;
	}

	public void setMietwagenBuchung(int mietwagenBuchung) {
		this.mietwagenBuchung = mietwagenBuchung;
	}

	public double getGesamtpreis() {
		return gesamtpreis;
	}

	public void setGesamtpreis(double gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}

}
