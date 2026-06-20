package Uebung_Dateistroem_Firewall;

import java.io.BufferedReader;
import java.io.FileReader;

public class FirewallLog {
	public static void main(String[] args) {
		
		try {
			
			FileReader reader = new FileReader("logfile.log");
			BufferedReader read = new BufferedReader(reader);
			String zeile = read.readLine();
			
			while ( (zeile = read.readLine())!= null) {
				String teile[]= zeile.split(";");
				
				int port  = Integer.parseInt(teile[3]);
				
				String action = teile[4];
				
				if (port == 445 && action.equals("Drop")) // if ( teile[2].equals("TCP")) filtered with other factors
					
				{
					
					System.out.println("Quell IP: " + teile[0]);
				}
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
		e.printStackTrace();
		}
	}
}
	
	
