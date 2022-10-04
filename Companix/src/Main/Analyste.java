package Main;

import java.util.Date;

public class Analyste extends Salarie {

	private String deplacement;
	
	Analyste(String code, String nom, String prenom, String dateEmbauche, String deplacement) {
		super(code, nom, prenom, dateEmbauche);
		this.setDeplacement(deplacement);
	}

	public String getDeplacement() {
		return deplacement;
	}

	public void setDeplacement(String deplacement) {
		this.deplacement = deplacement;
	}
}
