import java.io.Serializable;

public class Capitale extends Ville implements Serializable {
    private static final long serialVersionUID=1L;
    private String president;

    public Capitale(String nom, String pays, int nbHabitants, String president) {
        super(nom, pays, nbHabitants);
        this.president = president;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public void affDesc(){
        System.out.println(this.getNom() +" est la capital de la "+ this.getPays() +"("+this.getNbHabitants()+" habitants) présidé par "+ this.getPresident());

    }
}
