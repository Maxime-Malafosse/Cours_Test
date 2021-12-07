package Restaurant;

import java.util.ArrayList;

public class Restaurant {
    ArrayList<Serveur> listServeurs;
    Serveur MaitreHotel;
    ArrayList<Table> listTable;

    int table;

    public Restaurant(ArrayList<Serveur> serveurs,Serveur maitreHotel ,int nombreTable) {
        listServeurs = serveurs;
        MaitreHotel = maitreHotel;
        listTable = new ArrayList<Table>();
        table = nombreTable;
    }

    public ArrayList<Serveur> getListServeurs() {
        return listServeurs;
    }

    public Serveur getMaitreHotel() {
        return MaitreHotel;
    }

    public ArrayList<Table> getListTable() {
        return listTable;
    }

    public int getTable() {
        return table;
    }

    public void ajoutTable(Table t){
        if(listTable.size() <= table){
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

    public double chiffreAffaires(){
        double sum = 0;
        for(Serveur s: listServeurs){
            sum += s.getChiffreAffaires();
        }
        return sum;
    }

}
