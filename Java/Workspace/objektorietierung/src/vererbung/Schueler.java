package vererbung;

public class Schueler extends Person {
   
	private int stufe;
	private int abijahrgang;
	
	public Schueler(String pName, int pGeburtsjahr, int pStufe, int pAbijahrgang)
	{
		super(pName, pGeburtsjahr);
		this.stufe = pStufe;
		this.abijahrgang = pAbijahrgang;
		
	}
	

	public int getStufe() {
		return stufe;
	}

	public int getAbijahrgang() {
		return abijahrgang;
	}


	}
