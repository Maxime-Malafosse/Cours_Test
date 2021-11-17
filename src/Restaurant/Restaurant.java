package Restaurant;

import java.util.ArrayList;

public class Restaurant {
    ArrayList<Serveur> ListServeurs;

    public Restaurant(ArrayList<Serveur> serveurs) {
        ListServeurs = serveurs;
    }
    public double chiffreAffaires(){
        double sum = 0;
        for(Serveur s: ListServeurs){
            sum += s.getChiffreAffaires();
        }
        return sum;
    }

}
