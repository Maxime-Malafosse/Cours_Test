package Utilities;

import Restaurant.*;

import java.util.ArrayList;

public class FranchiseBuilder {

    private ArrayList<Restaurant> listRestaurant = new ArrayList<Restaurant>();
    public static Franchise stub = new FranchiseBuilder().build();

    public FranchiseBuilder ayantXRestaurantXServeur(int restaurant,int serveur){
        for (int i = 0; i < restaurant ; i++) {
            Restaurant r = new RestaurantBuilder().ayantXServeurs(serveur).build();
            listRestaurant.add(r);
        }
        return this;
    }

    public FranchiseBuilder ayantXRestaurantList(ArrayList<Restaurant> r){
        listRestaurant = r  ;
        return this;
    }

    public Franchise build(){
        return new Franchise(listRestaurant);
    }
}
