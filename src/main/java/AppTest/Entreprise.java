package AppTest;

import java.util.ArrayList;
import java.util.List;

public class Entreprise {
    int chiffreAffaire;
    int nbEmploye;
    List<Employe> listEmpl;

    public Entreprise() {
        this.chiffreAffaire = 0;
        this.nbEmploye = 0;
        listEmpl = new ArrayList<>();
    }


    public void ajoutChiffreAffaire(int a){
        chiffreAffaire+= a;
    }

    public int getChiffreAffaire() {
        return chiffreAffaire;
    }

    public int getEmploye() {
        return nbEmploye;
    }

    public List<Employe> getListEmpl() {
        return listEmpl;
    }

    public void ajouteEmploye(Employe e){
        listEmpl.add(e);
        nbEmploye++;
    }

    public void payerSalaires(){
        for(Employe e : listEmpl){
            e.ajoutSalaire(1500);
        }
    }
}
