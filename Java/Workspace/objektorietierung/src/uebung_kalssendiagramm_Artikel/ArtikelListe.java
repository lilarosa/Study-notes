package uebung_kalssendiagramm_Artikel;

import java.util.ArrayList;
import java.util.List;

public class ArtikelListe {
	
	private List<Artikel> artikelListe; 
	// 声明一个变量 artikelListe
	// 它的类型是 List<Artikel>
	// 也就是说：它将来可以保存一个“装 Artikel 的列表对象”
	// 但这里只是声明，还没有创建真正的列表，所以默认值是 null
	
	private String listenName;
	// 声明一个 String 类型的属性，用来保存列表名称
	// String 也是类，所以默认值也是 null
	
	public ArtikelListe(String listenName) {
	    this.listenName = listenName;
	    // 把传进来的列表名字保存到对象属性中

	    artikelListe = new ArrayList<>();
	    // 创建一个真正的 ArrayList 对象
	    // 让 artikelListe 变量指向这个空列表
	}
	
	public List <Artikel> getArtikelListe(){
		return artikelListe;
	}
	public void addArtikel(Artikel artikel)	{
		artikelListe.add(artikel);
	}
	public void removeArtikel(Artikel artikel) {
		artikelListe.remove(artikel);
	}
	public int getAnzahlArtikel() {
		//return artikelListe.size();这样更安全，因为数量永远和列表真实内容一致。
		return artikelListe.size();
	
	}

	public String getListenName() {
		return listenName;
	}
	
}
