package gestion_salle;
import java.util.ArrayList;
import java.util.Scanner;
public class Menu {

    private Scanner sc = new Scanner(System.in);
	private ArrayList<Etudiant> listEtudiant = new ArrayList<Etudiant>();
    private ArrayList<Professeur> listProfesseur = new ArrayList<Professeur>();
	private ArrayList<Machine> listMachines = new ArrayList<Machine>();
    private ArrayList<Fourniture> listFourniture = new ArrayList<Fourniture>();   
    private int id_Etudiant = 100, id_Professeur=200, id_Machine=1;
    
    public static void main(String[] args){
    	Menu menu = new Menu();        
        menu.choixMenu();
    }
	
    public void choixMenu(){
        String choix = "q";
        do {	
        	System.out.println("\n\n---------------------=*=*=*=*Menu Principal=*=*=*=*---------------------");
			System.out.println("\n 1- Gestion des Etudiants");
			System.out.println("\n 2- Gestion des Professeurs");
			System.out.println("\n 3- Gestion des Fourniture");
			System.out.println("\n q- Quit ");
			System.out.println("Veuillez Taper votre choix");
            choix=sc.nextLine();
            switch (choix){
                case "1": gestionEtudiant(); break;
                case "2": gestionProfesseur(); break;
                //case "3": gestionFourniture(); break;
                case "q":
                    System.out.println("\t\t\t\t Vous Avez Quitter... Bye (∗ ･‿･)ﾉ゛");
                    System.exit(0); break;      
                default: System.out.println("\t Votre Choix Est Incorrect"); break;
            }
        }while (true);
    }

    /* ********************************************Debut Gestion Etudiant******************************************** */
    public void gestionEtudiant(){
        String choixEtud = "r";
        do {
        	System.out.println("\n\n---------------------=*=*=*=*Gestion des etudiants=*=*=*=*---------------------");
			System.out.println("\n\t-1- Ajouter un Etudiant");
			System.out.println("\n\t-2- Suppimer un Etudiant");
			System.out.println("\n\t-3- Modifier un Etudiant");
			System.out.println("\n\t-4- Afficher les Etudiants");
			System.out.println("\n\t-R- Menu Principale ");
			System.out.println("Entrer vortre choix");
            
			choixEtud=sc.nextLine();
            switch (choixEtud){
                case "1":   ajouterEtudiant(); break;
                case "2":   supprimerEtudiant(); break;
                case "3":   modifierEtudiant(); break;
                case "4":   afficherEtudiant(); break;
                case "r":   choixMenu(); break;
                default: System.out.println("\t Votre Choix Est Incorrect"); break;
            }
        }while (!choixEtud.equals("r"));
    }
    
    public void ajouterEtudiant(){
    	System.out.println("\n\n---------------------=*=*=*=*Ajouter un nouveau Etudiant=*=*=*=*---------------------");
        Etudiant etud = new Etudiant();
        etud.setId(id_Etudiant);
        System.out.println("\t Nom  >> ");
        etud.setNomEtudiant(sc.nextLine());
        System.out.println("\t Prenom  >> ");
        etud.setPrenomEtudiant(sc.nextLine());
        System.out.println("\t Adresse >> ");
        etud.setAdresseEtudiant(sc.nextLine());
        this.listEtudiant.add(etud);
        this.id_Etudiant++;
        System.out.println("\t Etudiant "+etud.getPrenomEtudiant()+" "+etud.getNomEtudiant()+" ajouter avec succes ヾ(⌒Λ⌒)ノ");
    }
   
    public void supprimerEtudiant(){
    	System.out.println("\n\n---------------------=*=*=*=*Supprimer un Etudiant=*=*=*=*---------------------");
        Etudiant etud = new Etudiant();
        String choix ="0";
        etud = chercherEtudiantById();
        System.out.println("\t Vous voulez Supprimer l'etudiant : "+etud.getPrenomEtudiant()+" "+etud.getNomEtudiant()+" ?");
        System.out.println("\t 1- Oui Exactement");
        if (sc.nextLine().equals("1")){
        	listEtudiant.remove(etud);
            System.out.println("\t La suppression est effectuer avec succes ");
            return;
        }else
            System.out.println("\t Non, Annuler");
    }
    
