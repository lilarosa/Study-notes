package datastroeme_dateiformat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Textdatei_einfach {

	public static void main(String[] args){
		/* Try-catch verhindert das Abstürzen des Programm
		* Die Anweisung im try-Block werden versucht auszuführen
		* sollte dabai eine Fehler auftreten (Exception),
		* dann wird automatisch in den catch-gesprungen
		* dort behandelt ihr den (z.B eine Fehlermeldung)
		* das Programm stürzt nicht ab und läuft hinter
		* dem catch-Block normal weiter
		*/
		
		try {
			// stellt einen Datenstrom zu  einer Datei her(öffnet eine Datei)
			FileReader reader = new FileReader("Hallo.log");
			
			//einzelne Zeichen zu ganzen Zeilen zusammmenfassen (puffern)
			BufferedReader buf = new BufferedReader(reader);
			
			//Datein zeileweise einlesen
			String zeile = buf.readLine();  //erste Zeile
			
			while(zeile != null) {// solange es noch Zeilen gibt
		     System.out.println(zeile);	
		     zeile = buf.readLine();
				
			} 
			buf.close();
			reader.close();
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();// print out whole progress of the error, works also with sysout
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		}

	}


