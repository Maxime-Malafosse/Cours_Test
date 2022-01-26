package Utilities;

import Restaurant.Boisson;
import Restaurant.Commande;
import Restaurant.Nourriture;
import Restaurant.Serveur;

import java.util.ArrayList;

public class CommandeBuilder {

    public static Commande stub = new CommandeBuilder().build();
    private ArrayList<Boisson> listBoissons= new ArrayList<>();
    private ArrayList<Nourriture> listNourritures= new ArrayList<>();

    public CommandeBuilder AyantXNourritureAvecXPrix(int nbNourriture, int prix){
        for (int i = 0; i < nbNourriture; i++) {
            listNourritures.add(new Nourriture(prix));
        }
        return this;
    }

    public CommandeBuilder AyantXBoissonAvecXPrix(int nbBoisson, int prix){
        for (int i = 0; i < nbBoisson; i++) {
            listBoissons.add(new Boisson(prix));
        }
        return this;
    }

    public Commande build(){
        Commande c = new Commande();
        for (Nourriture n : listNourritures){
            c.addNourriture(n);
        }
        for(Boisson b : listBoissons){
            c.addBoisson(b);
        }
        return c;
    }
}
