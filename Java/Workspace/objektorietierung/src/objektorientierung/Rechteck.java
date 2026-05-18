package objektorientierung;

public class Rechteck {
	//Attribute
		private double seiteA;
		private double seiteB;
		
		//Konstruktor - was soll passieren, wenn ein neues Objekt erzeugt wird
		//创建对象时，自动执行，new 后面的就是执行的这个
		//构造器分为有参构造器和无参构造器，有参构造器是为了方便创建对象时直接给值
		public Rechteck() {
			this.seiteA = 0;
			this.seiteB = 0;
			System.out.println("unser Konstruktor aufgerufen");
		}
		
		//Konstruktor Überladen
		//这个是有参构造器
		public Rechteck(double seiteA, double seiteB) {
			setSeiteAB(seiteA, seiteB);
		}
		
		//Methode
		//SET 方法 设置值 + 检验是否合法 ， 不能是负数
		public void setSeiteA(double seiteA) {
			if(seiteA >= 0)
				this.seiteA = seiteA;
			else
				this.seiteA = 0;
		}
		
		
		public void setSeiteB(double seiteB) {
			if(seiteB >= 0)
				this.seiteB = seiteB;
			else
				this.seiteB = 0;
		}
		
		//一个方法调用另一个方法
		public void setSeiteAB(double seiteA, double seiteB) {
			setSeiteA(seiteA);// 此处为调用之前已经定义好的函数， 所以括号里不需要再写数值类型
			setSeiteB(seiteB);// 参数数值类型只在定义函数的时候需要给出
		}
		
		public void showFlaeche() {
			double flaeche = seiteA * seiteB;
			System.out.println("Flache des Rechtecks: " + flaeche);
		}
		
		//Methoden überladen (gleicher Name, aber unterschiedliche Parameter)
		public void showFlaeche(String text) {
			double flaeche = seiteA * seiteB;
			System.out.println(text + flaeche);
		}
}
