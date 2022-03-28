package Restaurant;

import java.util.ArrayList;

public class Franchise {
    private ArrayList<Restaurant> listRestau;
    private Menu menu;

    public Franchise(ArrayList<Restaurant> listRestau) {
        this.listRestau = listRestau;
        menu = new Menu();
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ArrayList<Restaurant> getListRestau() {
        return listRestau;
    }

    public void addRestaurant(Restaurant r){
        listRestau.add(r);
        for(Plat p : menu.getPlats()){
            r.ajoutPlat(p);
        }
    }

    public void changePrixPlat(Plat p, int prix){
        if(menu.getPlats().contains(p)){
            for(Restaurant r : listRestau){
                if( !(r.isStatutFiliale())){
                    Plat p2 = new Plat(p.prix);
                    r.removePlat(p);
                    r.ajoutPlat(p2);
                }
            }
            p.prix = prix;
        }
        else{
            System.out.println("Le plat n'existe pas");
        }
    }


    public double chiffreAffaires(){
        double sum = 0;
        for(Restaurant r: listRestau){
            sum += r.chiffreAffaires();
        }
        return sum;
    }
    public void ajoutPlat(Plat p){
        menu.ajoutPlat(p);
        for(Restaurant r:listRestau){
            if ( !r.getMenu().getPlats().contains(p)){
                r.ajoutPlat(p);
            }
        }
    }
}
