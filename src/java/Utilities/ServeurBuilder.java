package Utilities;

import Restaurant.*;

public class ServeurBuilder {

    public static Serveur stub = new ServeurBuilder().build();

    public Serveur build(){
        return new Serveur();
    }
}
