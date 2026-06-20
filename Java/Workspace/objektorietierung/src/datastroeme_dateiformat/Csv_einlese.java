package datastroeme_dateiformat;

import java.util.ArrayList;

public class Csv_einlese {

	public static void main(String[] args) {
		
		
		try {
			ArrayList<Film> filme = Film.ladeFilme("Filme.csv");
			int filmAnzahl = 0;
			int filmAnzahlAb2009 = 0;
			Film aeltesterFilm = null;

			for (Film film : filme) {
				filmAnzahl++;
				
				if (film.getJahr() > 2009) {
					filmAnzahlAb2009++;
					film.print();
				}

				if (aeltesterFilm == null || film.getJahr() < aeltesterFilm.getJahr()) {
					aeltesterFilm = film;
				}
			}
			
			 System.out.println("Filme ab Jahr 2009 sind: " + filmAnzahlAb2009);
			 System.out.println("Anzahl von Filme sind: " + filmAnzahl);
			 System.out.print("Der aelteste Film ist: ");
			 aeltesterFilm.print();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Fehler");
			e.printStackTrace();
		}
		
		}
	}

