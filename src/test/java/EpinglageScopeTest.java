import Restaurant.Restaurant;
import Utilities.RestaurantBuilder;
import Utilities.ServeurBuilder;
import Restaurant.Serveur;
import org.junit.Test;

import static org.junit.Assert.*;

public class EpinglageScopeTest {

   // ÉTANT DONNE un serveur ayant pris une commande
   // QUAND il la déclare comme non-payée
  // ALORS cette commande est marquée comme épinglée
   @Test
   public void Commande_Declare_Non_Payee_Epinglage(){
       Restaurant r = new RestaurantBuilder().build();
       Serveur s = new ServeurBuilder().AyantXCommandeAyantXBoissonAyantXprix(1,1,1).build();
       r.ajoutServeur(s);
       r.commandeDeclareNonPayee(s,s.getListCommandes().get(0));

       assertTrue(r.getEpinglage().getCommandes().contains(s.getListCommandes().get(0)));
   }

   // ÉTANT DONNE un serveur ayant épinglé une commande
   // QUAND elle date d'il y a au moins 15 jours
    //ALORS cette commande est marquée comme à transmettre gendarmerie
   @Test
   public void Commande_Epingle_Transmettre_Gendarmerie(){
       Restaurant r = new RestaurantBuilder().build();
       Serveur s = new ServeurBuilder().AyantXCommandeAyantXBoissonAyantXprix(1,1,1).build();
       r.ajoutServeur(s);
       s.setJour(15,s.getListCommandes().get(0));
       r.commandeDeclareNonPayee(s,s.getListCommandes().get(0));

       assertTrue(s.getListCommandes().get(0).isaTransmettre());
   }
   // ÉTANT DONNE une commande à transmettre gendarmerie
    //QUAND on consulte la liste des commandes à transmettre du restaurant
    //ALORS elle y figure

    @Test
    public void Commande_Liste_Transmettre_Gendarmerie(){
        Restaurant r = new RestaurantBuilder().build();
        Serveur s = new ServeurBuilder().AyantXCommandeAyantXBoissonAyantXprix(1,1,1).build();
        s.setJour(15,s.getListCommandes().get(0));
        s.DeclareNonPayee(s.getListCommandes().get(0));
        r.ajoutServeur(s);

        assertTrue(r.getCommandeATransmettre().contains(s.getListCommandes().get(0)));
    }

    //ÉTANT DONNE une commande à transmettre gendarmerie
   // QUAND elle est marquée comme transmise à la gendarmerie
   // ALORS elle ne figure plus dans la liste des commandes à transmettre du restaurant
    @Test
    public void Commande_Non_Liste_Transmettre_Gendarmerie(){
        Restaurant r = new RestaurantBuilder().build();
        Serveur s = new ServeurBuilder().AyantXCommandeAyantXBoissonAyantXprix(1,1,1).build();
        s.setJour(15,s.getListCommandes().get(0));
        s.DeclareNonPayee(s.getListCommandes().get(0));
        r.ajoutServeur(s);
        r.commandeTransmiseGendarmerie(s,s.getListCommandes().get(0));

        assertFalse(r.getCommandeATransmettre().contains(s.getListCommandes().get(0)));
    }
}
