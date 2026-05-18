package abstrakteKlasse;

public abstract class Dokument {
	private int id;
	private String bezeichnung;
	
public Dokument (int id, String bezeichnung)
	{	this.id = id;
		this.bezeichnung = bezeichnung;
	}	
		
public int getID() {
	
		return id;
	}
	
public String getBezeichnung() {
		return bezeichnung;
	}



//抽象类和普通类基本一样 只要加关键词抽象， 此外不能从此类直接创建对象

// abstrakte Methode => keine Implentierung

public abstract void ausgeben();

}