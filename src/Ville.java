import java.io.Serializable;

public class Ville implements Serializable{

    private static final long serialVersionUID=1L;
    private String nom;
    private Pays pays;
    private int nbHabitants;
    private String categorie="?";
    private int id;



    public Ville(int id, String nom, Pays pays, int nbHabitants) {
        this.nom = nom;
        this.pays = pays;
        this.nbHabitants = nbHabitants;
        this.categorie=categories(nbHabitants);
        this.id=id;

    }
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public int getNbHabitants() {


        return nbHabitants;
    }

    public void setNbHabitants(int nbHabitants) {


        this.nbHabitants = nbHabitants;

    }

    private String categories(int nbHabitants){

        if(nbHabitants>0 && nbHabitants<50000){
            return "A";
        }else if(nbHabitants>=50000 && nbHabitants<200000){
            return "B";
        }else if(nbHabitants>=200000 && nbHabitants<1000000){
            return "C";
        }else if(nbHabitants>=1000000){
            return "D";
        }
        return "?";
        }

    public String getCategorie() {
        return categorie;
    }

    public void affDesc(){
            System.out.println(this.getNom()+ " est une ville de "+this.getPays().getNom() +" de catégorie "+ this.getCategorie()+"("+this.getNbHabitants()+")");


        }
    }

