package Restaurant;

import java.util.ArrayList;

public class Restaurant {
    private ArrayList<Serveur> listServeurs;
    private ArrayList<Table> listTable;
    private ArrayList<Table> listTableLibre;
    private ArrayList<Commande> commandeATransmettre;
    private Serveur maitreHotel;
    private int table;
    private boolean service;
    private Cuisine cuisine;
    private Epinglage epinglage;
    private Menu menu;
    private boolean statutFiliale;

    public Restaurant(ArrayList<Serveur> serveurs,int nombreTable) {
        listServeurs = serveurs;
        listTable = new ArrayList<Table>();
        listTableLibre = new ArrayList<Table>();
        commandeATransmettre = new ArrayList<Commande>();
        table = nombreTable;
        maitreHotel = new Serveur();
        cuisine = new Cuisine();
        service = false;
        epinglage = new Epinglage();
        menu = new Menu();
        statutFiliale = false;

        for(Serveur s : listServeurs){
            for(Commande c : s.getListCommandes()){
                for(Nourriture n : c.getListNourriture() ){
                    cuisine.ajouteTache(n);
                }
            }
        }
        for (int i = 0; i < table ; i++) {
            Table t = new Table();
            listTable.add(t);
            listTableLibre.add(t);
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

    public ArrayList<Table> getListTableLibre() {
        return listTableLibre;
    }

    public int getTable() {
        return table;
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

    public void setStatutFilialeToTrue(){
        statutFiliale = true;
    }

    public void setStatutFilialeToFalse(){
        statutFiliale = false;
    }

    public boolean isStatutFiliale() {
        return statutFiliale;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }
    public void ajoutPlat(Plat p){
        menu.ajoutPlat(p);
    }
    public void removePlat(Plat p){
        menu.removePlat(p);
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

    public void affecteClientTable(Client c, Table t){
        if(service){
            if(listTableLibre.contains(t)){
                t.setClient(c);
                listTableLibre.remove(t);
            }
            else{
                System.out.println("La table n'existe pas ou n'est pas libre");
            }
        }
        else{
            System.out.println("Le service n'est pas démarré");
        }
    }

    public void libereClientTable(Table t){
        if(service){
            if(listTable.contains(t)){
                if(!(t.libereClient())){
                    System.out.println("La table n'avait pas encore de client");
                }
                else{
                    listTableLibre.add(t);
                }
            }
            else{
                System.out.println("La table n'existe pas");
            }
        }
        else{
            System.out.println("Le service n'est pas encore démarré");
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
