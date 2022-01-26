package Restaurant;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Serveur {
    double ChiffreAffaires;
    ArrayList<Commande> listCommandes;

    public Serveur() {
        ChiffreAffaires = 0;
        listCommandes = new ArrayList<Commande>();
    }

    public Serveur(ArrayList<Commande> c) {
        listCommandes = c;
        for(Commande e : listCommandes){
            ChiffreAffaires += e.getPrixCommande();
        }
    }
    public void PrendreCommande(Commande c){
        listCommandes.add(c);
        ChiffreAffaires += c.getPrixCommande();
    }


    public double getChiffreAffaires() {
        return ChiffreAffaires;
    }

    public void prendreCommande(double montantCommande){
            ChiffreAffaires += montantCommande;
    }

}