	//System.out.println("\n\n---------------------=*=*=*=*Chercher avec ID de l'Etudiant=*=*=*=*---------------------");
    public Etudiant chercherEtudiantById(){
        int id=0;
        String choix;
        Etudiant etudiant = new Etudiant();
        do {
			System.out.println("\t 1- Afficher les Etudiants");
            System.out.println("\t 2- Taper l'ID de l'etudiant a modifier");
			System.out.println("\t-R- Menu Principale ");
			System.out.println("Entrer votre choix");
            choix = sc.nextLine();
            switch (choix){
                case "1": afficherEtudiant(); break;
                case "2":
                    System.out.println("\t Entrer l'ID de l'etudiant SVP >> ");
                    id = sc.nextInt();
                    sc.nextLine();
                    for (Etudiant etud:listEtudiant)
                        if (etud.getId() == id)
                            return etud;
                    System.out.println("\t Oups, Etudiant introuvable! Veuillez Réssayer ༼ʘ̚ل͜ʘ̚༽");
                    break;
                case "r": gestionEtudiant(); break;
                default:
                    System.out.println("\t Choix Incorrect ! Veuillez Réssayer ༼ʘ̚ل͜ʘ̚༽");
                    break;
            }
        }while (!choix.equals("r"));
        return etudiant;
    }
	
    public void afficherEtudiant(){
    	System.out.println("\n\n---------------------=*=*=*=*Liste des Etudiant=*=*=*=*---------------------");
        if (listEtudiant.size() == 0)
            System.out.println("\t Aucun Etudiant est enregistrer. ◉_◉");
        else{
             System.out.println("|  ID |\t\t Nom \t\t|\t\t Prenom \t\t|\t\t Adresse \t\t\n|");
             for (Etudiant etud:listEtudiant){
            	 afficherCeEtudiant(etud);
            }
        }
        System.out.println("\n\t Appuyez Taper sur Entrer pour continuer.");
        sc.nextLine();
    }
    
    public void afficherCeEtudiant(Etudiant etud){
        System.out.printf("%8d   ",etud.getId());
        System.out.printf("|%25s   ",etud.getNomEtudiant());
        System.out.printf("|%25s   ",etud.getPrenomEtudiant());
        System.out.printf("|%35s  ",etud.getAdresseEtudiant());
        System.out.printf("\n\n");
 }
    
    public void modifierEtudiant(){
    	System.out.println("\n\n---------------------=*=*=*=*Modifier un Etudiant=*=*=*=*---------------------");
        String choix;
        Etudiant etud = new Etudiant();
        etud = chercherEtudiantById();
        System.out.println("\t Choisir le champ que vous voulez modifier de : "+etud.getPrenomEtudiant()+" "+etud.getNomEtudiant());
        do {
            System.out.println("\t 1- Nom ("+etud.getNomEtudiant()+")");
            System.out.println("\t 2- Prenom ("+etud.getPrenomEtudiant()+")");
            System.out.println("\t 3- Adresse ("+etud.getAdresseEtudiant()+")");
            System.out.println("\t r- Retour au Menu Principale");
            
            choix = sc.nextLine();
            switch (choix) {
                case "1":
                    System.out.println("\t Entrer le nouveau Nom >>");
                    etud.setNomEtudiant(sc.nextLine());
                    break;
                case "2":
                    System.out.println("\t Entrer le nouveau Prenom >>");
                    etud.setPrenomEtudiant(sc.nextLine());
                    break;
                case "3":
                    System.out.println("\t Entrer la nouvelle Adresse >>");
                    etud.setAdresseEtudiant(sc.nextLine());
                    break;
                case "r": gestionEtudiant(); break;
                default: System.out.println("\t Oupss! Un erreur est survenue, Taper R pour sortire"); break;
            }
        }while (!choix.equals("r"));
    }
/* ********************************************FIN Etudiant******************************************** */
    //////////////////////////---------------------------------------------//////////////////////////
    
/* ********************************************Debut Professeur******************************************** */

