package Restaurant;

public class Table {
    int id;
    Serveur affectation;

    public Table(int id, Serveur affectation) {
        this.id = id;
        this.affectation = affectation;
    }

    public int getId() {
        return id;
    }

    public void setAffectation(Serveur affectation) {
        this.affectation = affectation;
    }

    public Serveur getAffectation() {
        return affectation;
    }
}
