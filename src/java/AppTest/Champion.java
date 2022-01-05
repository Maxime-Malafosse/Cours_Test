package AppTest;

public class Champion {
    String nom;
    String role;
    String voie;

    public Champion(String nom, String role) {
        this.nom = nom;
        this.role = role;
        this.voie = appliqueVoieEnFonctionRole(this.role);
    }

    public Champion(String nom, String role, String voie) {
        this.nom = nom;
        this.role = role;
        this.voie = voie;
    }

    public String appliqueVoieEnFonctionRole(String role) {
        String lane = "Aram";
        switch (role) {
            case "adc":
                lane = "Botlane";
                break;
            case "supp":
                lane = "Botlane";
                break;
            case "mid":
                lane = "Midlane";
                break;
            case "jgl":
                lane = "Jungle";
                break;
            case "top":
                lane = "Toplane";
                break;
        }
        return lane;
    }

    public String getNom() {
        return nom;
    }

    public String getRole() {
        return role;
    }

    public String getVoie() {
        return voie;
    }
}
