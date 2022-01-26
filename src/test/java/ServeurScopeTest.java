import Restaurant.Serveur;
import Utilities.FranchiseBuilder;
import Utilities.RestaurantBuilder;
import Utilities.ServeurBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ServeurScopeTest {
    @Test
    public void Restaurant_Avec_0_Serveur() {
        //Etant donné un restaurant avec 2 serveurs
        Serveur s = new ServeurBuilder().build();

        assertEquals(0, s.getChiffreAffaires(),0);
    }

}
