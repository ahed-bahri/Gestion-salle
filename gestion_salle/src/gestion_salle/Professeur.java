package gestion_salle;

public class Professeur {
	
    private String nomProf, prenomProf, adresseProf;
    private int id;
    
	public Professeur() {
		super();
	}

	public Professeur(int id, String nomProf, String prenomProf, String adresseProf) {
		super();
		this.nomProf = nomProf;
		this.prenomProf = prenomProf;
		this.adresseProf = adresseProf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomProf() {
		return nomProf;
	}

	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}

	public String getPrenomProf() {
		return prenomProf;
	}

	public void setPrenomProf(String prenomProf) {
		this.prenomProf = prenomProf;
	}

	public String getAdresseProf() {
		return adresseProf;
	}

	public void setAdresseProf(String adresseProf) {
		this.adresseProf = adresseProf;
	}

	@Override
	public String toString() {
		return "Professeur [nomProf=" + nomProf + ", prenomProf=" + prenomProf + ", adresseProf=" + adresseProf
				+ ", id=" + id + "]";
	}

}
