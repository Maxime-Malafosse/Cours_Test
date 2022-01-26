package Utilities;

import Restaurant.Commande;
import Restaurant.Serveur;

public class CommandeBuilder {

    public static Commande stub = new CommandeBuilder().build();

    public CommandeBuilder AyantXNourritureAvecXPrix(int nbNourriture, int prix){
        for (int i = 0; i < nbNourriture; i++) {

        }
        return new CommandeBuilder();
    }

    public Commande build(){
        return new Commande();
    }
}
