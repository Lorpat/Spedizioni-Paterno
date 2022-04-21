package Paterno_SpedizioniCorriere;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Spedizioni {
	
	private String descrizione;
	private LocalDate ld;
	private Clienti mittente;
	private Clienti destinatario;
	private String codice;
	
	DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Spedizioni(String descrizione, LocalDate ld, Clienti mittente, Clienti destinatario, String codice) {
		super();
		this.descrizione = descrizione;
		this.ld = ld;
		this.mittente = mittente;
		this.destinatario = destinatario;
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDate getLd() {
		return ld;
	}

	public void setLd(LocalDate ld) {
		this.ld = ld;
	}

	public Clienti getMittente() {
		return mittente;
	}

	public void setMittente(Clienti mittente) {
		this.mittente = mittente;
	}

	public Clienti getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Clienti destinatario) {
		this.destinatario = destinatario;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	@Override
	public String toString() {
		return "Codice: " + codice + ", Data: " + ld.format(formatter) + ", Mittente: " + mittente.toString() + ", Destinatario: "
				+ destinatario.toString() + ", Descrizione: " + descrizione;
	}
	
	public String toString2() {
		return codice + "," + ld.format(formatter) + "," + mittente.toString2() + ","
				+ destinatario.toString2() + "," + descrizione;
	}
	
	
}