    public void gestionProfesseur(){
        String choixprof = "r";
        do {
        	System.out.println("\n\n---------------------=*=*=*=*Gestion des Professeurs=*=*=*=*---------------------");
    		System.out.println("\n\t-1- Ajouter un Professeur");
    		System.out.println("\n\t-2- Suppimer un Professeur");
    		System.out.println("\n\t-3- Modifier un Professeur");
    		System.out.println("\n\t-4- Afficher les Professeur");
    		System.out.println("\n\t-R- Menu Principale ");
    		System.out.println("Entrer vortre choix");
            
    		choixprof=sc.nextLine();
            switch (choixprof){
                case "1":   ajouterProfesseur(); break;
                case "2":   supprimerProfesseur(); break;
                case "3":   modifierProf(); break;
                case "4":   afficherProfesseur(); break;
                case "r":   choixMenu(); break;
                default: System.out.println("\t Votre Choix Est Incorrect"); break;
            }
        }while (!choixprof.equals("r"));
    }    
    
    public void ajouterProfesseur(){
    	System.out.println("\n\n---------------------=*=*=*=*Ajouter un nouveau Professeur=*=*=*=*---------------------");
    	Professeur prof = new Professeur();
        prof.setId(id_Professeur);
        System.out.println("\t Nom  >> ");
        prof.setNomProf(sc.nextLine());
        System.out.println("\t Prenom  >> ");
        prof.setPrenomProf(sc.nextLine());
        System.out.println("\t Adresse >> ");
        prof.setAdresseProf(sc.nextLine());
        this.listProfesseur.add(prof);
        this.id_Professeur++;
        System.out.println("\t Etudiant "+prof.getNomProf()+" "+prof.getPrenomProf()+" ajouter avec succes ヾ(⌒Λ⌒)ノ");
    }
    
    public void supprimerProfesseur(){
    	System.out.println("\n\n---------------------=*=*=*=*Supprimer un Proffeseur=*=*=*=*---------------------");
    	Professeur prof = new Professeur();
        String choix ="0";
        prof = chercherProfById();
        System.out.println("\t Vous voulez Supprimer l'etudiant : "+prof.getNomProf()+" "+prof.getPrenomProf()+" ?");
        System.out.println("\t 1- Oui Exactement");
        if (sc.nextLine().equals("1")){
        	listProfesseur.remove(prof);
            System.out.println("\t La suppression est effectuer avec succes ");
            return;
        }else
            System.out.println("\t Non, Annuler");
    }
    
	//System.out.println("\n\n---------------------=*=*=*=*Chercher avec ID de Proffeseur=*=*=*=*---------------------");
    public Professeur chercherProfById(){
        int id=0;
        String choix;
    	Professeur professeur = new Professeur();

        do {
			System.out.println("\t 1- Afficher La liste des profs");
            System.out.println("\t 2- Taper l'ID de prof a modifier");
			System.out.println("\t-R- Menu Principale ");
			System.out.println("Entrer votre choix");
            choix = sc.nextLine();
            switch (choix){
                case "1": afficherProfesseur(); break;
                case "2":
                    System.out.println("\t Entrer l'ID de Profeseur SVP >> ");
                    id = sc.nextInt();
                    sc.nextLine();
                    for (Professeur prof:listProfesseur)
                        if (prof.getId() == id)
                            return prof;
                    System.out.println("\t Oups, Professeur introuvable! Veuillez Réssayer ༼ʘ̚ل͜ʘ̚༽");
                    break;
                case "r": gestionEtudiant(); break;
                default:
                    System.out.println("\t Choix Incorrect ! Veuillez Réssayer ༼ʘ̚ل͜ʘ̚༽");
                    break;
            }
        }while (!choix.equals("r"));
        return professeur;
    }
    
    public void afficherProfesseur(){
    	System.out.println("\n\n---------------------=*=*=*=*Liste des Etudiant=*=*=*=*---------------------");
        if (listProfesseur.size() == 0)
            System.out.println("\t Aucun Prof est enregistrer. ◉_◉");
        else{
             System.out.println("|  ID |\t\t Nom \t\t|\t\t Prenom \t\t|\t\t Adresse \t\t\n|");
             for (Professeur prof:listProfesseur){
            	 afficherCeProf(prof);
            }
        }
        System.out.println("\n\t Appuyez Taper sur Entrer pour continuer.");
        sc.nextLine();
    }
    
    public void afficherCeProf(Professeur prof){
        System.out.printf("%8d   ",prof.getId());
        System.out.printf("|%25s   ",prof.getNomProf());
        System.out.printf("|%25s   ",prof.getPrenomProf());
        System.out.printf("|%35s  ",prof.getAdresseProf());
        System.out.printf("\n\n");
    }
    
