import Restaurant.Serveur;
import Utilities.CommandeBuilder;
import Utilities.ServeurBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ServeurScopeTest {

    //ÉTANT DONNÉ un nouveau serveur
    //QUAND on récupére son chiffre d'affaires
    //ALORS celui-ci est à 0
    @Test
    public void Serveur_Avec_0_Commande() {
        //ÉTANT DONNÉ un nouveau serveur
        Serveur s = new ServeurBuilder().build();
        //QUAND on récupére son chiffre d'affaires
        double chiffre  = s.getChiffreAffaires();
        //ALORS celui-ci est à 0
        assertEquals(0, chiffre,0);
    }

    //ÉTANT DONNÉ un nouveau serveur
    //QUAND il prend une commande
    //ALORS son chiffre d'affaires est le montant de celle-ci
    @Test
    public void Serveur_Avec_1_Commande() {
        //ÉTANT DONNÉ un nouveau serveur
        Serveur s = new ServeurBuilder().build();
        //QUAND il prend une commande
        s.PrendreCommande(new CommandeBuilder().AyantXNourritureAvecXPrix(2,3).build());
        //ALORS son chiffre d'affaires est le montant de celle-ci
        assertEquals(6, s.getChiffreAffaires(),0);
    }
    //ÉTANT DONNÉ un serveur ayant déjà pris une commande
    //QUAND il prend une nouvelle commande
    //ALORS son chiffre d'affaires est la somme des deux commandes
    @Test
    public void Serveur_Avec_2_Commandes() {
        //ÉTANT DONNÉ un serveur ayant déjà pris une commande
        Serveur s = new ServeurBuilder().AyantXCommandeAyantXBoissonAyantXprix(1,2,3).build();
        //QUAND il prend une nouvelle commande
        s.PrendreCommande(new CommandeBuilder().AyantXNourritureAvecXPrix(3,5).build());
        //ALORS son chiffre d'affaires est la somme des deux commandes
        assertEquals(21, s.getChiffreAffaires(),0);
    }

}
