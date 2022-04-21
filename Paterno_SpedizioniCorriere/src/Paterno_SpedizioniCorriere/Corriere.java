package Paterno_SpedizioniCorriere;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;


public class Corriere {

	private Map<Integer, Clienti> listaClienti;
	private Map<String, Spedizioni> listaSpedizioni;
	DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Corriere(Map<Integer, Clienti> listaClienti, Map<String, Spedizioni> listaSpedizioni) {
		super();
		this.listaClienti = listaClienti;
		this.listaSpedizioni = listaSpedizioni;
	}

	public Map<Integer, Clienti> getListaClienti() {
		return listaClienti;
	}



	public void setListaClienti(Map<Integer, Clienti> listaClienti) {
		this.listaClienti = listaClienti;
	}



	public Map<String, Spedizioni> getListaSpedizioni() {
		return listaSpedizioni;
	}



	public void setListaSpedizioni(Map<String, Spedizioni> listaSpedizioni) {
		this.listaSpedizioni = listaSpedizioni;
	}

	public void aggiungiSpedizione(Spedizioni s) {
		listaSpedizioni.put(s.getCodice(), s);
	}
	
	public void aggiungiCliente(Clienti c) {
		listaClienti.put(Integer.parseInt(c.getCodice()), c);
	}
	
	public Spedizioni cercaSpedizione(String c) {
		return listaSpedizioni.get(c);
	}
	
	public boolean contiene(String c) {
		if(listaSpedizioni.containsKey(c)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Clienti cercaCliente(String c) {
		if(listaClienti.containsKey(Integer.parseInt(c))){
			return listaClienti.get(Integer.parseInt(c));			
		}
		else {
			System.out.println("Codice Errato");
			return null;
		}
	}
	
	public void stampaClienti() {
		if(listaClienti.isEmpty()) {
			System.out.println("Lista vuota");
		}
		else 
		{
			for (int i : listaClienti.keySet()) {
				System.out.println(listaClienti.get(i).toString());
				}
		}
	}
	
	public void stampaSpedizioni() {
		if(listaClienti.isEmpty()) {
			System.out.println("Lista vuota");
		}
		else 
		{
			for (String i : listaSpedizioni.keySet()) {
				System.out.println(listaSpedizioni.get(i).toString());
			}		
		}
	}

	public void CaricaSpedizioni() throws IOException {
		String line;
		BufferedReader br = new BufferedReader(new FileReader("src\\Spedizioni.dat"));
		String data[] = new String[12];
		while ((line = br.readLine()) != null) {// Leggo il file riga per riga

			data = line.split(",");// Uso il separatore per estrarre i valori campo per campo
			Spedizioni s = new Spedizioni(data[0],LocalDate.parse(data[1],formatter),new Clienti(data[2],data[3],data[4],data[5],data[6]),new Clienti(data[7],data[8],data[9],data[10],data[11]), data[12]);
			this.aggiungiSpedizione(s);
		}
		br.close();
	}
	
	
	public void SalvaSped() throws IOException {
		FileWriter myWriter = new FileWriter("src\\Spedizioni.dat");
		for (String s : listaSpedizioni.keySet()) {
			myWriter.write(listaSpedizioni.get(s).toString2()+"\n");
		}
		myWriter.close();
	}
	
	public void CaricaClienti() throws IOException {
		String line;
		BufferedReader br = new BufferedReader(new FileReader("src\\Clienti.dat"));
		String data[] = new String[5];
		while ((line = br.readLine()) != null) {// Leggo il file riga per riga

			data = line.split(",");// Uso il separatore per estrarre i valori campo per campo
			Clienti c = new Clienti(data[0],data[1],data[2],data[3],data[4]);
			this.aggiungiCliente(c);
		}
		br.close();
	}
	
	
	public void SalvaCliente() throws IOException {
		FileWriter myWriter = new FileWriter("src\\Clienti.dat");
		for (Integer s : listaClienti.keySet()) {
			myWriter.write(listaClienti.get(s).toString2()+"\n");
		}
		myWriter.close();
	}
}

