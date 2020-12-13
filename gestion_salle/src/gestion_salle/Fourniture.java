package gestion_salle;

public class Fourniture {
	
	int porte, chaise, fenetre, dataShow;

	public Fourniture() {
		super();
	}

	public Fourniture(int porte, int chaise, int fenetre, int dataShow) {
		super();
		this.porte = porte;
		this.chaise = chaise;
		this.fenetre = fenetre;
		this.dataShow = dataShow;
	}

	public int getPorte() {
		return porte;
	}

	public void setPorte(int porte) {
		this.porte = porte;
	}

	public int getChaise() {
		return chaise;
	}

	public void setChaise(int chaise) {
		this.chaise = chaise;
	}

	public int getFenetre() {
		return fenetre;
	}

	public void setFenetre(int fenetre) {
		this.fenetre = fenetre;
	}

	public int getDataShow() {
		return dataShow;
	}

	public void setDataShow(int dataShow) {
		this.dataShow = dataShow;
	}

	@Override
	public String toString() {
		return "Fourniture [porte=" + porte + ", chaise=" + chaise + ", fenetre=" + fenetre + ", dataShow=" + dataShow
				+ "]";
	}
		
}
