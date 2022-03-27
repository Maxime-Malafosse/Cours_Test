import Restaurant.Restaurant;
import Restaurant.Serveur;
import Utilities.CommandeBuilder;
import Utilities.RestaurantBuilder;
import Utilities.ServeurBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandeScopeTest {

   // ÉTANT DONNE un serveur dans un restaurant
   // QUAND il prend une commande de nourriture
   // ALORS cette commande apparaît dans la liste de tâches de la cuisine de ce restaurant

    @Test
    public void Serveur_Passe_Commande_Nourriture(){
        // ÉTANT DONNE un serveur dans un restaurant
        Restaurant r = new RestaurantBuilder().build();
        Serveur s = new ServeurBuilder().build();
        r.ajoutServeur(s);
        // QUAND il prend une commande de nourriture
        r.prendreCommande(new CommandeBuilder().AyantXNourritureAvecXPrix(10,12).build(),r.getListServeurs().get(0));
        // ALORS cette commande apparaît dans la liste de tâches de la cuisine de ce restaurant
        assertEquals(10, r.getCuisine().getTache().size() ,0);

    }

    //ÉTANT DONNE un serveur dans un restaurant
    //QUAND il prend une commande de boissons
    //ALORS cette commande n'apparaît pas dans la liste de tâches de la cuisine de ce restaurant

    @Test
    public void Serveur_Passe_Commande_Boisson(){
        //ÉTANT DONNE un serveur dans un restaurant
        Restaurant r = new RestaurantBuilder().build();
        Serveur s = new ServeurBuilder().build();
        r.ajoutServeur(s);
        //QUAND il prend une commande de boissons
        r.prendreCommande(new CommandeBuilder().AyantXBoissonAvecXPrix(12,120).build(),r.getListServeurs().get(0));
        //ALORS cette commande n'apparaît pas dans la liste de tâches de la cuisine de ce restaurant
        assertEquals(0, r.getCuisine().getTache().size() ,0);

    }

    //ÉTANT DONNE un serveur qui n'est pas présent dans un restaurant
    //QUAND il prend une commande de nourriture
    //ALORS cette commande n'apparaît pas dans la liste de tâches de la cuisine de ce restaurant

    @Test
    public void Serveur_Passe_Commande_Nourriture_Pas_Present_Dans_Restaurant(){
        //ÉTANT DONNE un serveur qui n'est pas présent dans un restaurant
        Restaurant r = new RestaurantBuilder().build();
        Serveur s = new ServeurBuilder().build();
        r.ajoutServeur(s);
        //QUAND il prend une commande de nourriture
        r.prendreCommande(new CommandeBuilder().AyantXNourritureAvecXPrix(12,12).build(),new ServeurBuilder().build());
        //ALORS cette commande n'apparaît pas dans la liste de tâches de la cuisine de ce restaurant
        assertEquals(0, r.getCuisine().getTache().size() ,0);
    }
}
