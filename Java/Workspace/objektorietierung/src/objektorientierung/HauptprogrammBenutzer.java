package objektorientierung;

public class HauptprogrammBenutzer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Benutzer nutzerA = new Benutzer ();
    nutzerA.setName("Lisa Müller");
    nutzerA.setEmail("lis@yahoo.de");
    
    Benutzer nutzerB = new Benutzer ();
    nutzerB.setName("Hans Meier");
    nutzerB.setEmail("hans@gms.com");
    
    
    Benutzergeruppe gruppe = new Benutzergeruppe();
    gruppe.setName("Admins");
    gruppe.addBenutzer(nutzerA);
	}

}
