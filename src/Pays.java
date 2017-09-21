public class Pays {
    private int id;
    private String nom;
    private int capitalid;

    public Pays(int id, String nom, int capitalid) {
        this.id = id;
        this.nom = nom;
        this.capitalid = capitalid;
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

    public int getCapitalid() {
        return capitalid;
    }

    public void affDesc(){
        System.out.println(this.getId() +" / "+ this.getNom());

    }
}
