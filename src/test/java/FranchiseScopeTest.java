import Restaurant.Franchise;
import Utilities.FranchiseBuilder;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class FranchiseScopeTest {
    /*
    * SCOPE Franchise
		ÉTANT DONNÉ une franchise ayant X restaurants de Y serveurs chacuns
		QUAND tous les serveurs prennent une commande d'un montant Z
		ALORS le chiffre d'affaires de la franchise est X * Y * Z
		CAS(X = 0; X = 1; X = 2; X = 1000)
		CAS(Y = 0; Y = 1; Y = 2; Y = 1000)
		CAS(Z = 1.0)
    * */

    @Test
    public void Franchise_Avec_0_Restaurant_de_0_Serveur_1_Commande() {
        //Etant donné une franchise ayant 0 restaurants de 0 serveurs
        Franchise franchise =  new FranchiseBuilder().ayantXRestaurantXServeurAvecXCommandesAvecUnMontantDeX(0,0, 1, 1).build();
        assertEquals(0, franchise.chiffreAffaires(),0);
    }
    @Test
    public void Franchise_Avec_0_Restaurant_de_1_Serveur_1_Commande() {
        //Etant donné une franchise ayant 0 restaurants de 0 serveurs
        Franchise franchise =  new FranchiseBuilder().ayantXRestaurantXServeurAvecXCommandesAvecUnMontantDeX(0,1, 1, 1).build();

        assertEquals(0, franchise.chiffreAffaires(),0);
    }
    @Test
    public void Franchise_Avec_0_Restaurant_de_2_Serveur_1_Commande() {
        //Etant donné une franchise ayant 0 restaurants de 0 serveurs
        Franchise franchise =  new FranchiseBuilder().ayantXRestaurantXServeurAvecXCommandesAvecUnMontantDeX(0,2, 1, 1).build();

        assertEquals(0, franchise.chiffreAffaires(),0);
    }
    @Test
    public void Franchise_Avec_0_Restaurant_de_1000_Serveur_1_Commande() {
        //Etant donné une franchise ayant 0 restaurants de 0 serveurs
        Franchise franchise =  new FranchiseBuilder().ayantXRestaurantXServeurAvecXCommandesAvecUnMontantDeX(0,1000, 1, 1).build();

        assertEquals(0, franchise.chiffreAffaires(),0);
    }

    /*Avec 1 Restaurant*/
    @Test
    public void Franchise_Avec_1_Restaurant_de_0_Serveur_1_Commande() {
        //Etant donné une franchise ayant 0 restaurants de 0 serveurs
        Franchise franchise =  new FranchiseBuilder().ayantXRestaurantXServeurAvecXCommandesAvecUnMontantDeX(1,0, 1, 1).build();

        assertEquals(0, franchise.chiffreAffaires(),0);
    }
    @Test
    public void Franchise_Avec_1_Restaurant_de_1_Serveur_1_Commande() {
        //Etant donné une franchise ayant 0 restaurants de 0 serveurs
        Franchise franchise =  new FranchiseBuilder().ayantXRestaurantXServeurAvecXCommandesAvecUnMontantDeX(1,1, 1, 1).build();

        assertEquals(1, franchise.chiffreAffaires(),0);
    }
    @Test
    public void Franchise_Avec_1_Restaurant_de_2_Serveur_1_Commande() {
        //Etant donné une franchise ayant 0 restaurants de 0 serveurs
        Franchise franchise =  new FranchiseBuilder().ayantXRestaurantXServeurAvecXCommandesAvecUnMontantDeX(1,2, 1, 1).build();

        assertEquals(2, franchise.chiffreAffaires(),0);
    }
    @Test
    public void Franchise_Avec_1_Restaurant_de_1000_Serveur_1_Commande() {
        //Etant donné une franchise ayant 0 restaurants de 0 serveurs
        Franchise franchise =  new FranchiseBuilder().ayantXRestaurantXServeurAvecXCommandesAvecUnMontantDeX(1,1000, 1, 1).build();

        assertEquals(1000, franchise.chiffreAffaires(),0);
    }

    /*Avec 2 Restaurant*/
    @Test
    public void Franchise_Avec_2_Restaurant_de_0_Serveur_1_Commande() {
        //Etant donné une franchise ayant 0 restaurants de 0 serveurs
        Franchise franchise =  new FranchiseBuilder().ayantXRestaurantXServeurAvecXCommandesAvecUnMontantDeX(2,0, 1, 1).build();

        assertEquals(0, franchise.chiffreAffaires(),0);
    }
    @Test
    public void Franchise_Avec_2_Restaurant_de_1_Serveur_1_Commande() {
        //Etant donné une franchise ayant 0 restaurants de 0 serveurs
        Franchise franchise =  new FranchiseBuilder().ayantXRestaurantXServeurAvecXCommandesAvecUnMontantDeX(2,1, 1, 1).build();

        assertEquals(2, franchise.chiffreAffaires(),0);
    }
    @Test
    public void Franchise_Avec_2_Restaurant_de_2_Serveur_1_Commande() {
        //Etant donné une franchise ayant 0 restaurants de 0 serveurs
        Franchise franchise =  new FranchiseBuilder().ayantXRestaurantXServeurAvecXCommandesAvecUnMontantDeX(2,2, 1, 1).build();

        assertEquals(4, franchise.chiffreAffaires(),0);
    }
    @Test
    public void Franchise_Avec_2_Restaurant_de_1000_Serveur_1_Commande() {
        //Etant donné une franchise ayant 0 restaurants de 0 serveurs
        Franchise franchise =  new FranchiseBuilder().ayantXRestaurantXServeurAvecXCommandesAvecUnMontantDeX(2,1000, 1, 1).build();

        assertEquals(2000, franchise.chiffreAffaires(),0);
    }

    /*Avec 1000 Restaurant*/
    @Test
    public void Franchise_Avec_1000_Restaurant_de_0_Serveur_1_Commande() {
        //Etant donné une franchise ayant 0 restaurants de 0 serveurs
        Franchise franchise =  new FranchiseBuilder().ayantXRestaurantXServeurAvecXCommandesAvecUnMontantDeX(1000,0, 1, 1).build();

        assertEquals(0, franchise.chiffreAffaires(),0);
    }
    @Test
    public void Franchise_Avec_1000_Restaurant_de_1_Serveur_1_Commande() {
        //Etant donné une franchise ayant 0 restaurants de 0 serveurs
        Franchise franchise =  new FranchiseBuilder().ayantXRestaurantXServeurAvecXCommandesAvecUnMontantDeX(1000,1, 1, 1).build();

        assertEquals(1000, franchise.chiffreAffaires(),0);
    }
    @Test
    public void Franchise_Avec_1000_Restaurant_de_2_Serveur_1_Commande() {
        //Etant donné une franchise ayant 0 restaurants de 0 serveurs
        Franchise franchise =  new FranchiseBuilder().ayantXRestaurantXServeurAvecXCommandesAvecUnMontantDeX(1000,2, 1, 1).build();

        assertEquals(2000, franchise.chiffreAffaires(),0);
    }
    @Test
    public void Franchise_Avec_1000_Restaurant_de_1000_Serveur_1_Commande() {
        //Etant donné une franchise ayant 0 restaurants de 0 serveurs
        Franchise franchise =  new FranchiseBuilder().ayantXRestaurantXServeurAvecXCommandesAvecUnMontantDeX(1000,1000, 1, 1).build();

        assertEquals(1000000, franchise.chiffreAffaires(),0);
    }

}
