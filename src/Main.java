import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static HashMap<Integer, ArrayList<Ville>> listePays = new HashMap<Integer, ArrayList<Ville>>();
    public static boolean loop = true;
    private static ArrayList<Ville> listeVilles = new ArrayList<Ville>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        do {
            System.out.println("Bienvenue sur GèreVille");
            System.out.println("Que souhaitez vous faire?");
            System.out.println("1. Creation de listeVilles et capitales");
            System.out.println("2. Liste des listeVilles  et capitales des pays");
            System.out.println("3. Capitale et listeVilles d'un Pays");
            System.out.println("4. Liste des Pays");
            System.out.println("5. Sauvegarde Liste Villes");
            System.out.println("6. Restauration listes Villes et Pays");
            System.out.println("7. Fin");
            System.out.println("choix:");
            int choix = scanner.nextInt();
            if (choix == 1) {
                saisie();
            } else if (choix == 2) {
                listeVilles();
            } else if (choix == 3) {
                listeVillePays();
            } else if (choix == 4) {
                listePays();
            } else if(choix ==5) {
                Fichier.ecrire(listeVilles);
            }else if(choix ==6){
                 listeVilles=Fichier.lire();
                System.out.println("fichier restauré");
            }
            else if (choix == 7) {
                loop = false;
            } else {

                System.out.println("choix:");
                choix = scanner.nextInt();
            }

        } while (loop);
    }

    public static void saisie() {
        Scanner scanner = new Scanner(System.in);
        /*System.out.println("Pays:");
        String pays = scanner.nextLine().toUpperCase();*/
        Pays France = new Pays(1,"FRANCE",0);
        System.out.println("Nom de la ville");
        String nom = scanner.nextLine();
        System.out.println("nombre d'habitants:");
        String temp = scanner.nextLine();
        int habitants = Integer.parseInt(temp);
        System.out.println("Est-ce une capital?(y/n)");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.charAt(0) == 'y') {
            System.out.println("Nom du président:");
            String president = scanner.nextLine();
            Capitale capitale = new Capitale(0,nom, France, habitants, president);
            System.out.println("capitale créée");
            listeVilles.add(capitale);
            hashMap(France.getId(), capitale);
        } else if (choice.charAt(0) == 'n') {
            Ville ville = new Ville(0,nom, France, habitants);
            listeVilles.add(ville);
            System.out.println("Ville créée");
            hashMap(France.getId(), ville);
        } else {
            System.out.println("Est-ce une capital?");
            choice = scanner.nextLine().toLowerCase();
        }


    }

    public static void listeVilles() {

        ArrayList<Ville> resultat =DBConnect.findAllVilles();
        for (Ville ville : resultat) {
            ville.affDesc();
        }

    }


    public static void hashMap(int pays, Ville ville) {
        ArrayList villes = listePays.get(pays);
        if (villes == null) {
            villes = new ArrayList();

            listePays.put(pays, villes);

        }
        villes.add(ville);

    }

    public static void listeVillePays() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel pays?:");
        listePays();
        int choix = scanner.nextInt();
        ArrayList<Ville> resultat =DBConnect.villesFromOnePays(choix);
        for (Ville ville : resultat) {
            ville.affDesc();
        }




    }

    public static void listePays(){
        ArrayList<Pays> result = DBConnect.findAllPays();
        for (Pays pays : result) {
            pays.affDesc();
        }
    }
}



