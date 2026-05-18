package abstrakteKlasse;

public class Rechnung extends Dokument {
	private int rechnungsNr;
	private double betrag;
	
	public Rechnung(int id, String bezeichnung, int rechnungsNr, double betrag) {
		super(id, bezeichnung);
		this.rechnungsNr = rechnungsNr;
		this.betrag = betrag;
	}


	@Override
	public void ausgeben() {
		// 抽象母类中继承的方法必须在此实现
		System.out.println("Rechnung: " + rechnungsNr);
		System.out.println("aht den Betrag:" + betrag);
		System.out.println("hat die Dokumentnr: " + super.getID());
		System.out.println("hat die Dokumentbezeichnung: " + super.getBezeichnung());}
}
