package Restaurant;

public class Table {
    private Serveur affectation;

    public Table( Serveur affectation) {
        this.affectation = affectation;
    }

    public Table() {
        this.affectation = null;
    }


    public void setAffectation(Serveur affectation) {
        this.affectation = affectation;
    }

    public Serveur getAffectation() {
        return affectation;
    }
}
