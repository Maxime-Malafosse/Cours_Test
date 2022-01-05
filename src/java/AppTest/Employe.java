package AppTest;

public class Employe {
    String nom;
    int argent;


    public Employe(String nom) {
        this.nom = nom;
        this.argent = 0;
    }

    public void ajoutSalaire(int a){
        argent += a;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setArgent(int argent) {
        this.argent = argent;
    }

    public int getArgent() {
        return argent;
    }
}
