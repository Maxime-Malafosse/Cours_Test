package Test;
import org.junit.Test;
import Restaurant.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RestaurantTest {
    @Test
    public void Serveur_initial(){
        Serveur s = new Serveur();
        double chiffreAffaire = s.getChiffreAffaires();

        assertEquals(0,chiffreAffaire,0);
    }

    @Test
    public void Serveur_increment(){
        double montantCommande = 64.5;
        Serveur s = new Serveur();
        s.prendreCommande(montantCommande);
        assertEquals(montantCommande,s.getChiffreAffaires(),0);
    }

    @Test
    public void Serveur_2_commandes(){

      Serveur s = new Serveur();
      double montantPremiereCommande = 67.8;
      s.prendreCommande(montantPremiereCommande);

      double montantSecondeCommande = 178;
      s.prendreCommande(montantSecondeCommande);

      assertEquals(montantPremiereCommande + montantSecondeCommande,s.getChiffreAffaires(),0);

    }
    @Test
    public void Restaurant(){

        //Etant donné un restaurant avec 2 serveurs
        ArrayList<Serveur> listServeur= new ArrayList<>();
        listServeur.add(new Serveur());
        listServeur.add(new Serveur());
        Restaurant r = new Restaurant(listServeur);

        //Quand chacun prend une commande
        double montantCommande = 67.8;
        for(Serveur s : listServeur){
            s.prendreCommande(montantCommande);
        }

        assertEquals(montantCommande + montantCommande, r.chiffreAffaires(),0);
    }

    @Test
    public void Franchise(){
        ArrayList<Serveur> listServeur= new ArrayList<>();
        listServeur.add(new Serveur());
        listServeur.add(new Serveur());
        Restaurant r = new Restaurant(listServeur);

        ArrayList<Serveur> listServeur2= new ArrayList<>();
        listServeur2.add(new Serveur());
        listServeur2.add(new Serveur());
        Restaurant r2 = new Restaurant(listServeur2);

        ArrayList<Restaurant> listRestau = new ArrayList<>();
        listRestau.add(r);
        listRestau.add(r2);
        Franchise f =  new Franchise(listRestau);



        //Quand chacun prend une commande
        double montantCommande = 67.8;
        for(Serveur s : listServeur){
            s.prendreCommande(montantCommande);
        }

        double montantCommande2 = 68.8;
        for(Serveur s : listServeur2){
            s.prendreCommande(montantCommande2);
        }

        assertEquals(montantCommande *2 + montantCommande2 * 2, f.chiffreAffaires(),0);

    }
}
