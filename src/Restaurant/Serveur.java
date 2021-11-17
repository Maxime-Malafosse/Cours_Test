package Restaurant;

public class Serveur {
    String name;
    double ChiffreAffaires;

    public Serveur(String name) {
        this.name = name;
        ChiffreAffaires = 0;
    }

    public double getChiffreAffaires() {
        return ChiffreAffaires;
    }

    public void prendreCommande(double montantCommande){
            ChiffreAffaires += montantCommande;
    }

}
