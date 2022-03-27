package Restaurant;

import java.util.ArrayList;

public class Epinglage {
    private ArrayList<Commande> Commandes;


    public Epinglage() {
        Commandes = new ArrayList<Commande>();
    }

    public ArrayList<Commande> getCommandes() {
        return Commandes;
    }

    public void ajoutCommande(Commande c){
        Commandes.add(c);
    }
}
