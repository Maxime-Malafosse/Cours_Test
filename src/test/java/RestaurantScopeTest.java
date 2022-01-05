import Utilities.FranchiseBuilder;
import Utilities.RestaurantBuilder;
import org.junit.Test;
import Restaurant.*;
import static org.junit.Assert.assertEquals;

public class RestaurantScopeTest {
    @Test
    public void Restaurant_Avec_0_Serveur(){
        //Etant donné un restaurant avec 2 serveurs
        Restaurant r = new RestaurantBuilder().build();
        assertEquals(0, r.chiffreAffaires(),0);
    }

    @Test
    public void Restaurant_Avec_Un_Serveur(){
        //Etant donné un restaurant avec 2 serveurs
        Restaurant r = new RestaurantBuilder().ayantXServeurs(1).build();
        //Quand chacun prend une commande
        double montantCommande = 1.0;
        for(Serveur s : r.getListServeurs()){
            s.prendreCommande(montantCommande);
        }
        assertEquals(montantCommande, r.chiffreAffaires(),0);
    }

    @Test
    public void Restaurant_Avec_Deux_Serveur(){
        //Etant donné un restaurant avec 2 serveurs
        Restaurant r = new RestaurantBuilder().ayantXServeurs(2).build();
        //Quand chacun prend une commande
        double montantCommande = 1.0;
        for(Serveur s : r.getListServeurs()){
            s.prendreCommande(montantCommande);
        }
        assertEquals(montantCommande + montantCommande, r.chiffreAffaires(),0);
    }

    @Test
    public void Restaurant_Avec_Cent_Serveurs(){
        //Etant donné un restaurant avec 2 serveurs
        Restaurant r = new RestaurantBuilder().ayantXServeurs(100).build();
        //Quand chacun prend une commande
        double montantCommande = 1.0;
        for(Serveur s : r.getListServeurs()){
            s.prendreCommande(montantCommande);
        }
        assertEquals(100 * 1.0, r.chiffreAffaires(),0.1);
    }
}
