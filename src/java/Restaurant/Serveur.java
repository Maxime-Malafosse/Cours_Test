package Restaurant;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Serveur {
    private double ChiffreAffaires;
    private ArrayList<Commande> listCommandes;

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

    public boolean DeclareNonPayee(Commande c){
        if (listCommandes.contains(c)){
          c.declareNonPayee();
          return true;
        }
        else {
            System.out.println("La commande n'existe pas");
            return false;
        }
    }

    public ArrayList<Commande> getListCommandes() {
        return listCommandes;
    }

    public double getChiffreAffaires() {
        return ChiffreAffaires;
    }

    public void setJour(int jour,Commande c){
        if(listCommandes.contains(c)){
            c.setJours(jour);
        }
        else{
            System.out.println("La commande n'existe pas");
        }
    }

    public void prendreCommande(double montantCommande){
            ChiffreAffaires += montantCommande;
    }

}
