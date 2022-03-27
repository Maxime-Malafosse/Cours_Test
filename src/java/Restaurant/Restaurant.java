package Restaurant;

import java.util.ArrayList;

public class Restaurant {
    private ArrayList<Serveur> listServeurs;
    private ArrayList<Table> listTable;
    private ArrayList<Commande> commandeATransmettre;
    private Serveur maitreHotel;
    private int table;
    private boolean service;
    private Cuisine cuisine;
    private Epinglage epinglage;

    public Restaurant(ArrayList<Serveur> serveurs,int nombreTable) {
        listServeurs = serveurs;
        listTable = new ArrayList<Table>();
        commandeATransmettre = new ArrayList<Commande>();
        table = nombreTable;
        maitreHotel = new Serveur();
        cuisine = new Cuisine();
        service = false;
        epinglage = new Epinglage();

        for(Serveur s : listServeurs){
            for(Commande c : s.getListCommandes()){
                for(Nourriture n : c.getListNourriture() ){
                    cuisine.ajouteTache(n);
                }
            }
        }
        for (int i = 0; i < table ; i++) {
            listTable.add(new Table());
        }
    }

    public Serveur getMaitreHotel() {
        return maitreHotel;
    }

    public Epinglage getEpinglage() {
        return epinglage;
    }

    public ArrayList<Commande> getCommandeATransmettre() {
        return commandeATransmettre;
    }

    public ArrayList<Serveur> getListServeurs() {
        return listServeurs;
    }

    public ArrayList<Table> getListTable() {
        return listTable;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void ajoutTable(Table t){
        if(service = false) {
            if (listTable.size() != table && listServeurs.contains(t.getAffectation())) {
                listTable.add(t);
            } else {
                System.out.println("La table n'est pas ajoutée car ce restaurant a déjà dépassé la limite");
            }
        }
        else{
            System.out.println("Pas de table ajoutée pendant le service");
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

    public void setAffectationTable(Table t, Serveur s){
        if(!service) {
            if (listTable.contains(t) && listServeurs.contains(s)) {
                t.setAffectation(s);
            } else {
                System.out.println("La table ou le serveur n'existe pas dans le restaurant");
            }
        }
        else{
            System.out.println("Interdit de changer l'affectation des tables durant le service");
        }

    }
    public void debutService(){
        if(!service) {
            for (Table t : listTable) {
                if (t.getAffectation() == null) {
                    t.setAffectation(maitreHotel);
                }
            }
            service = true;
        }
        else{
            System.out.println("Le service est déjà démarré");
        }
    }
    public void finService(){
        service = false;
    }

    public void commandeDeclareNonPayee(Serveur s,Commande c){
        if(listServeurs.contains(s)){
            if(s.DeclareNonPayee(c)){
                epinglage.ajoutCommande(c);
                if(c.isaTransmettre()){
                    commandeATransmettre.add(c);
                }
            }
        }
        else{
            System.out.println("Le serveur n'existe pas");
        }
    }
    public void commandeTransmiseGendarmerie(Serveur s,Commande c){
        if(listServeurs.contains(s)){
            if(s.getListCommandes().contains(c) && c.isaTransmettre()){
                s.setJour(0,c);
                commandeATransmettre.remove(c);
            }
            else{
                System.out.println("La commande n'existe pas");
            }
        }
        else{
            System.out.println("Le serveur n'existe pas");
        }
    }

    public void ajoutServeur(Serveur s){
        listServeurs.add(s);
        for(Commande c : s.getListCommandes()){
            for(Nourriture n : c.getListNourriture()){
                cuisine.ajouteTache(n);
            }
            if(c.getDeclare() == 1){
                commandeDeclareNonPayee(s,c);
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
