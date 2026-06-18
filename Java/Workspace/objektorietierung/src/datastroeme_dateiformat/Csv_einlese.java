package datastroeme_dateiformat;

import java.io.BufferedReader;
import java.io.FileReader;

public class Csv_einlese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FileReader read = new FileReader("Filme.csv");
			BufferedReader buf = new BufferedReader(read);
			
			String line = buf.readLine();
			
			while ((line = buf.readLine()) != null) {// for the last line null != null ,the program returned.
				
				line = buf.readLine();
				
				String teile[] = line.split(";");// Apt1 Punkte ,teilt die Zeile bei ; und speichert die Teile in einem Array
				 
				int id = Integer.parseInt(teile[0]); // daten konsistent ,must change the parameter type to int
				int jahr = Integer.parseInt(teile[3]);
				
				// neun objekt erzeugen
				Film f = new Film(id, teile[1], jahr);// parapmeter type should in constent with class Filme constructor
				 f.print(); 
				 
				/*int year = Integer.parseInt(teile[2]);// Must change the type String to Int for following operation
				 if(year>2009) {
					 System.out.println("Titel: " + teile[1] + "Jahr: " + teile[2]);
					 
				 }
				//System.out.println("Titel: " + teile[1] + "Jahr: " + teile[2]);
				*/
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Fehler");
			e.printStackTrace();
		}
		
		}
	}


