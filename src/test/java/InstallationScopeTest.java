import Restaurant.Restaurant;
import Restaurant.Client;
import Utilities.RestaurantBuilder;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InstallationScopeTest {
   // ÉTANT DONNE une table dans un restaurant ayant débuté son service
   // QUAND un client est affecté à une table
   // ALORS cette table n'est plus sur la liste des tables libres du restaurant
   @Test
   public void Client_Affecte_Table() {
       Restaurant r = new RestaurantBuilder().ayantXTable(10).build();
       r.debutService();
       r.affecteClientTable(new Client(),r.getListTable().get(0));

       assertFalse(r.getListTableLibre().contains(r.getListTable().get(0)));

   }

   // ÉTANT DONNE une table occupée par un client
   // QUAND la table est libérée
   // ALORS cette table appraît sur la liste des tables libres du restaurant
   @Test
   public void Client_Libere_Table() {
       Restaurant r = new RestaurantBuilder().ayantXTable(10).build();
       r.debutService();
       r.affecteClientTable(new Client(),r.getListTable().get(0));
       r.libereClientTable(r.getListTable().get(0));

       assertTrue(r.getListTableLibre().contains(r.getListTable().get(0)));

   }
}
