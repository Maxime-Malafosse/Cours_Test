package Restaurant;

import java.util.ArrayList;

public class Franchise {
    ArrayList<Restaurant> ListRestau;

    public Franchise(ArrayList<Restaurant> listRestau) {
        this.ListRestau = listRestau;
    }

    public double chiffreAffaires(){
        double sum = 0;
        for(Restaurant r: ListRestau){
            sum += r.chiffreAffaires();
        }
        return sum;
    }

    public ArrayList<Restaurant> getListRestau() {
        return ListRestau;
    }
}
