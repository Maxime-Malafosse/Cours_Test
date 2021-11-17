package Restaurant;

import java.util.ArrayList;

public class Restaurant {
    String name;
    ArrayList<Serveur> listServeurs;

    public Restaurant(ArrayList<Serveur> serveurs) {
        listServeurs = serveurs;
         name = "oo";
    }
    public double chiffreAffaires(){
        double sum = 0;
        for(Serveur s: listServeurs){
            sum += s.getChiffreAffaires();
        }
        return sum;
    }

}
