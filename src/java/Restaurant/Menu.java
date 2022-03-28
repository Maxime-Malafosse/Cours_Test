package Restaurant;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Plat> plats;

    public Menu() {
        plats = new ArrayList<Plat>();
    }

    public Menu(ArrayList<Plat> plats) {
        this.plats = plats;
    }

    public void ajoutPlat(Plat p){
        plats.add(p);
    }
    public void removePlat(Plat p){
        plats.remove(p);
    }

    public ArrayList<Plat> getPlats() {
        return plats;
    }

    public int getPrix(){
        int prix = 0;
        for(Plat e : plats){
            prix += e.getPrix();
        }
       return prix;
    }
}
