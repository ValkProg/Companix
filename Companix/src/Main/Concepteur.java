package Main;

import java.util.Date;

public class Concepteur extends Salarie {

	private String devAnnee;
	
	Concepteur(String code, String nom, String prenom, String dateEmbauche, String devAnnee) {
		super(code, nom, prenom, dateEmbauche);
		this.setDevAnnee(devAnnee);
	}

	public String getDevAnnee() {
		return devAnnee;
	}

	public void setDevAnnee(String devAnnee) {
		this.devAnnee = devAnnee;
	}
	
}
