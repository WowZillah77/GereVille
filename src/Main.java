import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;


public class Main {
    public static HashMap<String, ArrayList<Ville>> listePays = new HashMap<String, ArrayList<Ville>>();
    public static boolean loop = true;
    private static List<Ville> listeVilles = new ArrayList<Ville>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        do {
            System.out.println("Bienvenue sur GèreVille");
            System.out.println("Que souhaitez vous faire?");
            System.out.println("1. Creation de listeVilles et capitales");
            System.out.println("2. Liste des listeVilles  et capitales des pays");
            System.out.println("3. Capitale et listeVilles d'un Pays");
            System.out.println("4. Liste des Pays");
            System.out.println("5. Fin");
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
            } else if (choix == 5) {
                loop = false;
            } else {

                System.out.println("choix:");
                choix = scanner.nextInt();
            }

        } while (loop);
    }

    public static void saisie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pays:");
        String pays = scanner.nextLine().toUpperCase();
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
            Capitale capitale = new Capitale(nom, pays, habitants, president);
            System.out.println("capitale créée");
            listeVilles.add(capitale);
            hashMap(pays, capitale);
        } else if (choice.charAt(0) == 'n') {
            Ville ville = new Ville(nom, pays, habitants);
            listeVilles.add(ville);
            System.out.println("Ville créée");
            hashMap(pays, ville);
        } else {
            System.out.println("Est-ce une capital?");
            choice = scanner.nextLine().toLowerCase();
        }


    }

    public static void listeVilles() {
        for (Ville ville : listeVilles) {
            ville.affDesc();
        }
    }


    public static void hashMap(String pays, Ville ville) {
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
        String choix = scanner.nextLine().toUpperCase();
        System.out.println(choix);

        listePays.forEach((k,v)->{
            if (k.equals(choix) ) {

                for (Ville ville : v) {
                    ville.affDesc();
                }
            }
        });


    }

    public static void listePays(){
        listePays.forEach((k,v)->{

                for (Ville ville : v) {
                    System.out.println(ville.getPays());
                }

        });
    }
}



