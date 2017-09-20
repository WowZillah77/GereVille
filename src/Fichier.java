import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Fichier {


    public static void ecrire(ArrayList<Ville> villes ) {

        try {
            FileOutputStream file = new FileOutputStream("/home/david/Desktop/JAVAMASTERCLASS/GereVille/src/ville.txt");
            ObjectOutputStream ville = new ObjectOutputStream(file);
            ville.writeObject(villes);
            System.out.println("fichier enregistré");
            ville.close();
            System.out.println("fermeture");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<Ville> lire(){
        try{
            FileInputStream lire = new FileInputStream("/home/david/Desktop/JAVAMASTERCLASS/GereVille/src/ville.txt");
            ObjectInputStream villes = new ObjectInputStream(lire);
            ArrayList<Ville> listeVilles = (ArrayList<Ville>) villes.readObject();
            return listeVilles;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
