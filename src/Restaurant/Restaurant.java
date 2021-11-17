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

    public Serveur getMaitreHotel() {
        return MaitreHotel;
    }

    public ArrayList<Table> getListTable() {
        return listTable;
    }

    public int getTable() {
        return table;
    }

    public double chiffreAffaires(){
        double sum = 0;
        for(Serveur s: listServeurs){
            sum += s.getChiffreAffaires();
        }
        return sum;
    }

}
