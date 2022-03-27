package Restaurant;

import java.util.ArrayList;

public class Commande {
    private ArrayList<Nourriture> ListNourriture;
    private ArrayList<Boisson> ListBoissons;
    private int declare;
    //0 = rien 1 = non-payée 2 = payée
    private int jours;
    private boolean aTransmettre;

    public void setDeclare(int declare) {
        this.declare = declare;
    }

    public Commande() {
        ListNourriture = new ArrayList<>();
        ListBoissons = new ArrayList<>();
        declare = 0;
        jours = 0;
        aTransmettre = false;
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

    public boolean isaTransmettre() {
        return aTransmettre;
    }

    public void setJours(int jour){
        jours = jour;
        if(jour >= 15 && declare == 1){
            aTransmettre = true;
        }
        else{
            aTransmettre = false;
        }
    }

    public int getDeclare() {
        return declare;
    }

    public int getJours() {
        return jours;
    }

    public void declareNonPayee(){
        declare = 1;
        if(jours >= 15){
            aTransmettre = true;
        }
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
