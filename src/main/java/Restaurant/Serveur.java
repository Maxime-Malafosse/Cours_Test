package Restaurant;

public class Serveur {
    double ChiffreAffaires;

    public Serveur() {
        ChiffreAffaires = 0;
    }

    public double getChiffreAffaires() {
        return ChiffreAffaires;
    }

    public void prendreCommande(double montantCommande){
            ChiffreAffaires += montantCommande;
    }

}
