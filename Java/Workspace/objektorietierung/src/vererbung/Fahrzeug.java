package vererbung;

public class Fahrzeug {
	 private double geschwindigkeit;
	 private double ps;
	 
	 public Fahrzeug(double geschwindigkeit, double ps) {
		 
		 this.geschwindigkeit = geschwindigkeit;
		 this.ps = ps;
	 }

	public double getPs() {
		return ps;
	}

	public void setPs(double ps) {
		this.ps = ps;
	}
	public void ausgabe () {
		System.out.println("ps: " + ps);
		System.out.println("geschwindigkeit: " + geschwindigkeit);
	}
	 
}
