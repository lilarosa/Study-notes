package objektorientierung;

public class Benutzergeruppe {
   String name;
   String beschreibung;
   String berechtigung;
   Benutzer [] benutzern = new Benutzer[4];
   
   public void setName(String name) {
	   this.name = name;
   }
   
   public String getName() {
	   return name;
   }
   
   public void addBenutzer(Benutzer benu) {
	   benutzern[0] = benu;
	   
   }
} 
