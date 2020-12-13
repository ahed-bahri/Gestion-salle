package gestion_salle;

public class Etudiant {
	
    private String nomEtudiant, prenomEtudiant, adresseEtudiant;
    private int id;
	public Etudiant() {	
		super();
	}

	public Etudiant(int id, String nomEtudiant, String prenomEtudiant, String adresseEtudiant) {
		super();
		this.id=id;
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.adresseEtudiant = adresseEtudiant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomEtudiant() {
		return nomEtudiant;
	}

	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
	}

	public String getPrenomEtudiant() {
		return prenomEtudiant;
	}

	public void setPrenomEtudiant(String prenomEtudiant) {
		this.prenomEtudiant = prenomEtudiant;
	}

	public String getAdresseEtudiant() {
		return adresseEtudiant;
	}

	public void setAdresseEtudiant(String adresseEtudiant) {
		this.adresseEtudiant = adresseEtudiant;
	}

	@Override
	public String toString() {
		return "Etudiant [nomEtudiant=" + nomEtudiant + ", prenomEtudiant=" + prenomEtudiant + ", adresseEtudiant="
				+ adresseEtudiant + ", id=" + id + "]";
	}	
	
}
