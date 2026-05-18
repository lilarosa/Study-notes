package vererbung;

public class Hautklasse {
// 子类可以继承母类的所有方法， 可以直接调用
	public static void main(String[] args) {
		
		Lehrer L1 = new Lehrer ("Hans Meier", 1970, "Mathe", "Deutsch");
		Schueler s1 = new Schueler ("Tim", 2015, 5, 2026);
		s1.ausgeben();// Schueler erbt die Methode ausgeben von Person
		L1.ausgeben();//子类对象可以直接调用母类方法， 也可以调用子类中重写的母类方法
		//Polymorphie
		System.out.println(L1 instanceof Lehrer);
		System.out.println(L1 instanceof Person);
		
		/* das Objekt L1 hat mehrere Formen,
		 * es ist sowhol ein objekt der Klasse Lehrer
		 * als auch ein Objekt der Oberklasse Person
		 * das nennt man Polymorphie
		 */
	}

}
