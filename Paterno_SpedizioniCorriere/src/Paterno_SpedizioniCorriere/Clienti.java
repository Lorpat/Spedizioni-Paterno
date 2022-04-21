package Paterno_SpedizioniCorriere;

public class Clienti {
	
	private String codice;
	private String attDenominazione;
	private String indirizzo;
	private String citta;
	private String telefono;
	
	public Clienti(String codice, String attDenominazione, String indirizzo, String citta, String telefono) {
		super();
		this.codice = codice;
		this.attDenominazione = attDenominazione;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.telefono = telefono;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getAttDenominazione() {
		return attDenominazione;
	}

	public void setAttDenominazione(String attDenominazione) {
		this.attDenominazione = attDenominazione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Codice: " + codice + ", Attributi denominazione: " + attDenominazione + ", Indirizzo: " + indirizzo
				+ ", Citta': " + citta + ", Telefono: " + telefono;
	}
	
	public String toString2() {
		return codice + "," + attDenominazione + "," + indirizzo + "," + citta + "," + telefono;
	}
	
	

}
