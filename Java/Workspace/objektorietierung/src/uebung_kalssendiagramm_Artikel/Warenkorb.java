package uebung_kalssendiagramm_Artikel;//Warenkorb ist eine spezielle Artikelliste

public class Warenkorb extends ArtikelListe{

	private Kunde kunde;
	
	public Warenkorb (Kunde kunde) {
		//每一个 Warenkorb 对象里面，都保存着一个 Kunde 对象。也就是说，一个购物车属于一个客户。
		//every Warekorb must be created with a Kunde,创建购物车的时候，必须传进来一个客户对象。
		super("warenkorb");// konstruktur abrufen von ArtikelListe
		this.kunde = kunde; //把传进来的客户对象，保存到这个购物车自己的 kunde 属性里。
		
	}
	public double berechneGesamtpreis() {
		double summe = 0;
		for (Artikel artikel : getArtikelListe()) {
			//从商品列表 getArtikelliste() 中，一个一个取出 Artikel，每次暂时叫它 artikel。
			summe += artikel.getPreis();
			//对购物车里的每一个商品，取出它的价格，加到总价里面。
		}
		return summe;
	}
	
	public void warenkorbAnzeigen() {
		System.out.println("Kunde name: "+ kunde.getName());
		double summe = 0;
		for (Artikel artikel : getArtikelListe()) {
			System.out.println("Waren :"+artikel.getArtikelName());
			summe += artikel.getPreis();
		}
		
		System.out.println("summe: " + summe);
		
	}
		
	}


/*子类构造器不需要和父类构造器参数保持一样。

真正的规则是：

子类构造器里面，必须能够调用到父类的某一个构造器。
但是子类自己的参数可以完全不一样。

public Warenkorb(Kunde kunde) {
// 先创建父类 ArtikelListe 的那部分
super("warenkorb");

// 再创建 Warenkorb 自己的那部分
this.kunde = kunde;
}

Warenkorb 对象
├── 父类继承来的部分
│   ├── listenName = "warenkorb"
│   └── artikelListe = new ArrayList<>()
│
└── 子类自己的部分
    └── kunde = kunde1
    
    写法 2：外面同时传列表名字和顾客
    public Warenkorb(String listenName, Kunde kunde) {
    super(listenName);
    this.kunde = kunde;
}
*/