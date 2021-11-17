package Test;
import org.junit.Test;
import Restaurant.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RestaurantTest {
    @Test
    public void Serveur_initial(){
        Serveur s = new Serveur("oui");
        double chiffreAffaire = s.getChiffreAffaires();

        assertEquals(0,chiffreAffaire,0);
    }

    @Test
    public void Serveur_increment(){
        double montantCommande = 64.5;
        Serveur s = new Serveur("oui");
        s.prendreCommande(montantCommande);
        assertEquals(montantCommande,s.getChiffreAffaires(),0);
    }

    @Test
    public void Serveur_2_commandes(){

      Serveur s = new Serveur("oui");
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
        listServeur.add(new Serveur("oui"));
        listServeur.add(new Serveur("non"));
        Serveur maitreHotel = new Serveur("ouinon");
        Restaurant r = new Restaurant(listServeur,maitreHotel,3);

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
        listServeur.add(new Serveur("oui"));
        listServeur.add(new Serveur("non"));
        Serveur maitreHotel = new Serveur("ouinon");
        Restaurant r = new Restaurant(listServeur,maitreHotel,5);

        ArrayList<Serveur> listServeur2= new ArrayList<>();
        listServeur2.add(new Serveur("aaa"));
        listServeur2.add(new Serveur("bbb"));
        Serveur maitreHotel2 = new Serveur("aaabbb");
        Restaurant r2 = new Restaurant(listServeur2,maitreHotel2,5);

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
    @Test
    public void AvantService_Initial(){
        ArrayList<Serveur> listServeur= new ArrayList<>();
        listServeur.add(new Serveur("oui"));
        listServeur.add(new Serveur("non"));
        Serveur maitreHotel = new Serveur("ouinon");
        Restaurant r = new Restaurant(listServeur,maitreHotel,3);

        assertEquals(r.getListTable().size(),0);
    }
    @Test
    public void Service_Initial(){
        ArrayList<Serveur> listServeur= new ArrayList<>();
        listServeur.add(new Serveur("oui"));
        listServeur.add(new Serveur("non"));
        Serveur maitreHotel = new Serveur("ouinon");
        Restaurant r = new Restaurant(listServeur,maitreHotel,3);
        Service s = new Service(r);
        s.debutService();

        for(Table t: r.getListTable()){
            assertEquals(t.getAffectation(),r.getMaitreHotel());
        }
    }
}
