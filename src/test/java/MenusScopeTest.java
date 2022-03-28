import Restaurant.Franchise;
import Restaurant.Restaurant;
import Restaurant.Plat;
import Utilities.FranchiseBuilder;
import Utilities.RestaurantBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenusScopeTest {

    //ÉTANT DONNE un restaurant ayant le statut de filiale d'une franchise
    //ET une franchise définissant un menu ayant un plat
    //QUAND la franchise modifie le prix du plat
    //ALORS le prix du plat dans le menu du restaurant est celui défini par la franchise
    @Test
    public void Franchise_Change_Prix_Menu_Filliale() {
        Franchise f = new FranchiseBuilder().build();
        Restaurant r = new RestaurantBuilder().build();
        r.setStatutFilialeToTrue();

        f.addRestaurant(r);
        f.ajoutPlat(new Plat(5));
        f.changePrixPlat(f.getMenu().getPlats().get(0),2);

        assertEquals(f.getMenu().getPrix(),r.getMenu().getPrix(),0);

    }

    //ÉTANT DONNE un restaurant appartenant à une franchise et définissant un menu ayant un plat
    //ET une franchise définissant un menu ayant le même plat
    //QUAND la franchise modifie le prix du plat
    //ALORS le prix du plat dans le menu du restaurant reste inchangé
    @Test
    public void Franchise_Change_Prix_Menu_Non_Filliale() {
        Franchise f = new FranchiseBuilder().build();
        Restaurant r = new RestaurantBuilder().build();

        f.addRestaurant(r);
        f.ajoutPlat(new Plat(5));
        f.changePrixPlat(f.getMenu().getPlats().get(0),2);

        assertEquals(r.getMenu().getPrix(),5,0);

    }

    //ÉTANT DONNE un restaurant appartenant à une franchise et définissant un menu ayant un plat
    //QUAND la franchise ajoute un nouveau plat
    //ALORS la carte du restaurant propose le premier plat au prix du restaurant et le second au prix de la franchise
    @Test
    public void Restaurant_Deux_Plats() {
        Franchise f = new FranchiseBuilder().build();
        Restaurant r = new RestaurantBuilder().build();
        r.ajoutPlat(new Plat(9));
        f.addRestaurant(r);
        f.ajoutPlat(new Plat(5));

        assertEquals(r.getMenu().getPrix(),14,0);

    }
}
