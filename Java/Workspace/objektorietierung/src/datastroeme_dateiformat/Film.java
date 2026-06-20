package datastroeme_dateiformat;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Film {

	private int id;
	private String name;
	private int jahr;
	
	//Konstruktor
	public Film (int id, String name, int jahr) {
		
		this.id = id;
		this.name = name;
		this.jahr = jahr;
		
		
	}
	
	//Methoden
	public void setId(int neueId) {
		this.id = neueId;
	}
	
	public int getId() {
		return id;
}

	public String getName() {
		return name;
	}

	public int getJahr() {
		return jahr;
	}

	public void print() {
		System.out.println(name + "  " + jahr);
	}
	
	public static ArrayList<Film> ladeFilme(String dateiname) throws Exception {
		ArrayList<Film> filme = new ArrayList<>();

		FileReader read = new FileReader(dateiname);
		BufferedReader buf = new BufferedReader(read);
		String line = buf.readLine();

		while ((line = buf.readLine()) != null) {
			String teile[] = line.split(";");

			int id = Integer.parseInt(teile[0]);
			int jahr = Integer.parseInt(teile[2]);

			Film f = new Film(id, teile[1], jahr);
			filme.add(f);
		}

		buf.close();
		return filme;
	}
}	
