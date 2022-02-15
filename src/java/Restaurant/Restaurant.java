package Restaurant;

import java.util.ArrayList;

public class Restaurant {
    private ArrayList<Serveur> listServeurs;
    private ArrayList<Table> listTable;
    private int table;
    private Cuisine cuisine;

    public Restaurant(ArrayList<Serveur> serveurs,int nombreTable) {
        listServeurs = serveurs;
        listTable = new ArrayList<Table>();
        table = nombreTable;
        cuisine = new Cuisine();

        for(Serveur s : listServeurs){
            for(Commande c : s.getListCommandes()){
                for(Nourriture n : c.getListNourriture() ){
                    cuisine.ajouteTache(n);
                }
            }
        }
    }

    public ArrayList<Serveur> getListServeurs() {
        return listServeurs;
    }

    public ArrayList<Table> getListTable() {
        return listTable;
    }

    public int getTable() {
        return table;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void ajoutTable(Table t){
        if(listTable.size() != table){
            listTable.add(t);
        }
        else{
            System.out.println("La table n'est pas ajoutée car ce restaurant a déjà dépassé la limite");
        }
    }

    public void ajoutTable(ArrayList<Table> t){
        if(t.size() <= table){
            listTable = new ArrayList<Table>(t);
        }
        else{
            System.out.println("La table n'est pas ajoutée car ce restaurant a déjà dépassé la limite");
        }
    }

    public void prendreCommande(Commande c,Serveur s){
        if(listServeurs.contains(s)){
            s.PrendreCommande(c);
            for(Nourriture n : c.getListNourriture()){
                cuisine.ajouteTache(n);
            }
        }
        else{
            System.out.println("Le serveur n'est pas inscrit dans le registre du restaurant");
        }

    }

    public void ajoutServeur(Serveur s){
        listServeurs.add(s);
        for(Commande c : s.getListCommandes()){
            for(Nourriture n : c.getListNourriture()){
                cuisine.ajouteTache(n);
            }
        }
    }

    public double chiffreAffaires(){
        double sum = 0;
        for(Serveur s: listServeurs){
            sum += s.getChiffreAffaires();
        }
        return sum;
    }

}
