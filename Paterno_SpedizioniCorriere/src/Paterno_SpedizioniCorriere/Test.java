package Paterno_SpedizioniCorriere;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test {
	
	public static void main(String[] args) throws IOException {
		
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Map<String, Spedizioni> listaSpedizioni = new HashMap<>();
		Map<Integer, Clienti> listaClienti = new TreeMap<>();
		Corriere c = new Corriere(listaClienti, listaSpedizioni);
		c.CaricaClienti();
		c.CaricaSpedizioni();
		Scanner input = new Scanner(System.in);
		String scelta1 = "1";
		do 
		{
			System.out.println("MENU");
			System.out.println("1) Nuovo cliente");
			System.out.println("2) Nuova spedizione");
			System.out.println("3) Visualizza spedizione tramite codice");
			System.out.println("4) Visualizza tutti i clienti");
			System.out.println("5) Visualizza tutte le spedizioni");
			System.out.println("0) Esci");
			
			scelta1 = input.nextLine();
			if(scelta1.compareTo("1")==0) {
				System.out.println("Codice: ");
				String codice = input.nextLine();
				System.out.println("Attributi di denominazione: ");
				String attDenominazione = input.nextLine();
				System.out.println("Indirizzo: ");
				String indirizzo = input.nextLine();
				System.out.println("Citta': ");
				String citta = input.nextLine();
				System.out.println("Telefono: ");
				String telefono = input.nextLine();
				Clienti cliente = new Clienti(codice,attDenominazione,indirizzo,citta,telefono);
				c.aggiungiCliente(cliente);
			}
			else if(scelta1.compareTo("2")==0) {
				System.out.println("Descrizione spedizione:");
				String descrizione = input.nextLine();
				System.out.println("Inserisci data di spedizione(dd/MM/yyyy):");
				String data = input.nextLine();
				LocalDate ld = LocalDate.parse(data,formatter);
				System.out.println("Inserisci codice NUMERICO del mittente:");
				String cod1 = input.nextLine();
				Clienti mittente = c.cercaCliente(cod1);
				System.out.println("Inserisci codice NUMERICO del destinatario:");
				String cod2 = input.nextLine();
				Clienti destinatario = c.cercaCliente(cod2);
				System.out.println("Codice consegna:");
				String codice = input.nextLine();
				Spedizioni s = new Spedizioni(descrizione, ld, mittente, destinatario, codice);
				c.aggiungiSpedizione(s);
			}
			else if(scelta1.compareTo("3")==0) {
				System.out.println("Codice consegna da cercare:");
				String cerca= input.nextLine();
				if(c.contiene(cerca)){
					System.out.println(c.cercaSpedizione(cerca).toString());				
				}
			}
			else if(scelta1.compareTo("4")==0) {
				c.stampaClienti();
			}
			else if(scelta1.compareTo("5")==0) {
				c.stampaSpedizioni();
			}
			
		}while(scelta1.compareTo("0")!=0);
		
		c.SalvaCliente();
		c.SalvaSped();
		input.close();
		System.exit(0);		
	}	
}
