package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Map<String, Salarie> salaries = new HashMap<String, Salarie>();

		Boolean loop = true;
		
		while(loop){
			System.out.println("1- Ajouter un concepteur");
			System.out.println("2- Supprimer un concepteur");
			System.out.println("3- Liste des concepteurs");
			System.out.println("4- Ajouter un analyste");
			System.out.println("5- SUpprimer un analyste");
			System.out.println("6- Lister les salariés existants");
			System.out.println("7- Quitter");
			String choise = scanner.nextLine();

			switch(choise) {
				case "1" : createConcepteur(salaries);
					break;
				case "2" : deleteConcepteur(salaries);
					break;
				case "3" : showConcepteurs(salaries);
					break;
				case "4" : createAnalyste(salaries);
					break;
				case "5" : deleteAnalyste(salaries);
					break;
				case "6" : showAllSalarie(salaries);
					break;
				case "7": loop = false;
					break;
			}
		}
	}
	
	static private void createConcepteur(Map<String, Salarie> salaries) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisir le code, nom, prénom, date d'embauche et nombre d'année de développement :");
		String values = scanner.nextLine();
		
		String words[] = values.split("-");

		Concepteur concepteur = new Concepteur(words[0], words[1], words[2], words[3], words[4]);
		
		if(salaries.containsKey(words[0])) {
			System.out.println("Le salarié existe déjà");
		}
		else salaries.put(words[0], concepteur);
	}
	
	static private void deleteConcepteur(Map<String, Salarie> salaries) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisir le code : ");
		String value = scanner.nextLine();
		if(!salaries.containsKey(value)) {
			System.out.println("Le salarié n'existe pas");
		}
		else if(salaries.get(value) instanceof Concepteur) {
			salaries.remove(value);
		}
	}
	
	static private void showConcepteurs(Map<String, Salarie> salaries) {
		for (Map.Entry<String, Salarie> set : salaries.entrySet()) {
			if(set.getValue() instanceof Concepteur)
				System.out.println(set.getKey() + " = " + set.getValue().getNom());
		}
	}
	
	static private void createAnalyste(Map<String, Salarie> salaries) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisir le code, nom, prénom, date d'embauche et nombre de deplacement :");
		String values = scanner.nextLine();

		String words[] = values.split("-");
		System.out.println(words);

		Analyste analyste = new Analyste(words[0], words[1], words[2], words[3], words[4]);

		if(salaries.containsKey(words[0])) {
			System.out.println("Le salarié existe déjà");
		}
		else salaries.put(words[0], analyste);
	}
	
	 static private void deleteAnalyste(Map<String, Salarie> salaries) {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Saisir le code : ");
		 String value = scanner.nextLine();
		 if(!salaries.containsKey(value)) {
			System.out.println("Le salarié n'existe pas");
		 }
		 else if(salaries.get(value) instanceof Analyste) {
			 salaries.remove(value);
		 }
	}
	 
	static private void showAllSalarie(Map<String, Salarie> salaries) {
		//Création d'une autre MAP qui tri la MAP récupérer
		Map<String, Salarie> salariesSorted = new TreeMap<String, Salarie>(salaries);
		for (Map.Entry<String, Salarie> set : salariesSorted.entrySet()) {
			String type = set.getValue() instanceof Analyste ? "Analyste" : "Concepteur";
			System.out.println(type + " : " + set.getKey() + " = " + set.getValue().getNom());
		}
	}
}
