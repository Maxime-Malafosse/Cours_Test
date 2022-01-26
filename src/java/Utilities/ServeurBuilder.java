package Utilities;

import Restaurant.*;

import java.util.ArrayList;

public class ServeurBuilder {

    public static Serveur stub = new ServeurBuilder().build();
    private ArrayList<Commande> listCommande= new ArrayList<>();

    public ServeurBuilder AyantXCommandeAyantXNourritureAyantXprix(int nbCommande,int nbNourriture, int prix){
        for (int i = 0; i < nbCommande; i++) {
            listCommande.add(new CommandeBuilder().AyantXNourritureAvecXPrix(nbNourriture,prix).build());
        }
        return this;
    }
    public ServeurBuilder AyantXCommandeAyantXBoissonAyantXprix(int nbCommande,int nbBoisson, int prix){
        for (int i = 0; i < nbCommande; i++) {
            listCommande.add(new CommandeBuilder().AyantXBoissonAvecXPrix(nbBoisson,prix).build());
        }
        return this;
    }

    public Serveur build(){
        if(listCommande.size() == 0){
            return new Serveur();
        }
        else{
            return new Serveur(listCommande);
        }

    }
}
