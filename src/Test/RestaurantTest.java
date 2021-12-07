package Test;
import Utilities.FranchiseBuilder;
import Utilities.RestaurantBuilder;
import org.junit.BeforeClass;
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
        Restaurant r = new RestaurantBuilder().ayantXServeurs(2).build();


        //Quand chacun prend une commande
        double montantCommande = 67.8;
        for(Serveur s : r.getListServeurs()){
            s.prendreCommande(montantCommande);
        }

        assertEquals(montantCommande + montantCommande, r.chiffreAffaires(),0);
    }

    @Test
    public void Franchise(){
        Franchise f =  new FranchiseBuilder().ayantXRestaurantXServeur(2,3).build();


        //Quand chacun prend une commande
        double montantCommande = 67.8;
        for(Serveur s : f.getListRestau().get(0).getListServeurs()){
            s.prendreCommande(montantCommande);
        }

        double montantCommande2 = 68.8;
        for(Serveur s : f.getListRestau().get(1).getListServeurs()){
            s.prendreCommande(montantCommande2);
        }

        assertEquals(montantCommande *3 + montantCommande2 * 3, f.chiffreAffaires(),0);

    }
    @Test
    public void AvantService_Initial(){
        Restaurant r = new RestaurantBuilder().ayantXServeurs(3).build();

        assertEquals(r.getListTable().size(),0);
    }

    @Test
    public void Ajout_table(){
        Restaurant r = new RestaurantBuilder().ayantXServeurs(3).build();
        ArrayList<Table> listTable = new ArrayList<Table>();
        listTable.add(new Table(1,r.getListServeurs().get(0)));
        listTable.add(new Table(2,r.getListServeurs().get(1)));
        r.ajoutTable(listTable);

        assertEquals(r.getListTable().size(),2);
    }

    @Test
    public void Ajout_tableList_plus_grand_que_restaurant(){
        ArrayList<Serveur> listServeur= new ArrayList<>();
        listServeur.add(new Serveur());
        listServeur.add(new Serveur());
        listServeur.add(new Serveur());
        listServeur.add(new Serveur());
        Serveur maitreHotel = new Serveur();
        ArrayList<Table> listTable = new ArrayList<Table>();
        listTable.add(new Table(1,listServeur.get(0)));
        listTable.add(new Table(2,listServeur.get(1)));
        listTable.add(new Table(3,listServeur.get(2)));
        listTable.add(new Table(4,listServeur.get(3)));
        Restaurant r = new RestaurantBuilder().ayantXServeurs(3).build();
        r.ajoutTable(listTable);

        assertEquals(r.getListTable().size(),0);
    }

    @Test
    public void Ajout_table_plus_grand_que_restaurant(){
        ArrayList<Serveur> listServeur= new ArrayList<>();
        listServeur.add(new Serveur());
        listServeur.add(new Serveur());
        listServeur.add(new Serveur());
        listServeur.add(new Serveur());

        ArrayList<Table> listTable = new ArrayList<Table>();
        listTable.add(new Table(1,listServeur.get(0)));
        listTable.add(new Table(2,listServeur.get(1)));
        listTable.add(new Table(3,listServeur.get(2)));
        listTable.add(new Table(4,listServeur.get(3)));

        Restaurant r = new RestaurantBuilder().ayantXServeurs(3).build();

        r.ajoutTable(listTable.get(0));
        r.ajoutTable(listTable.get(1));
        r.ajoutTable(listTable.get(2));
        r.ajoutTable(listTable.get(3));

        assertEquals(r.getListTable().size(),3);
    }

    @Test
    public void Service_Initial(){
        ArrayList<Serveur> listServeur= new ArrayList<>();
        listServeur.add(new Serveur());
        listServeur.add(new Serveur());
        Serveur maitreHotel = new Serveur();
        Restaurant r = new Restaurant(listServeur,maitreHotel,3);
        Service s = new Service(r);
        s.debutService();

        for(Table t: r.getListTable()){
            assertEquals(t.getAffectation(),r.getMaitreHotel());
        }
    }
}