    public void modifierProf(){
    	System.out.println("\n\n---------------------=*=*=*=*Modifier Les détails d'un proffeseur=*=*=*=*---------------------");
        String choix;
    	Professeur prof = new Professeur();
        prof = chercherProfById();
        System.out.println("\t Choisir le champ que vous voulez modifier de : "+prof.getNomProf()+" "+prof.getPrenomProf());
        do {
            System.out.println("\t 1- Nom ("+prof.getNomProf()+")");
            System.out.println("\t 2- Prenom ("+prof.getPrenomProf()+")");
            System.out.println("\t 3- Adresse ("+prof.getAdresseProf()+")");
            System.out.println("\t r- Retour au Menu Principale");
            
            choix = sc.nextLine();
            switch (choix) {
                case "1":
                    System.out.println("\t Entrer le nouveau Nom >>");
                    prof.setNomProf(sc.nextLine());
                    break;
                case "2":
                    System.out.println("\t Entrer le nouveau Prenom >>");
                    prof.setPrenomProf(sc.nextLine());
                    break;
                case "3":
                    System.out.println("\t Entrer la nouvelle Adresse >>");
                    prof.setAdresseProf(sc.nextLine());
                    break;
                case "r": gestionProfesseur(); break;
                default: System.out.println("\t Oupss! Un erreur est survenue, Taper R pour sortire"); break;
            }
        }while (!choix.equals("r"));
    }
/* ********************************************FIN Prof******************************************** */

//////////////////////////---------------------------------------------//////////////////////////
    
/* ********************************************Debut Machines******************************************** */
    public void gestionMachines(){
        String choixmachines = "r";
        do {
        	System.out.println("\n\n---------------------=*=*=*=*Gestion des Machines=*=*=*=*---------------------");
    		System.out.println("\n\t-1- Ajouter une machine");
    		System.out.println("\n\t-2- Suppimer une machine");
    		System.out.println("\n\t-3- Modifier une machine");
    		System.out.println("\n\t-4- Afficher les machines");
    		System.out.println("\n\t-R- Menu Principale ");
    		System.out.println("Entrer votre choix");
            
    		choixmachines=sc.nextLine();
            switch (choixmachines){
                case "1":   ajouterMachine(); break;
                case "2":   supprimerMachine(); break;
                case "3":   modifierMachine(); break;
                case "4":   afficherMachines(); break;
                case "r":   choixMenu(); break;
                default: System.out.println("\t Votre Choix Est Incorrect"); break;
            }
        }while (!choixmachines.equals("r"));
    }    
    
    public void ajouterMachine(){
    	System.out.println("\n\n---------------------=*=*=*=*Ajouter un nouveau Professeur=*=*=*=*---------------------");
    	Machine machine = new Machine();
    	machine.setId(id_Machine);
        System.out.println("\t Marque  >> ");
        machine.setMarque(sc.nextLine());
        System.out.println("\t Processeur  >> ");
        machine.setProcesseur(sc.nextLine());
        System.out.println("\t Couleur >> ");
        machine.setCouleur(sc.nextLine());
        this.listMachines.add(machine);
        this.id_Machine++;
        System.out.println("\t La Machine "+machine.getMarque()+"est ajouter avec succes ヾ(⌒Λ⌒)ノ");
    }
    
    public void supprimerMachine(){
    	System.out.println("\n\n---------------------=*=*=*=*Supprimer une Machine=*=*=*=*---------------------");
    	Machine machine = new Machine();
        String choix ="0";
        machine = chercherMachineById();
        System.out.println("\t Vous voulez Supprimer la Machine : "+machine.getMarque()+" ?");
        System.out.println("\t 1- Oui Exactement");
        if (sc.nextLine().equals("1")){
        	listMachines.remove(machine);
            System.out.println("\t La suppression est effectuer avec succes (^̮^)");
            return;
        }else
            System.out.println("\t Non, Annuler");
    }
    
