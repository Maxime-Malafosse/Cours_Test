package Restaurant;

public class Table {
    private Serveur affectation;
    private Client client;

    public Table( Serveur affectation) {
        this.affectation = affectation;
    }

    public Table() {
        this.affectation = null;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean libereClient(){
        if(this.client == null){
            System.out.println("Il n'y a pas de client");
            return false;
        }
        else{
            this.client = null;
            return true;
        }
    }

    public void setAffectation(Serveur affectation) {
        this.affectation = affectation;
    }

    public Serveur getAffectation() {
        return affectation;
    }
}
