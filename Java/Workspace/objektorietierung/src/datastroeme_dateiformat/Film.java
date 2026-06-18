package datastroeme_dateiformat;

public class Film {

	private int id;
	private String name;
	private int jahr;
	
	//Konstruktor
	public Film (int id, String name, int jahr) {
		
		this.id = id;
		this.name = name;
		this.jahr = jahr;
		
	}
	
	//Methoden
	public void setId(int neueId) {
		this.id = neueId;
	}
	
	public int getId() {
		return id;
}
	public void print() {
		System.out.println(name + "  " + jahr);
	}
}	