  //System.out.println("\n\n---------------------=*=*=*=*Chercher avec ID de Machine=*=*=*=*---------------------");
    public Machine chercherMachineById(){
        int id=0;
        String choix;
    	Machine machines = new Machine();
        do {
			System.out.println("\t 1- Afficher La liste des Machines");
            System.out.println("\t 2- Taper l'ID de Machine a modifier");
			System.out.println("\t-R- Menu Principale ");
			System.out.println("Entrer votre choix");
            choix = sc.nextLine();
            switch (choix){
                case "1": afficherMachines(); break;
                case "2":
                    System.out.println("\t Entrer l'ID de Machine SVP >> ");
                    id = sc.nextInt();
                    sc.nextLine();
                    for (Machine machine:listMachines)
                        if (machine.getId() == id)
                            return machine;
                    System.out.println("\t Oups, Machine introuvable! Veuillez Réssayer ༼ʘ̚ل͜ʘ̚༽");
                    break;
                case "r": gestionMachines(); break;
                default:
                    System.out.println("\t Choix Incorrect ! Veuillez Réssayer ༼ʘ̚ل͜ʘ̚༽");
                    break;
            }
        }while (!choix.equals("r"));
        return machines;
    }
    
    public void afficherMachines(){
    	System.out.println("\n\n---------------------=*=*=*=*Liste des Machines=*=*=*=*---------------------");
        if (listMachines.size() == 0)
            System.out.println("\t Aucune Machine est enregistrer. ◉_◉");
        else{
             System.out.println("|  ID |\t\t Marque \t\t|\t\t Processeur \t\t|\t\t Couleur \t\t\n|");
             for (Machine machine:listMachines){
            	 afficherCeMachine(machine);
            }
        }
        System.out.println("\n\t Appuyez Taper sur Entrer pour continuer.");
        sc.nextLine();
    }
    
    public void afficherCeMachine(Machine machine){
        System.out.printf("%8d   ",machine.getId());
        System.out.printf("|%25s   ",machine.getMarque());
        System.out.printf("|%25s   ",machine.getProcesseur());
        System.out.printf("|%35s  ",machine.getCouleur());
        System.out.printf("\n\n");
    }
    
    public void modifierMachine(){
    	System.out.println("\n\n---------------------=*=*=*=*Modifier Les détails d'une Machine=*=*=*=*---------------------");
        String choix;
    	Machine machine = new Machine();
    	machine = chercherMachineById();
        System.out.println("\t Choisir le champ que vous voulez modifier de : "+machine.getMarque());
        do {
            System.out.println("\t 1- Marque ("+machine.getMarque()+")");
            System.out.println("\t 2- Processeur ("+machine.getProcesseur()+")");
            System.out.println("\t 3- Couleur ("+machine.getCouleur()+")");
            System.out.println("\t r- Retour au Menu Principale");
            
            choix = sc.nextLine();
            switch (choix) {
                case "1":
                    System.out.println("\t Nouvelle Marque >>");
                    machine.setMarque(sc.nextLine());
                    break;
                case "2":
                    System.out.println("\t Nouveau Processeur >>");
                    machine.setProcesseur(sc.nextLine());
                    break;
                case "3":
                    System.out.println("\t Entrer la Couleur desirer >>");
                    machine.setCouleur(sc.nextLine());
                    break;
                case "r": gestionMachines(); break;
                default: System.out.println("\t Oupss! Un erreur est survenue, Taper R pour sortire"); break;
            }
        }while (!choix.equals("r"));
    }
/* ********************************************FIN Machines******************************************** */

//////////////////////////---------------------------------------------//////////////////////////
    
/* ********************************************Debut Fourniture******************************************** */
	public void gestionFourniture(){
	String choixFourniture = "r";
	do {
		System.out.println("\n\n---------------------=*=*=*=*Gestion des Fourniture=*=*=*=*---------------------");
		System.out.println("\n\t-1- Ajouter un Fourniture");
		System.out.println("\n\t-2- Suppimer un Fourniture");
		System.out.println("\n\t-3- Modifier un Fourniture");
		System.out.println("\n\t-4- Afficher les Fournitures");
		System.out.println("\n\t-R- Menu Principale ");
		System.out.println("Entrer votre choix");
		
		choixFourniture=sc.nextLine();
		switch (choixFourniture){
			case "1":   ajouterFourniture(); break;
			case "2":   supprimerFourniture(); break;
			case "3":   modifierFourniture(); break;
			case "4":   afficherFourniture(); break;
			case "r":   choixMenu(); break;
			default: System.out.println("\t Votre Choix Est Incorrect"); break;
		}
	}while (!choixFourniture.equals("r"));
	}   
    
