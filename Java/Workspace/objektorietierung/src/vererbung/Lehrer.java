package vererbung;

public class Lehrer extends Person  {
  private String erstesFach;
  private String zweitesfach;
  
  /* auch ein Lehrer hat einen Namen und ein Geburtsjahr.
   * Diese beiden Attribute erbt er aber aus Klasse Person
   */
  
  public Lehrer(String pName,  int pGeburtsjahr, String pErstesfach, String pZweitesFach)
  {
   super(pName, pGeburtsjahr);
   erstesFach = pErstesfach;
   zweitesfach = pZweitesFach;
}
  public String getErstesfach () {
	  return erstesFach;
  }
  
  public String getZweitesfach () {
	  return  zweitesfach;
  }
  // Beispiel Methoden Überschreiben
  public void ausgeben() {
	  
	  super.ausgeben(); // ruft ausgeben der klasse Person auf (also Name und Geburtsjahr)
	  System.out.println("erstesFach: " + erstesFach);
	  System.out.println("zweitesFach: " + zweitesfach);
  }
	  
  }

/* 子类关键字extends 继承母类， 子类中可以用SUPER关键字调用母类的方法，在方法重写中继续进行个性化的方法定义*/