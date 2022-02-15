package Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Cuisine {
    private List<Nourriture> tache;

    public Cuisine() {
        tache = new ArrayList<Nourriture>();
    }

    public void ajouteTache(Nourriture c){
        tache.add(c);
    }

    public List<Nourriture> getTache() {
        return tache;
    }
}
