package vererbung;

public class Person {
 
	private String name;
	private int geburtsjahr;
	
	public Person (String pName, int pGeburtsjahr) {
		this.name = pName;
		this.geburtsjahr =  pGeburtsjahr;
	}
	
	public String getName() {
		return name;
	}
  public int getGeburtsjahr() {
	return geburtsjahr;
}
  
  // Beispiel Methodenüberschreiben
  public void ausgeben() {
	  System.out.println("Name: " + name);
	  System.out.println("Geburtsjahr: " + geburtsjahr);
  }
}
