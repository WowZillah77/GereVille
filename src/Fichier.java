import java.io.*;
import java.util.ArrayList;

public class Fichier {


    public static void ecrire(ArrayList<Ville> villes ) {


        FileOutputStream file = null;
        try {
            file = new FileOutputStream("/home/david/Desktop/JAVAMASTERCLASS/GereVille/src/ville.txt");
            ObjectOutputStream ville = new ObjectOutputStream(file);
            ville.writeObject(villes);
            System.out.println("fichier enregistré");
            ville.close();
            System.out.println("fermeture");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }


    }

    public static ArrayList<Ville> lire(){
        try{
            FileInputStream lire = new FileInputStream("/home/david/Desktop/JAVAMASTERCLASS/GereVille/src/ville.txt");
            ObjectInputStream villes = new ObjectInputStream(lire);
            return (ArrayList<Ville>) villes.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
