package uebung_kalssendiagramm_Artikel;

import java.util.ArrayList;
import java.util.List;

public class ArtikelListe {
	private List <Artikel> artikelListe; // 声明List，java自带的接口下的artikelListe变量，值为null
	private String listenName;//声明String类下的listenName属性或变量
	private int anzahlArtikel;
	
	public ArtikelListe(String listenName) {//有参构造器
		this.listenName = listenName; //赋值属性
		artikelListe = new ArrayList<>();
	}//创建类内部对象
	
	public List <Artikel> getArtikelListe(){
		return artikelListe;
	}
	public void addArtikel(Artikel artikel)	{
		artikelListe.add(artikel);
		anzahlArtikel++;
	}
	public void removeArtikel(Artikel artikel) {
		artikelListe.remove(artikel);
		anzahlArtikel--;
	}
	public int getAnzahlArtikel() {
		//return artikelListe.size();
		return anzahlArtikel;
	
	}
	
}
