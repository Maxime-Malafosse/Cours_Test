package starter;

import AppTest.*;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class mainTest {

    @Test

    public void testCalcul(){
        Random r = new Random();

        int a = r.nextInt(500);
        int b = r.nextInt(500);
        int calcul = main.calcul(a,b);
        System.out.println(a+" "+b);
        assertEquals(a+b,calcul);
    }
    @Test
    public void testGrand(){
        Random r = new Random();
        int a = r.nextInt(500);
        int b = r.nextInt(500);
        int calcul = main.calcul(a,b);
        System.out.println(a+" "+b);
        assertTrue(main.plusOuEgal100(calcul));
    }
    @Test
    public void pasChiffreEntre(){
        Entreprise e = new Entreprise();

        assertEquals(0,e.getChiffreAffaire());
    }
    @Test
    public void ajoutEmploye(){
        Entreprise e = new Entreprise();
        Employe ea = new Employe("ooo");
        e.ajouteEmploye(ea);
        assertEquals(1,e.getEmploye());
    }
    @Test
    public void ajoutSalaire(){
        Entreprise e = new Entreprise();
        Employe ea = new Employe("ooo");
        Employe aaa = new Employe("aaa");
        e.ajouteEmploye(ea);
        e.ajouteEmploye(aaa);
        e.payerSalaires();
        assertEquals(e.getListEmpl().get(0).getArgent(),1500);
        assertEquals(e.getListEmpl().get(1).getArgent(),1500);
    }

    @Test
    public void ajoutSalairex2(){
        Entreprise e = new Entreprise();
        Employe ea = new Employe("ooo");
        Employe aaa = new Employe("aaa");
        e.ajouteEmploye(ea);
        e.ajouteEmploye(aaa);
        e.payerSalaires();
        e.payerSalaires();
        assertEquals(e.getListEmpl().get(0).getArgent(),3000);
        assertEquals(e.getListEmpl().get(1).getArgent(),3000);
    }




}
