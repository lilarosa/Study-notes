package uebung_kalssendiagramm_Artikel;


public class Kunde implements Druckbar {
	private String name;
	
	public Kunde(String name) {
		this.name =  name;
	}	
	
	public String getName() {
		return name;
	}	 
	public void setName(String name ) {
		this.name = name;
		
	}

	@Override
	public void drucken() {
		System.out.println("Kunde: " + name);
	}
	
	}
