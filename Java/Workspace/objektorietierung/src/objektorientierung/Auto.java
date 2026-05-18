package objektorientierung;

public class Auto {
	//Attribute
		private String name;
		private String farbe;
		private int ps;
		private double hubraum;
		
		//Methoden 
		//regeln den Zugriff auf Attribute
		
		//Methoden um die Atrribute zu setzen
		public void setName(String name) {
			this.name = name;
		}
		
		public void setFarbe(String farbe) {
			this.farbe = farbe;
		}
		
		public void setPs(int ps) {
			this.ps = ps;
		}
		
		public void setHubraum(double hubraum) {
			this.hubraum = hubraum;
		}
		
		//Methoden um Werte der Attribute zu lesen
		public String getName() {
			return name;
		}
		
		public String getFarbe() {
			return farbe;
		}
		
		public int getPs() {
			return ps;
		}
		
		public double getHubraum() {
			return hubraum;
		}
}
