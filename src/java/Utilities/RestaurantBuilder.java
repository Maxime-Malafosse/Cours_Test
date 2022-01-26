package Utilities;

import Restaurant.*;

import java.util.ArrayList;

public class RestaurantBuilder {

    private ArrayList<Serveur> listServeur= new ArrayList<>();
    public static Restaurant Stub = new RestaurantBuilder().build();

    public RestaurantBuilder ayantXServeurs(int nombreServeurs){
        ArrayList<Serveur> s = new ArrayList<Serveur>();
        for (int i = 0; i < nombreServeurs ; i++) {
            listServeur.add(new ServeurBuilder().build());
        }
        return this;
    }

    public Restaurant build(){
        return new Restaurant(listServeur,listServeur.size());
    }
}
