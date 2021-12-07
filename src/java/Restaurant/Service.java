package Restaurant;

public class Service {
    Restaurant r;

    public Service(Restaurant r) {
        this.r = r;
    }

    public void affectionTable(Serveur s, int id){
        r.getListTable().add(new Table(id,s));
    }

    public void debutService(){

        for (int i = r.getListTable().size(); i < r.getTable(); i++) {
            r.getListTable().add(new Table(i,r.getMaitreHotel()));
        }
    }
}
