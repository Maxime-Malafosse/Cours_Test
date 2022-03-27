import Restaurant.Restaurant;
import Utilities.RestaurantBuilder;
import org.junit.Assert;
import org.junit.Test;

public class DebutServiceScopeTest {
   // ÉTANT DONNE un restaurant ayant 3 tables
   // QUAND le service commence
   // ALORS elles sont toutes affectées au Maître d'Hôtel
    @Test
    public void Restaurant_avec_3_tables_sans_serveur(){
        Restaurant r = new RestaurantBuilder().ayantXServeursXTable(3,3).build();
        r.debutService();

        Assert.assertEquals(r.getMaitreHotel(),r.getListTable().get(0).getAffectation());
        Assert.assertEquals(r.getMaitreHotel(),r.getListTable().get(1).getAffectation());
        Assert.assertEquals(r.getMaitreHotel(),r.getListTable().get(2).getAffectation());
    }

   // ÉTANT DONNÉ un restaurant ayant 3 tables dont une affectée à un serveur
   // QUAND le service débute
   // ALORS cette table est toujours affectée au serveur et les deux autres au maître d'hôtel

    @Test
    public void Restaurant_avec_3_tables_avec_un_serveur(){
        Restaurant r = new RestaurantBuilder().ayantXServeursXTable(1,3).build();
        r.setAffectationTable(r.getListTable().get(0),r.getListServeurs().get(0) );
        r.debutService();

        Assert.assertEquals(r.getListServeurs().get(0),r.getListTable().get(0).getAffectation());
        Assert.assertEquals(r.getMaitreHotel(),r.getListTable().get(1).getAffectation());
        Assert.assertEquals(r.getMaitreHotel(),r.getListTable().get(2).getAffectation());
    }

    // ÉTANT DONNÉ un restaurant ayant 3 tables dont une affectée à un serveur
    //   QUAND le service débute
   // ALORS il n'est pas possible de modifier le serveur affecté aux tables

    @Test
    public void Restaurant_avec_3_tables_avec_un_serveur_debut_service(){
        Restaurant r = new RestaurantBuilder().ayantXServeursXTable(2,3).build();
        r.setAffectationTable(r.getListTable().get(0),r.getListServeurs().get(0));
        r.debutService();

        r.setAffectationTable(r.getListTable().get(1),r.getListServeurs().get(1));

        Assert.assertEquals(r.getListServeurs().get(0),r.getListTable().get(0).getAffectation());
        Assert.assertEquals(r.getMaitreHotel(),r.getListTable().get(1).getAffectation());
        Assert.assertEquals(r.getMaitreHotel(),r.getListTable().get(2).getAffectation());
    }
   // ÉTANT DONNÉ un restaurant ayant 3 tables dont une affectée à un premier serveur
   // ET ayant débuté son service
   // QUAND le service se termine
   // ET que cette table est affectée à un second serveur
   // ALORS la table éditée est affectée au serveur et les deux autres au maître d'hôtel

    @Test
    public void Restaurant_avec_3_tables_avec_un_serveur_fin_service(){
        Restaurant r = new RestaurantBuilder().ayantXServeursXTable(2,3).build();

        r.setAffectationTable(r.getListTable().get(0),r.getListServeurs().get(0));
        r.debutService();
        r.finService();
        r.setAffectationTable(r.getListTable().get(0),r.getListServeurs().get(1));

        Assert.assertEquals(r.getListServeurs().get(1),r.getListTable().get(0).getAffectation());
        Assert.assertEquals(r.getMaitreHotel(),r.getListTable().get(1).getAffectation());
        Assert.assertEquals(r.getMaitreHotel(),r.getListTable().get(2).getAffectation());
    }
}
