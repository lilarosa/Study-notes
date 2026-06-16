package vererbung;

public class LKW extends Fahrzeug {
	private int last;
	public LKW (double geschwindigkeit, double ps, int last) {
		super(geschwindigkeit, ps);
		this.last = last;
		
	}
	public void erhoeheLast(int last) {
		this.last = this.last+last;
		System.out.println("neu Last: " + this.last);
	} 
	
	/* public void erhoeheLast(int wert) {
	last+ = wert;
} */
	public void ausgabe() {
		super.ausgabe();
		System.out.println("Last: " + last);
		
	}
}