    public void ajouterFourniture(){
    	System.out.println("\n\n---------------------=*=*=*=*Ajouter un nouveau Fourniture=*=*=*=*---------------------");
    	Fourniture fourniture = new Fourniture();
        System.out.println("\t Nb des portes  >> ");
        fourniture.setPorte(sc.nextInt());
        System.out.println("\t Nb des chaises  >> ");
        fourniture.setChaise(sc.nextInt());
        System.out.println("\t Nb des fenetres >> ");
        fourniture.setFenetre(sc.nextInt());
        System.out.println("\t Nb des dataShow >> ");
        fourniture.setDataShow(sc.nextInt());
        this.listFourniture.add(fourniture);
        System.out.println("\t Les Fournitures est ajouter avec succes ヾ(⌒Λ⌒)ノ");
    }
    
    public void supprimerFourniture(){
    	System.out.println("\n\n---------------------=*=*=*=*Supprimer Fourniture=*=*=*=*---------------------");
    	Fourniture fourniture = new Fourniture();
        String choix ="0";
        System.out.println("\t Vous voulez Supprimer les fournitures : "+fourniture.getPorte()+" ?");
        System.out.println("\t 1- Oui Exactement");
        if (sc.nextLine().equals("1")){
        	listFourniture.remove(fourniture);
            System.out.println("\t La suppression est effectuer avec succes (^̮^)");
            return;
        }else
            System.out.println("\t Non, Annuler");
    }
    
    public void afficherFourniture(){
    	System.out.println("\n\n---------------------=*=*=*=*Liste les Fournitures=*=*=*=*---------------------");
        if (listFourniture.size() == 0)
            System.out.println("\t Aucun Fourniture est enregistrer. ◉_◉");
        else{
             System.out.println("|  Nb des portes |\t\t Nb des chaise \t\t|\t\t Nb des fenetre \t\t|\t\t Nb des dataShow \t\t\n|");
             for (Fourniture fourniture:listFourniture){
            	 afficherCeFourniture(fourniture);
            }
        }
        System.out.println("\n\t Appuyez Taper sur Entrer pour continuer.");
        sc.nextLine();
    }
    
    public void afficherCeFourniture(Fourniture fourniture){
        System.out.printf("%8d   ",fourniture.getPorte());
        System.out.printf("|%8d   ",fourniture.getChaise());
        System.out.printf("|%8d   ",fourniture.getFenetre());
        System.out.printf("|%8d ",fourniture.getDataShow());
        System.out.printf("\n\n");
    }
    
    public void modifierFourniture(){
    	System.out.println("\n\n---------------------=*=*=*=*Modifier Les détails d'un Fourniture=*=*=*=*---------------------");
        String choix;
        Fourniture fourniture = new Fourniture();
        System.out.println("\t Choisir le champ que vous voulez modifier : ");
        do {
            System.out.println("\t 1- Nb des portes ("+fourniture.getPorte()+")");
            System.out.println("\t 2- Nb des Fenetre ("+fourniture.getChaise()+")");
            System.out.println("\t 3- Nb des chaises ("+fourniture.getFenetre()+")");
            System.out.println("\t 4- Nb des Datashow ("+fourniture.getDataShow()+")");
            System.out.println("\t r- Retour au Menu Principale");
            
            choix = sc.nextLine();
            switch (choix) {
                case "1":
                    System.out.println("\t Nouveau Nb des portes >>");
                    fourniture.setPorte(sc.nextInt());
                    break;
                case "2":
                    System.out.println("\t Nouveau Nb des chaises >>");
                    fourniture.setChaise(sc.nextInt());
                    break;
                case "3":
                    System.out.println("\t Nouveau Nb des Fenetres >>");
                    fourniture.setFenetre(sc.nextInt());
                    break;
                case "4":
                    System.out.println("\t Nouveau Nb des dataShow >>");
                    fourniture.setDataShow(sc.nextInt());
                    break;
                case "r": gestionFourniture(); break;
                default: System.out.println("\t Oupss! Un erreur est survenue, Taper R pour sortire"); break;
            }
        }while (!choix.equals("r"));
    }
/* ********************************************FIN Fournitures******************************************** */

}
