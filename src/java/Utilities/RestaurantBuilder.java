package Utilities;

import Restaurant.*;

import java.util.ArrayList;

public class RestaurantBuilder {

    private ArrayList<Serveur> listServeur= new ArrayList<>();
    private int nbrTable = 0;
    public static Restaurant Stub = new RestaurantBuilder().build();

    public RestaurantBuilder ayantXServeurs(int nombreServeurs){
        ArrayList<Serveur> s = new ArrayList<Serveur>();
        for (int i = 0; i < nombreServeurs ; i++) {
            listServeur.add(new ServeurBuilder().build());
        }
        return this;
    }

    public RestaurantBuilder ayantXServeursXTable(int nombreServeurs,int nombreTable){
        ArrayList<Serveur> s = new ArrayList<Serveur>();
        for (int i = 0; i < nombreServeurs ; i++) {
            listServeur.add(new ServeurBuilder().build());
        }
        nbrTable = nombreTable;
        return this;
    }



    public RestaurantBuilder ayantXServeursdeXCommandesPourUnMontantDeX(int nombreServeurs, int commandes, int montant){
        ArrayList<Serveur> s = new ArrayList<Serveur>();
        for (int i = 0; i < nombreServeurs ; i++) {
            listServeur.add(new ServeurBuilder().AyantXCommandeAyantXBoissonAyantXprix(commandes, 1, montant).build());
        }
        return this;
    }

    public Restaurant build(){
        return new Restaurant(listServeur,nbrTable);
    }
}
