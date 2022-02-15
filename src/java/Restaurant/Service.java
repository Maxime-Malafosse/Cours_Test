package Restaurant;

public class Service {
    private Restaurant r;

    public Service(Restaurant r) {
        this.r = r;
    }

    public void affectionTable(Serveur s, int id){
        r.getListTable().add(new Table(id,s));
    }

    public void debutService(){

    }
}
