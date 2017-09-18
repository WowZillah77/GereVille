public class Ville {

    private String nom, pays;
    private int nbHabitants;
    private char categorie='?';

    public Ville(String nom, String pays, int nbHabitants) {
        this.nom = nom;
        this.pays = pays;
        this.nbHabitants = nbHabitants;
        this.categorie=categories(nbHabitants);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getNbHabitants() {


        return nbHabitants;
    }

    public void setNbHabitants(int nbHabitants) {


        this.nbHabitants = nbHabitants;

    }

    private char categories(int nbHabitants){

        if(nbHabitants>0 && nbHabitants<50000){
            return 'A';
        }else if(nbHabitants>=50000 && nbHabitants<200000){
            return 'B';
        }else if(nbHabitants>=200000 && nbHabitants<1000000){
            return 'C';
        }else if(nbHabitants>=1000000){
            return 'D';
        }
        return '?';
        }

    public char getCategorie() {
        return categorie;
    }

    public void affDesc(){
            System.out.println(this.getNom()+ " est une ville de "+this.getPays() +" de catégorie "+ this.getCategorie()+"("+this.getNbHabitants()+")");


        }
    }

