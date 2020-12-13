package gestion_salle;

public class Machine {

	String Marque, couleur,Processeur ;
	int  id;
	
	
	public Machine() {
		super();
	}

	
	public Machine(String marque, String couleur, String processeur, int id) {
		super();
		Marque = marque;
		this.couleur = couleur;
		Processeur = processeur;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarque() {
		return Marque;
	}
	public void setMarque(String marque) {
		Marque = marque;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public String getProcesseur() {
		return Processeur;
	}

	public void setProcesseur(String processeur) {
		Processeur = processeur;
	}

	@Override
	public String toString() {
		return "Machine [Marque=" + Marque + ", couleur=" + couleur + ", Processeur=" + Processeur + ", id=" + id + "]";
	}
	
	
}
