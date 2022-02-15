package Restaurant;

import java.util.ArrayList;

public class Commande {
    private ArrayList<Nourriture> ListNourriture;
    private ArrayList<Boisson> ListBoissons;

    public Commande() {
        ListNourriture = new ArrayList<>();
        ListBoissons = new ArrayList<>();
    }

   public void addNourriture(Nourriture n){
        ListNourriture.add(n);
   }

   public void addBoisson(Boisson b){
        ListBoissons.add(b);
   }

    public ArrayList<Nourriture> getListNourriture() {
        return ListNourriture;
    }

    public ArrayList<Boisson> getListBoissons() {
        return ListBoissons;
    }

    public int getPrixCommande(){
        int montant = 0;
        for(Nourriture n : ListNourriture ){
            montant += n.prix;
        }
        for(Boisson s : ListBoissons){
            montant += s.prix;
        }
        return montant;
    }
}
